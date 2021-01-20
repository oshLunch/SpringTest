package com.cos.movie.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import io.sentry.Sentry;

// Exception을 낚아채기
@RestController
@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public String argumentException(Exception e) {
		Sentry.captureException(e);
		return "오류 : "+e.getMessage();
	}
}
