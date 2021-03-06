package com.timecookfish.mybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.timecookfish.mybatisplusdemo.dao")
public class MybatisplusdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisplusdemoApplication.class, args);
	}

}
