package com.amudhan.springcore.javaBasedConfiguration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dataSource")
@Profile("dev")
public class DevDataSource implements DataSource {

	@Override
	public String getDataSource() {
		return "Development datasource";
	}

}
