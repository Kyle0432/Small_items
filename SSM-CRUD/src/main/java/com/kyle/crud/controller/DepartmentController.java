package com.kyle.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyle.crud.bean.Department;
import com.kyle.crud.bean.Msg;
import com.kyle.crud.service.DepartmentService;
/*
 * ����Ͳ����йص�����
 */
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	/*
	 * ���ز��ŵ�������Ϣ
	 */
	@RequestMapping("/depts")
	@ResponseBody//��ʾ���ظ������
	public Msg getDepts(){
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
}
