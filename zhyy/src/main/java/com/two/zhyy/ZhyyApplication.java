package com.two.zhyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ZhyyApplication {
	//asdf
    public static void main(String[] args) {
        SpringApplication.run(ZhyyApplication.class, args);
    }

}
