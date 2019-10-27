package com.kyle.spring.aop.helloworld;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class LoggingAspect {

	/*
	 * ����һ������,���������������ʽ.һ���M�÷����в���Ҫ��������Ĵ���
	 * ʹ��@Pointcut �������������ʽ
	 * ���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ
	 */
	@Pointcut("execution(public int com.kyle.spring.aop.helloworld.ArithmeticCalculator.*(..))")
	public void declareJoinPointException(){}
	
	/*
	 * �� com.kyle.spring.aop.helloworld.ArithmeticCalculator�ӿ�
	 * ��ÿ��ʵ�����ÿ��������ʼ֮ǰִ��һ�δ���
	 */
	@Before("declareJoinPointException()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The method"+methodName+"begins with"+Arrays.asList(args));
	}
	
	/*
	 * �ڷ���ִ��֮��ִ�еĴ���,���۸÷����Ƿ�����쳣
	 */
	@After("declareJoinPointException()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+"ends");
		
	}
	
	/*
	 * �ڷ�������������ִ�еĴ���
	 * ����֪ͨ�ǿ��Է��ʵ������ķ���ֵ��!
	 */
	@AfterReturning(value="declareJoinPointException()",returning = "result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		 String methodName = joinPoint.getSignature().getName();
		 System.out.println("The method "+methodName+"ends with" + result);
	}
	
	/*
	 * ��Ŀ�귽�������쳣ʱ��ִ�еĴ���
	 * ���Է��ʵ��쳣����,�ҿ���ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
	 */
	@AfterThrowing(value="declareJoinPointException()",throwing = "e")
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+"occurs excetion:"+e);
	}
}
