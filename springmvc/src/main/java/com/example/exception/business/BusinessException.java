package com.example.exception.business;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException(String message){
        super("BusinessException:"+message);
    }
}