package com.shang.mgtv;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableRabbit  //开启基于注解的RabbitMQ模式  消息队列
@EnableCaching //开启基于注解的缓存
@SpringBootApplication
public class MgtvApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgtvApplication.class, args);
    }

}
