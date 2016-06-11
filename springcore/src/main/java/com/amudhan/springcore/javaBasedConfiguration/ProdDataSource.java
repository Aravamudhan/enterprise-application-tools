package com.amudhan.springcore.javaBasedConfiguration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dataSource")
@Profile("prod")
public class ProdDataSource implements DataSource {

	@Override
	public String getDataSource() {
		return "Production datasource";
	}

}
