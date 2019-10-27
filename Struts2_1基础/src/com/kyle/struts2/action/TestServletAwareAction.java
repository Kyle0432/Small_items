package com.kyle.struts2.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

public class TestServletAwareAction implements ServletRequestAware,
ServletContextAware,ServletResponseAware{

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		
	}

}
