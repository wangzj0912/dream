package com.userserver.userserver.wzj.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.logging.Logger;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Logger log = Logger.getLogger("SwaggerConfig.java");

    @Bean
    public Docket createRestApi(){
        log.info("swagger start one");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.userserver.userserver.wzj.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        log.info("swagger start two");
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger构建Rest Api")
                .version("1.0").build();
    }
}
