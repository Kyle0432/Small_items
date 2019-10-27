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
 * ����Ա��CRUD����
 */
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/*
	 * ������������һ,�������Ǹ�ɾ��Ա��ͨ��id���ľͲ���Ҫ��
	 * ����ɾ��:1-2-3
	 * ����ɾ��:1
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}", method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids") String ids){
		   //����ɾ��
		  if(ids.contains("-")){//��ʾ���ܶ�-���ַ���id
			  List<Integer> del_ids = new ArrayList<>();
			  String[] str_ids = ids.split("-");
			  //��װid�ļ���
			  for (String string : str_ids) {
				  del_ids.add(Integer.parseInt(string));
			}
			  employeeService.deleteBatch(del_ids);
		  }else{//��ʾ�����һ���ַ�id����ɾ��ʱ,�Ƚ���ת������
			  Integer id = Integer.parseInt(ids);
			  employeeService.deleteEmp(id);
		  }
		return Msg.success();
	}
	
	
	
	
/*	
	 * ɾ��Ա����Ϣ
	 
	@ResponseBody
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	         //@PathVariable("id")��ʾȡ��id��ֵ,ת��Ϊ���õ�id  
	public Msg deleteEmpById(@PathVariable("id") Integer id){
		employeeService.deleteEmp(id);
		return Msg.success();
	}*/
	
	
	/**
	 * ���ֱ�ӷ���ajax=PUT��ʽ������
	 * ��װ������
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * ���⣺
	 * �������������ݣ�
	 * ����Employee�����װ���ϣ�
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * ԭ��
	 * Tomcat��
	 * 		1�����������е����ݣ���װһ��map��
	 * 		2��request.getParameter("empName")�ͻ�����map��ȡֵ��
	 * 		3��SpringMVC��װPOJO�����ʱ��
	 * 				���POJO��ÿ�����Ե�ֵ��request.getParamter("email");
	 * AJAX����PUT����������Ѫ����
	 * 		PUT�����������е����ݣ�request.getParameter("empName")�ò���
	 * 		Tomcatһ����PUT�����װ�������е�����Ϊmap��ֻ��POST��ʽ������ŷ�װ������Ϊmap
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * ���������
	 * ����Ҫ��֧��ֱ�ӷ���PUT֮�������Ҫ��װ�������е�����
	 * 1��������HttpPutFormContentFilter��
	 * 2���������ã����������е����ݽ�����װ��һ��map��
	 * 3��request�����°�װ��request.getParameter()����д���ͻ���Լ���װ��map��ȡ����
	 * Ա�����·���
	 * @param employee
	 * @return
	 */
	
	/*
	 * �����޸�Ա����Ϣ
	 * /emp/{empId}�����������id����Ҫ��employee���������empIdһ��
	 */      
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg saveEmp(Employee employee){
		System.out.println("Ա��������:"+employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
	
	
	
	/*
	 * ͨ��Ա��id��ѯԱ��
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Integer id){
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	/*
	 * ����û����Ƿ����
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName")String empName){
		//���ж��û����Ƿ��ǺϷ��ı��ʽ
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";	
		if(!empName.matches(regx)){
			return Msg.fail().add("va_msg","�û���������6-16λ���ֺ���ĸ����ϻ���2-5λ����");
		}
		boolean b = employeeService.checkUser(empName);	
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "�û���������");
		}
	}
	
	/*
	 * Ա������
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody//��ʾ����json����
	//ֻ��Ҫ������employee�����װ����ʱ,���@Valid���ܽ���У��,��ΪУ�����������employee�����
	//����BindingResult result���ж� У���Ƿ�ʧ��,�Լ�������Ϣ����ʾ
	public Msg saveEmp(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()){
			Map<String,Object> map = new HashMap<>();
			//У��ʧ��Ӧ�÷���ʧ��,������ģ̬������ʾУ��ʧ�ܵĴ�����Ϣ
			List<FieldError> errors =  result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("������ֶ���:"+fieldError.getField());
				System.out.println("������Ϣ:"+fieldError.getDefaultMessage());
				//K :Ϊ�����ֶε�����   V: ��ʾ������Ϣ
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}
	
	
	/*
	 * @ResponseBody��ע�����Զ��İѷ��صĶ���תΪjson�ַ���
	 * @ResponseBodyҪ��������
	 * ��Ҫ����jackson��,�ð��������Ǹ��߽�PageInfo����ת����json�ַ���
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue = "1") Integer pn){
	        //����PageHelper��ҳ���
			//�ڲ�ѯ֮ǰֻ��Ҫ����
			PageHelper.startPage(pn, 5);//��ʾ�ӵڼ�ҳ��ʼ��,ÿҳ�ж���������
			//startPage��������ŵĲ�ѯ����һ����ҳ��ѯ
			List<Employee> emps = employeeService.getAll();
			//ʹ��PageInfo����װ��ѯ��Ľ��.ֻ��Ҫ��PageInfo����ҳ�������
			//��װ����ϸ�ķ�ҳ��Ϣ(����  ��һҳ ��һҳ   �ȵ�),����������ʾ��ҳ��
			PageInfo page = new PageInfo<>(emps, 5);
			//��ʱ���������յ�����json���ַ���
	        return Msg.success().add("PageInfo", page);
	}
	
    /*
     * ��ѯԱ������(��ҳ��ѯ)
     */
	//@RequestMapping("/emps") //���û��ֵ��Ĭ��Ϊ1
	public String getEmps(@RequestParam(value="pn",defaultValue = "1") Integer pn,Model model){
		//����PageHelper��ҳ���
		//�ڲ�ѯ֮ǰֻ��Ҫ����
		PageHelper.startPage(pn, 5);//��ʾ�ӵڼ�ҳ��ʼ��,ÿҳ�ж���������
		//startPage��������ŵĲ�ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		//ʹ��PageInfo����װ��ѯ��Ľ��.ֻ��Ҫ��PageInfo����ҳ�������
		//��װ����ϸ�ķ�ҳ��Ϣ(����  ��һҳ ��һҳ   �ȵ�),����������ʾ��ҳ��
		PageInfo page = new PageInfo<>(emps, 5);
		model.addAttribute("PageInfo", page);
		return "list";
	}
}
