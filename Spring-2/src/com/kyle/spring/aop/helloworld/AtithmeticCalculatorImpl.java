package com.kyle.spring.aop.helloworld;

import org.springframework.stereotype.Component;

@Component("atithmeticCalculator")//此处设置的value值是为了Main类里的getBean来获取该bean
public class AtithmeticCalculatorImpl implements AtithmeticCalculator {

	@Override
	public int add(int i, int j) {
		int result = i + j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result = i / j;
		return result;
	}

}
