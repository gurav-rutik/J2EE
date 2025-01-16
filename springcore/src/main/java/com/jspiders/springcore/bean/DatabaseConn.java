package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Scope(value = "prototype")
@Component
public class DatabaseConn {
	
	@Value("jbbc:mysql://localhost:3306")
	private String url;
	@Value("root")
	private String username;
	@Value("root")
	private String password;
	
}
