package ironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by favianalopez on 11/8/16.
 */
@EnableSwagger2
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public Docket eventPlannerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("event-api")
                .apiInfo(apiInfoNewEvent())
                .select()
                .paths(regex("/planning/eventPlanner.*"))
                .build();
    }

    @Bean
    public Docket newEventApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("newEvent-api")
                .apiInfo(apiInfoNewEvent())
                .select()
                .paths(regex("/planning/newEvent.*"))
                .build()
                .globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("x-authorization-key")
                                .description("API Authorization Key")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));
    }

    private ApiInfo apiInfoEventPlanner(){
        return new ApiInfoBuilder()
                .title("This is our API")
                .description("Do all your planning here!!!")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Faviana Lopez")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }

    private ApiInfo apiInfoNewEvent() {
        return new ApiInfoBuilder()
                .title("This is our API")
                .description("Do all your planning here!!!")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Faviana Lopez")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }
}