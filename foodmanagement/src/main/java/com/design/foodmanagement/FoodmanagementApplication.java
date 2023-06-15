package com.design.foodmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.design.foodmanagement.mapper")
@ComponentScan(value="com.design")
public class FoodmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodmanagementApplication.class, args);
	}

}
