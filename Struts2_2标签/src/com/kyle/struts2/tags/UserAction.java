package com.kyle.struts2.tags;

import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class UserAction {

	 private String userId;
	 private String userName;
     private String userPassword;	
	 private String desc;
	 private boolean married;
	 private String gender;
	 private List<String> city;
     private String age;
     
     
     public String getGender() {
    	 return gender;
     }
     public void setGender(String gender) {
    	 this.gender = gender;
     }

     public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> city) {
		this.city = city;
	}
	public String getAge() {
    	 return age;
     }
     public void setAge(String age) {
    	 this.age = age;
     }
     
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}


	public UserAction() {
		super();
	}
	

	
	@Override
	public String toString() {
		return "UserAction [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", desc=" + desc
				+ ", married=" + married + ", gender=" + gender + ", city="
				+ city + ", age=" + age + "]";
	}
	public String save(){
		System.out.println(this);
		
		UserAction ua = new UserAction();
		ua.setDesc("oracle");
		ua.setUserName("Kyle");
		ua.setUserId("1001");
		ua.setUserPassword("123456");
		//把对象ua压入栈顶
		//ActionContext.getContext().getValueStack().push(ua);
		
		return"input";
	}
}
