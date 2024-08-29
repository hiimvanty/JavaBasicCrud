package com.devcamp.api.task_60dot40and50and60_car_cartype_jpa;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Task60dot40and50and60CarCartypeJpaApplication.class);
	}

}
