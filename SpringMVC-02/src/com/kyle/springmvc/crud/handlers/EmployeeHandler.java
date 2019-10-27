package com.kyle.springmvc.crud.handlers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyle.springmvc.crud.dao.DepartmentDao;
import com.kyle.springmvc.crud.dao.EmployeeDao;
import com.kyle.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler {
	
    @Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	@ModelAttribute     //这里的id是在input.jsp里的那个隐藏域传来的id
	public void getEmployee(@RequestParam(value="id",required = false) Integer id,Map<String,Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
		
	}
	
	//修改操作
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect/emps";
	}
	
	//表单回显操作
	//特别注意:这是一个GET请求去getDepartments(),所以需要写value属性值,而不能再用那个默认的了
	@RequestMapping(value="/emp{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id,Map<String,Object> map){
		//此时这里要回显,要通过id获取对象进行回显
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	//删除操作
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect/emps";
	}
	
	//添加操作
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(@Valid Employee employee,Errors result,Map<String,Object> map){
		System.out.println("save"+employee);
		//类型转换出错时得到错误消息
		if(result.getErrorCount() > 0){
			System.out.println("出错了");
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField()+":"+error.getDefaultMessage());
			}
			//若验证出错,则转向定制的页面
			map.put("departments", departmentDao.getDepartments());
			return "input";
		}
		employeeDao.save(employee);
		return "redirect/emps";
	}
	
	//添加的目标页面操作
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		map.put("departments", departmentDao.getDepartments());
		//表示不需要表单回显就直接new 一个Employee
		map.put("employee", new Employee());
		return "input";
	}
	
	//查询list操作
	@RequestMapping("/emps")
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return"list";
	}
	
}
