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
	 * 定义一个方法,用于声明切入点表达式.一般的M该方法中不需要添加其他的代码
	 * 使用@Pointcut 来声明切入点表达式
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式
	 */
	@Pointcut("execution(public int com.kyle.spring.aop.helloworld.ArithmeticCalculator.*(..))")
	public void declareJoinPointException(){}
	
	/*
	 * 在 com.kyle.spring.aop.helloworld.ArithmeticCalculator接口
	 * 的每个实现类的每个方法开始之前执行一段代码
	 */
	@Before("declareJoinPointException()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The method"+methodName+"begins with"+Arrays.asList(args));
	}
	
	/*
	 * 在方法执行之后执行的代码,无论该方法是否出现异常
	 */
	@After("declareJoinPointException()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+"ends");
		
	}
	
	/*
	 * 在方法正常结束受执行的代码
	 * 返回通知是可以访问到方法的返回值的!
	 */
	@AfterReturning(value="declareJoinPointException()",returning = "result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		 String methodName = joinPoint.getSignature().getName();
		 System.out.println("The method "+methodName+"ends with" + result);
	}
	
	/*
	 * 在目标方法出现异常时会执行的代码
	 * 可以访问到异常对象,且可以指定在出现特定异常时在执行通知代码
	 */
	@AfterThrowing(value="declareJoinPointException()",throwing = "e")
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+"occurs excetion:"+e);
	}
}
