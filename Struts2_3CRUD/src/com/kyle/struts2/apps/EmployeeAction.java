package com.kyle.struts2.apps;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware,ModelDriven<Employee>,Preparable {
	
    private Dao dao = new Dao();
	private Employee employee;
	
	private Integer employeeId;
	
	public void setEmployeeId(Integer employeeId){
		this.employeeId = employeeId;
	}
	
	public String update(){
		 dao.update(employee);
		 return"success";
	}
	//prepareUpdate()�Ǳ�ʾΪupdate��׼����,Ҳ������ִ��prepareUpdate���ٽ���ִ��update()����
	public void prepareUpdate(){
		 employee = new Employee();//new Employee()��ʾǰ�˴������Ĳ�����װ�ɵ�һ������
	}
	
	public String edit(){
		 return"edit";
	}
	public void prepareEdit(){
		 employee = dao.get(employeeId);
	}
	
	public String save(){
		dao.save(employee);
		return"success";
	}
	public void prepareSave(){
		employee = new Employee();
	}
	
	public String delete(){
		dao.delete(employeeId);
		return"success";
	}
	
	public String list(){
		request.put("emps", dao.getEmployees());
		return"list";
	}
	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	@Override
	public Employee getModel() {
		return employee;
	}
	@Override
	public void prepare() throws Exception {
	}
	
}
