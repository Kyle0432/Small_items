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
	
	@ModelAttribute     //�����id����input.jsp����Ǹ�����������id
	public void getEmployee(@RequestParam(value="id",required = false) Integer id,Map<String,Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
		
	}
	
	//�޸Ĳ���
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect/emps";
	}
	
	//�����Բ���
	//�ر�ע��:����һ��GET����ȥgetDepartments(),������Ҫдvalue����ֵ,�����������Ǹ�Ĭ�ϵ���
	@RequestMapping(value="/emp{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id,Map<String,Object> map){
		//��ʱ����Ҫ����,Ҫͨ��id��ȡ������л���
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	//ɾ������
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect/emps";
	}
	
	//��Ӳ���
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(@Valid Employee employee,Errors result,Map<String,Object> map){
		System.out.println("save"+employee);
		//����ת������ʱ�õ�������Ϣ
		if(result.getErrorCount() > 0){
			System.out.println("������");
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField()+":"+error.getDefaultMessage());
			}
			//����֤����,��ת���Ƶ�ҳ��
			map.put("departments", departmentDao.getDepartments());
			return "input";
		}
		employeeDao.save(employee);
		return "redirect/emps";
	}
	
	//��ӵ�Ŀ��ҳ�����
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		map.put("departments", departmentDao.getDepartments());
		//��ʾ����Ҫ�����Ծ�ֱ��new һ��Employee
		map.put("employee", new Employee());
		return "input";
	}
	
	//��ѯlist����
	@RequestMapping("/emps")
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return"list";
	}
	
}
