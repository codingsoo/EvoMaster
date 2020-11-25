package org.restncs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@SpringBootApplication
public class NcsApplication {

    // http://localhost:8080/v2/api-docs
    // http://localhost:8080/swagger-ui.html

    public static void main(String[] args) {
        SpringApplication.run(NcsApplication.class, args);
    }

    @Bean
    public Docket piApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API for Numerical Case Study (NCS)")
                .description("Examples of different numerical algorithms accessible via REST")
                .version("1.0")
                .build();
    }
}
