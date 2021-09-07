package com.udacity.vehicles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {


        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.regex("/cars.*"))
                    .build()
                    .useDefaultResponseMessages(false);
        }

        private ApiInfo apiInfo() {
            return new ApiInfo(
                    "Vehicles API",
                    "This API provides data about vehicles, including current location and price.",
                    "1.0",
                    "http://www.udacity.com/tos",
                    new Contact("Susan", "my-url.example.com", "my-email@example.com"),
                    "my license",
                    "my-license.example.com",
                    null);
        }


}
