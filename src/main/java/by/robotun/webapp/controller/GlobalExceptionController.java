package by.robotun.webapp.controller;

import java.io.FileNotFoundException;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import by.robotun.webapp.exception.ServiceException;

@ControllerAdvice
public class GlobalExceptionController {

//	@ExceptionHandler(ServiceException.class)
//	public ModelAndView handleResourceServiceException() {
//		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ERROR_500);
//		return modelAndView;
//	}
//
//	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	public ModelAndView handleError405() {
//		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ERROR_500);
//		return modelAndView;
//	}
//
//	@ExceptionHandler(RuntimeException.class)
//	public ModelAndView handleResourceException() {
//		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ERROR_500);
//		return modelAndView;
//	}
//
//	@ExceptionHandler(FileNotFoundException.class)
//	public ModelAndView handleFileNotFoundException() {
//		ModelAndView modelAndView = new ModelAndView(URLMapping.JSP_ERROR_500);
//		return modelAndView;
//	}
}
