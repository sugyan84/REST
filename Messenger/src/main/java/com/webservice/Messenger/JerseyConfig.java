package com.webservice.Messenger;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.webservice.resources.MyResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(MyResource.class);
	}

}
