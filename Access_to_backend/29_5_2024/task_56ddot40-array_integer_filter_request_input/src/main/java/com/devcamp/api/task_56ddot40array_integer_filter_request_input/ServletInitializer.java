package com.devcamp.api.task_56ddot40array_integer_filter_request_input;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Task56ddot40ArrayIntegerFilterRequestInputApplication.class);
	}

}
