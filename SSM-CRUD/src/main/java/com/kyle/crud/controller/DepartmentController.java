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
 * 处理和部门有关的请求
 */
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	/*
	 * 返回部门的所有信息
	 */
	@RequestMapping("/depts")
	@ResponseBody//表示返回给浏览器
	public Msg getDepts(){
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
}
