package com.posting.postingExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNatFoundException extends RuntimeException {

	public UserNatFoundException(String message) {
		super(message);
		
	}

}
