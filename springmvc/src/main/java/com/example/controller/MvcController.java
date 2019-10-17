package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mvc")
public class MvcController {
	
	@RequestMapping("/hello")
	ModelAndView  hellos() {
		System.out.println("hello");
		ModelAndView modelAndView = new ModelAndView("/hello");
		return modelAndView;
	}

}
