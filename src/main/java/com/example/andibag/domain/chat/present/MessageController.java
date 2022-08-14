package com.example.andibag.domain.chat.present;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/message")
    public String send() {
        return "ss";
    }
}