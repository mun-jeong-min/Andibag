package com.example.andibag.domain.chat.present;

import com.corundumstudio.socketio.annotation.OnEvent;
import com.example.andibag.global.socket.property.SocketProperty;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocketController {
    @OnEvent(SocketProperty.MESSAGE_KEY)
    public String event() {
        return "event";
    }
}
