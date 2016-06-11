package com.amudhan.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorClass implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("employeeDetails");
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		/*The value set for the greeting property of the bean employeeDetails in the springconfig will be overridden here*/
		propertyValues.addPropertyValue("greeting", "Greeting from BeanFactoryPostProcessor");

	}

}
