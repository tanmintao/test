package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exception.business.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
		//统一配置异常日志
		//private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);	
		
		/**
		 * 标准异常配置
		 * 让所有controller处理过程的exception都返回该答复
		 * @return
		 */
	   	@ExceptionHandler(Exception.class)
	    @ResponseBody
	    String handleException(Exception e){
	        return "咱们的Controller	Exception Deal!" + e.getMessage();
	    }	
	   	
	    /**
	     * 业务异常配置
	     * 处理所有业务异常(数据处理与入库出问题)
	     * @param e
	     * @return
	     */
	    @ExceptionHandler(BusinessException.class)
	    @ResponseBody
	    String handleBusinessException(BusinessException e){
	    	return "咱们的Bussiness	Exception Deal!" + e.getMessage();
	    }
	    
	    /**
	     * 参数校验异常配置
	     * 处理所有接口数据验证异常(入参校验出问题)
	     * @param e
	     * @return
	     */
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseBody
	    String handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
	    	return "咱们的接口数据校验	Exception Deal!" + e.getMessage();
	    	}
	    
}
