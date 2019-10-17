package com.example.exception.business;

public class BSUtil {
	public static void isTrue(boolean expression, String error){
	    if(!expression) {
	        throw new BusinessException(error);
	    }
	}
}
