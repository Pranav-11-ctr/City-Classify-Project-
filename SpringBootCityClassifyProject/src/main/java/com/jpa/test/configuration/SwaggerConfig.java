package com.jpa.test.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
@Bean
public Docket api() {
return new Docket(DocumentationType.SWAGGER_2).
apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
}

private ApiInfo getInfo() {


return new ApiInfo("CityClassified and Search","This project is developed by Pranav Kumar.","4.0","Term and Conditions",
new Contact("Pranav","", "pranavkumar@virtusa.com"), "License Of Apis", "Url", Collections.emptyList());
}

}