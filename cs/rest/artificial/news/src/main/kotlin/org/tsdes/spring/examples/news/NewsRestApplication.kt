package org.tsdes.spring.examples.news

import com.google.common.base.Predicates
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


/**
 *
 * Created by arcuri82 on 06-Jul-17.
 */
@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@EnableSwagger2
class NewsRestApplication {

    @Bean
    fun swaggerApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("API for REST News")
                .description("Some description")
                .version("2.0.0") // Note the change in version
                .build()
    }


}

//http://localhost:8080/swagger-ui.html

fun main(args: Array<String>) {
    SpringApplication.run(NewsRestApplication::class.java, *args)
}