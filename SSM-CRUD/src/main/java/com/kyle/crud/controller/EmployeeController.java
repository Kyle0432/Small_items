package com.kyle.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kyle.crud.bean.Employee;
import com.kyle.crud.bean.Msg;
import com.kyle.crud.service.EmployeeService;

/*
 * 处理员工CRUD请求
 */
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/*
	 * 单个批量二合一,那下面那个删除员工通过id来的就不需要了
	 * 批量删除:1-2-3
	 * 单个删除:1
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}", method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids") String ids){
		   //批量删除
		  if(ids.contains("-")){//表示带很多-的字符串id
			  List<Integer> del_ids = new ArrayList<>();
			  String[] str_ids = ids.split("-");
			  //组装id的集合
			  for (String string : str_ids) {
				  del_ids.add(Integer.parseInt(string));
			}
			  employeeService.deleteBatch(del_ids);
		  }else{//表示如果才一个字符id进行删除时,先进行转换类型
			  Integer id = Integer.parseInt(ids);
			  employeeService.deleteEmp(id);
		  }
		return Msg.success();
	}
	
	
	
	
/*	
	 * 删除员工信息
	 
	@ResponseBody
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	         //@PathVariable("id")表示取出id的值,转化为能用的id  
	public Msg deleteEmpById(@PathVariable("id") Integer id){
		employeeService.deleteEmp(id);
		return Msg.success();
	}*/
	
	
	/**
	 * 如果直接发送ajax=PUT形式的请求
	 * 封装的数据
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * 问题：
	 * 请求体中有数据；
	 * 但是Employee对象封装不上；
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * 原因：
	 * Tomcat：
	 * 		1、将请求体中的数据，封装一个map。
	 * 		2、request.getParameter("empName")就会从这个map中取值。
	 * 		3、SpringMVC封装POJO对象的时候。
	 * 				会把POJO中每个属性的值，request.getParamter("email");
	 * AJAX发送PUT请求引发的血案：
	 * 		PUT请求，请求体中的数据，request.getParameter("empName")拿不到
	 * 		Tomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * 解决方案；
	 * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
	 * 1、配置上HttpPutFormContentFilter；
	 * 2、他的作用；将请求体中的数据解析包装成一个map。
	 * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
	 * 员工更新方法
	 * @param employee
	 * @return
	 */
	
	/*
	 * 更新修改员工信息
	 * /emp/{empId}大括号里面的id必须要和employee对象里面的empId一样
	 */      
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg saveEmp(Employee employee){
		System.out.println("员工的数据:"+employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
	
	
	
	/*
	 * 通过员工id查询员工
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Integer id){
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	/*
	 * 检查用户名是否可用
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName")String empName){
		//先判断用户名是否是合法的表达式
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";	
		if(!empName.matches(regx)){
			return Msg.fail().add("va_msg","用户名必须是6-16位数字和字母的组合或者2-5位中文");
		}
		boolean b = employeeService.checkUser(empName);	
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "用户名不可用");
		}
	}
	
	/*
	 * 员工保存
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody//表示返回json数据
	//只需要在我们employee保存封装对象时,添加@Valid就能进行校验,因为校验的属性是在employee里面的
	//根据BindingResult result来判断 校验是否失败,以及错误信息的提示
	public Msg saveEmp(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()){
			Map<String,Object> map = new HashMap<>();
			//校验失败应该返回失败,还是在模态框中显示校验失败的错误信息
			List<FieldError> errors =  result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段名:"+fieldError.getField());
				System.out.println("错误信息:"+fieldError.getDefaultMessage());
				//K :为错误字段的名字   V: 表示错误信息
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}
	
	
	/*
	 * @ResponseBody该注解能自动的把返回的对象转为json字符串
	 * @ResponseBody要正常操作
	 * 需要导入jackson包,该包的作用是负者将PageInfo对象转化成json字符串
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue = "1") Integer pn){
	        //引入PageHelper分页插件
			//在查询之前只需要调用
			PageHelper.startPage(pn, 5);//表示从第几页开始查,每页有多少条数据
			//startPage后面紧跟着的查询就是一个分页查询
			List<Employee> emps = employeeService.getAll();
			//使用PageInfo来包装查询后的结果.只需要将PageInfo交给页面就行了
			//封装了详细的分页信息(例如  上一页 下一页   等等),传入连续显示的页数
			PageInfo page = new PageInfo<>(emps, 5);
			//此时浏览器会接收到返回json的字符串
	        return Msg.success().add("PageInfo", page);
	}
	
    /*
     * 查询员工数据(分页查询)
     */
	//@RequestMapping("/emps") //如果没传值就默认为1
	public String getEmps(@RequestParam(value="pn",defaultValue = "1") Integer pn,Model model){
		//引入PageHelper分页插件
		//在查询之前只需要调用
		PageHelper.startPage(pn, 5);//表示从第几页开始查,每页有多少条数据
		//startPage后面紧跟着的查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		//使用PageInfo来包装查询后的结果.只需要将PageInfo交给页面就行了
		//封装了详细的分页信息(例如  上一页 下一页   等等),传入连续显示的页数
		PageInfo page = new PageInfo<>(emps, 5);
		model.addAttribute("PageInfo", page);
		return "list";
	}
}
