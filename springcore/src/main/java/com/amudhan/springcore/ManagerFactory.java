package com.amudhan.springcore;

import org.springframework.beans.factory.FactoryBean;

public class ManagerFactory implements Employee,FactoryBean {

	private Manager manager;
	@Override
	public String getEmployeeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
