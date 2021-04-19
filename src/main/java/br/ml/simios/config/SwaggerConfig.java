package br.ml.simios.config;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String RESOURCES = "br.ml.simios.resource";

    private static final String DELIMITER = ",";

    @Bean
    public Docket apiDoc(final Environment environment) {

        final List<String> profiles = Arrays.asList(environment.getActiveProfiles());

        final String description = "Api de avaliação de cadeias de DNA";

        final ApiInfo build = new ApiInfoBuilder().title("Voce esta no ambiente de Produção" + String.join(DELIMITER, profiles))
                .description(description)
                .build();

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(RESOURCES))
                .paths(PathSelectors.any())
                .build()
                .protocols(newHashSet("http", "https"))
                .apiInfo(build);
    }

}