package com.kyle.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.kyle.crud.bean.Employee;


/*
 * ʹ��spring����ģ���ṩ���Ե�������,����crud�������ȷ��
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//��ʾֱ������ioc����ע��
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {

	//����SpringMvc��IOC����
	@Autowired//ֻ��ע��ioc�����
	WebApplicationContext context;
	
	//mockMvc�������mvc����,��ȡ��������
	MockMvc mockMvc;
	@Before//���г�ʼ��   
	public void initMockMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception{
		//ģ�������õ�����ֵ
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
	
		//����ɹ��Ժ�,�������л���PageInfo,���ǿ���ȡ��PageInfo������֤
		MockHttpServletRequest request = result.getRequest();
		PageInfo  page = (PageInfo) request.getAttribute("PageInfo");
		System.out.println("��ǰҳ��:"+page.getPageNum());
		System.out.println("��ҳ��:"+page.getPages());
		System.out.println("�ܼ�¼��:"+page.getTotal());
		System.out.println("��ҳ����Ҫ������ʾ��ҳ��:");
		int nums[] = page.getNavigatepageNums();
           for (int i : nums) {
			 System.out.println(" "+i);
		}	
           //�@ȡԱ������
           List<Employee> list = page.getList();
           for (Employee employee : list) {
			  System.out.println("ID:"+employee.getdId()+"==>name"+employee.getEmpName());
		}
	}			
}
