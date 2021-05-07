package com.example.prime.exceptionHandling;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotPrimeNumberException  {

	private String error_msg;
 
	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	public NotPrimeNumberException(String error_msg) {
		//super(initial_msg);
		this.error_msg = error_msg;
		 
	}

}