package com.posting.postingExample.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageSourceController {
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping(path="/get-message")
	public String getMessage(@RequestHeader("Accept-Language") Locale locale) {
		return messageSource.getMessage("good.morning.message",null, locale);
	}
	
	@GetMapping(path="/get-message/locale")
	public String getMessage() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}

}
