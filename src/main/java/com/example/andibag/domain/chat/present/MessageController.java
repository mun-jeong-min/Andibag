package com.example.andibag.domain.chat.present;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/roomId")
    public String message(String message) {
        return message;
    }
}