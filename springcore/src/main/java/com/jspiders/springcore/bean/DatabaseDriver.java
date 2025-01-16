package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value = "prototype")
public class DatabaseDriver {
		
	@Value("com.mysql.cj.jdbc.Driver")
	private String name;
}
