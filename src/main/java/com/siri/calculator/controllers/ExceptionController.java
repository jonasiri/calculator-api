package com.siri.calculator.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.script.ScriptException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = ScriptException.class)
	public ResponseEntity<Object> handleScriptException(ScriptException   exception) {
		String errorMessage = "Error with expression: "+ exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
