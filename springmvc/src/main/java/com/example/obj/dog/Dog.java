package com.example.obj.dog;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

//@Getter
//@Setter
public class Dog {   
	//

    @NotNull(message = "{Dog.id.non :idnull}", groups = {Update.class})
    @Min(value = 1, message = "{Dog.id.lt1 : id要大于1}", groups = {Update.class})
    private Long id;

    @NotNull(message = "{Dog.id.non :id不为null}", groups = {Update.class})
    @NotBlank(message = "{Dog.name.non	:名称不为空}", groups = {Add.class, Update.class})
    private String name;

    @NotNull(message = "{Dog.age.non :年龄不为null}", groups = {Update.class})
    @Min(value = 1, message = "{Dog.age.lt1 : 年龄要大于1}", groups = {Add.class, Update.class})
    private Integer age;
    
    @Past(groups = {Update.class}) 
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date birth;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
}
	
	//1. 分组
	//有的时候，我们对一个实体类需要有多中验证方式，在不同的情况下使用不同验证方式，比如说对于一个实体类来的id来说，保存的时候是不需要的，对于更新时是必须的，可以如下配置：
	


