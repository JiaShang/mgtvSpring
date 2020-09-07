package com.shang.mgtv.service;

import com.shang.mgtv.bean.Video;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Video video){
        System.out.println("收到消息："+video);
    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
