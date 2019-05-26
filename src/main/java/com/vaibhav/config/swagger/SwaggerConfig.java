package com.vaibhav.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vaibhav.constant.MyConstant;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Vaibhav
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title(MyConstant.SWAGGER_TITLE).description(MyConstant.SWAGGER_DESCRIPTION)
				.contact(new Contact(MyConstant.SWAGGER_CONTACT_NAME, MyConstant.SWAGGER_CONTACT_WEBSITE,
						MyConstant.SWAGGER_CONTACT_WEBSITE))
				.license(MyConstant.SWAGGER_LICENCE_FOUNDATION)
				.licenseUrl(MyConstant.SWAGGER_LICENCE_URL)
				.version(MyConstant.SWAGGER_LICENCE_VERSION)
				.build();
	}

}
