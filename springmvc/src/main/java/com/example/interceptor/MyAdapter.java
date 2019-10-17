package com.example.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 继承WebMvcConfigureAdapter继承并重写addInterceptor方法用于添加配置拦截器
 * @author chengxi
 */
@Configuration	//如果不声明式配置类，服务器不会加载都容器中，这里的配置类，等于xml的<mvc:interceptors>
public class MyAdapter extends WebMvcConfigurerAdapter {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/mvcRest/interceptor");
        
        //添加拦截器2
        registry.addInterceptor(new MyInterceptor2())
        .addPathPatterns("/mvcRest/interceptor");
        
        super.addInterceptors(registry);
    }
}