package com.example.variousdemo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * 功能描述：
 * 〈默认路径：http://localhost:8080/项目名/doc.html〉
 **/
@Configuration
@EnableSwagger2WebMvc
@EnableKnife4j
@ConditionalOnExpression("${knife4j.enable}") //开启访问接口文档的权限  **knife4j.enable是在yml配置文件中配置为true**
public class Knife4jConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.variousdemo.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs(带认证）")
                .description("更多Spring Boot相关文章请关注：https://blog.csdn.net/elvishehai")
                .termsOfServiceUrl("https://blog.csdn.net/elvishehai").version("1.0").build();
    }
}
