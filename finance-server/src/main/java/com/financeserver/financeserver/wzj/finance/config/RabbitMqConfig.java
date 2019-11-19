package com.financeserver.financeserver.wzj.finance.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(value = "rabbitmq")
public class RabbitMqConfig {

    private String host;

    private Integer port;

    private String username;

    private String password;

}
