package com.lguplus.common;

import com.lguplus.common.exhandler.ErrorResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonApplication.class, args);
		System.out.println("CommonApplication.main+시작");
	}

}
