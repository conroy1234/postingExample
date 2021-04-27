package com.posting.postingExample;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class LocaleConfiguretion {
	@Bean
	public LocaleResolver resolver() {
		SessionLocaleResolver  resolver =  new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		return resolver;
	}
	
	
	
//	@Bean
//	public MessageSource messageSource() {
//		
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}
}
