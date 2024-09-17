package com.jpa.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.jpa.test.model.CustomException;


@ControllerAdvice
public class MyExecptionHandler {
	
	
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)	
@ExceptionHandler(value=Exception.class)
public String ExceptionHandler(Model m,Exception ex,WebRequest wr)
{
	
	m.addAttribute("msg",ex.getMessage());
	return "exception";
}
	
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)	
@ExceptionHandler(value=CustomException.class)
public String ExceptionHandler1(Model m,Exception ex,WebRequest wr)
{
	
	m.addAttribute("msg",ex.getMessage());
	return "exception";
}
	


}
