package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.obj.User;
import com.example.obj.dog.Dog;
import com.example.obj.dog.DogService;
import com.example.obj.dog.Update;

@RestController // =@ResponseBody＋ @Controller
@RequestMapping("/mvcRest")
public class MvcRestController {

	@RequestMapping("/restController")
	String restController() {
		System.out.println("hello @RestController	@RequestMapping");
		return "hello @RestController	@RequestMapping";
	}

	@RequestMapping("/requestBody")
	public String requestBody(@RequestBody User user) {
		System.out.println(user.getUserName() + " ：" + user.getPwd());
		return "mvcRequestBody";
	}
	
	@RequestMapping("/responseBody")
	@ResponseBody //@Controller + @ResponseBody,所以这里加不加都没有什么所谓了
	public Map<String, String> responseBody(@RequestBody User user) {
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("userName", user.getUserName());
		userMap.put("pwd", user.getPwd());
		userMap.put("other", "123");
		System.out.println(user.getUserName() + " ：" + user.getPwd());
		return userMap;
	}

	@ModelAttribute(value = "modelAttribute")	//就是将controller类拓展代理，类似于bean的拓展方法一样
	public String modelAttribute(HttpServletRequest request) {
		String url = request.getRequestURI();
		String print = "hello modelAttribute url:"+url;
		System.out.println(print);
		return print;
	}
	
	@RequestMapping("/requestParam")
	public String requestParam(@RequestParam Map<String, Object> paramMap,@RequestParam String pwd) {
		System.out.println(paramMap.get("userName")+":"+pwd);
		return "requestParam name:"+paramMap.get("userName")+":"+pwd;
	}
	

	/**
	 * 不建议使用，耦合性太高了
	 * @param userName
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/pathVariable/{userName}/{pwd}")	
	public String pathVariable(@PathVariable(value = "userName") String userName,@PathVariable(value = "pwd") String pwd) {
		String print = userName +":"+ pwd;
		System.out.println(print);
		return print;
	}
	
	
	@Autowired
	DogService dogService;
	//统一处理异常处理的注解，避免try-catch	@ControllerAdvice	&	@ExceptionHandler
	@RequestMapping("/validatedException")
	public Dog validatedException(@Validated(Update.class) @RequestBody Dog dog) {
	    // 执行业务
		
		return dog;
	}
	
	@RequestMapping("/businessException")
	public Dog businessException(@Validated(Update.class) @RequestBody Dog dog) {
	    // 执行业务
		Dog newDog = dogService.update(dog);
		return newDog;
	}
	
	@RequestMapping("/formParam")
	public String formParam(@FormParam("name") String name) {
	    // 执行业务
		String print = "name:"+name;
		System.out.println(print);
		return print;
	}	

	@RequestMapping("/redirect")
	public ModelAndView redirect() {
		return new ModelAndView("redirect:restController");	//redirect:www.baidu.com 	"path": "/mvcRest/www.baidu.com"
	}
	
	@RequestMapping("/interceptor")
	String interceptor() {
		System.out.println("hello Interceptor");
		return "hello Interceptor";
	}
	
	
//	@Autowired
//    private MessageSource messageSource;
//	
//	@RequestMapping("/locale")
//	String locale() {
//		Locale locale = LocaleContextHolder.getLocale();
//		String a = messageSource.getMessage("common", null, locale);
//		System.out.println("国际化后的hello："+a);
//		return "国际化后的hello："+a;
//	}
	
	
}
