package com.amudhan.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class AnotherBeanPostProcessor implements BeanPostProcessor,Ordered {

	private int orderPriority;
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("AnotherBeanPostProcessor before initialization of the bean "+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("AnotherBeanPostProcessor after initialization of the bean "+beanName);
		return bean;
	}

	@Override
	public int getOrder() {
		return orderPriority;
	}

	public int getOrderPriority() {
		return orderPriority;
	}

	public void setOrderPriority(int orderPriority) {
		this.orderPriority = orderPriority;
	}

}
