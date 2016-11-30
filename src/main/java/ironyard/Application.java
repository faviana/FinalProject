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

    /**
     * main class
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /**
     * event planner api
     * @return docket to swagger
     */

    @Bean
    public Docket eventPlannerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("eventPlanner-api")
                .apiInfo(apiInfoEventPlanner())
                .select()
                .paths(regex("/rest/planner.*"))
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

    /**
     * new event api
     * @return docket ot swagger
     */

    @Bean
    public Docket newEventApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("newEvent-api")
                .apiInfo(apiInfoNewEvent())
                .select()
                .paths(regex("/rest/event.*"))
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
                .title("This is my API")
                .description("Do all your event planning here!\n" +
                        "        <br>\n" +
                        "        Before starting copy the authorization Key\n" +
                        "        <p/>\n" +
                        "        M6+4hTmtBqTBNRqGSEM7JtfDlSU/qh8Z\n")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Faviana Lopez")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }

    private ApiInfo apiInfoNewEvent() {
        return new ApiInfoBuilder()
                .title("This is my API")
                .description("Do all your event planning here!\n" +
                        "        <br>\n" +
                        "        Before starting copy the authorization Key\n" +
                        "        <p/>\n" +
                        "        M6+4hTmtBqTBNRqGSEM7JtfDlSU/qh8Z\n")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Faviana Lopez")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }
}