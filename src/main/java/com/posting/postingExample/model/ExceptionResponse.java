package com.posting.postingExample.model;

import java.time.LocalDate;
import java.util.Date;

public class ExceptionResponse {

	private String message;
	private String status;
	private LocalDate date;

	public ExceptionResponse() {

	}

	public ExceptionResponse(String message, String status, LocalDate date) {

		this.message = message;
		this.status = status;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", status=" + status + ", date=" + date + "]";
	}

}
