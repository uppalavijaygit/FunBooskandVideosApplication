package com.world.remit.ecommerce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Vijay","www.world-remit.com","vijay@vijay.com");
	
	public static final ApiInfo DEFAULT_APP_INFO = new ApiInfo("Books & Videos API", "Books & Videos API Documentation", 
			"1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "www.vijay.com");

	private static final Set<String> DEFALUT_PRODUCER_CONSUMERS = 
			new HashSet<String>(Arrays.asList("application/json"));
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_APP_INFO)
				.produces(DEFALUT_PRODUCER_CONSUMERS)
				.consumes(DEFALUT_PRODUCER_CONSUMERS);
		
	}

}
