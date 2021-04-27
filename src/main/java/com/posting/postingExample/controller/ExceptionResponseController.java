package com.posting.postingExample.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.posting.postingExample.exception.UserNatFoundException;
import com.posting.postingExample.model.ExceptionResponse;

@ControllerAdvice
@RestController
public class ExceptionResponseController extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> handleException(UserNatFoundException ex, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), "resource not found",
				LocalDate.now());

		return new ResponseEntity(response, HttpStatus.NOT_FOUND);

	}
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//		ExceptionResponse response = new ExceptionResponse(ex.getBindingResult().toString(), "Bad request",
//				LocalDate.now());
//		return new ResponseEntity(response, status.BAD_REQUEST);
//	}
}
