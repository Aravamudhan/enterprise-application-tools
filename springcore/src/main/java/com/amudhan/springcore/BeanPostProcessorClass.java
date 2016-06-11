package com.amudhan.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class BeanPostProcessorClass implements BeanPostProcessor,Ordered {

	private int orderPriority;
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor before initialization of the bean "+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor after initialization of the bean "+beanName);
		return bean;
	}

	/*Higher the values, lower the priority
	 * The value 0 is of highest precedence*/
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
