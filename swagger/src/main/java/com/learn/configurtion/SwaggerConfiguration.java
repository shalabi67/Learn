package com.learn.configurtion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;

/**
 * Created by mshalabi on 20.06.17.
 */
@Configuration
@EnableSwagger2
//@ComponentScan(value="com.learn")
@PropertySource("classpath:swagger.properties")
public class SwaggerConfiguration {
    @Value("${api.version}")
    private String apiVersion;

    @Value("${api.licence}")
    private String apiLicence;

    @Value("${api.title}")
    private String apiTitle;

    @Value("${api.description}")
    private String apiDescription;

    private ApiInfo getApiInformation() {
        return new ApiInfoBuilder()
                .title(apiTitle)
                .license(apiLicence)
                .description(apiDescription)
                .version(apiVersion)
                .build();
    }

    @Bean
    public Docket petApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInformation())
                .pathMapping("/")
                .select()
                .paths(or(
                        PathSelectors.regex("/pets.*"),
                        PathSelectors.regex("/animals.*")
                        ))
                .build();
    }


}
