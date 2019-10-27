package com.kyle.crud.test;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kyle.crud.bean.Employee;
import com.kyle.crud.dao.DepartmentMapper;
import com.kyle.crud.dao.EmployeeMapper;


/**
 * ����dao��Ĺ���
 * @author Think
 * �Ƽ�spring����Ŀ�Ϳ���ʹ��spring��Ԫ����,�����Զ�ע����������Ҫ�����
 * ����:
 * �ٵ���SpringTestģ��
 * ��@ContextConfigurationָ��spring�����ļ���λ��
 * ��@RunWith��ʾ�����ĸ��ĵ�Ԫ����  ������spring�ṩ�� ����Ҫʹ��spring�ĵ�Ԫ����
 * ��ֱ��autowireҪʹ�õĵ��������	
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	/*
	 * ����departmentMapper
	 */
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	//���session��һ��������sqlsession
	@Autowired  
	SqlSession sqlSession;
	
    @Test
	public void testCRUD(){
    	//�����Ƿ��Ѿ�ע����
		System.out.println(departmentMapper);
		
		//1,���뼸������
//		departmentMapper.insertSelective(new Department(null,"������"));
//		departmentMapper.insertSelective(new Department(null,"���Բ�"));
		//2,����Ա������,����Ա������
//		employeeMapper.insertSelective(new Employee(null,"jreey","M","jreey@qq.com",1));
		//3,����������Ա��
		EmployeeMapper  mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 10000; i++) {
			//����Զ�����id
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@qq.com", 2));
		}
//		System.out.println("�������!");
		
		//4,�޸Ĳ���
//	    employeeMapper.updateByPrimaryKeySelective(new Employee(1,"Tom","F","Tom@163.com",2));
	   
		//5,����ɾ������
//		 EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		 for (int i = 0; i <50; i++) {
//			mapper.deleteByPrimaryKey(i);
//		}
    }
}
