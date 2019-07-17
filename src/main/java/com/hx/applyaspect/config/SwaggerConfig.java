package com.hx.applyaspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
        Contact contact = new Contact("CMH", "http://www.jxustcmh.cn/", "jxrjcmh@qq.com");
        return new ApiInfoBuilder()
                .title("陈明华的API接口文档")
                .description("API接口")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
}
