
  package com.example.demo.Swagger;

import java.util.concurrent.Flow.Publisher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
@Configuration
  public class demoswagger {
  
	
		
		  @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
		  .apiInfo(apiInfo()) .enable(true) .genericModelSubstitutes(Mono.class,
		  Flux.class, Publisher.class) .select() .apis(RequestHandlerSelectors.any())
		  .paths(PathSelectors.any()) .build(); }
		  
		  private ApiInfo apiInfo(){ return new
		  ApiInfoBuilder().title("Reactive Stream Starter Demo")
		  .description("Reactive Stream Starter Demo") .version("1.0").build(); }
		 
		/*
		 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
		 * .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
		 * .build(); }
		 */
  
  }
  
 