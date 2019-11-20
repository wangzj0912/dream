package com.financeserver;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableAsync
@MapperScan("com.financeserver.wzj.finance.mapper")
@Log4j2
public class FinanceServerApplication {

    public static void main(String[] args) {
        System.out.println("FinanceServerApplication.java starting");
        SpringApplication.run(FinanceServerApplication.class, args);
        System.out.println("FinanceServerApplication.java started");
    }

}
