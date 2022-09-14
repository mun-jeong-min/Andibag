package com.example.andibag.domain.chat.present;

import com.example.andibag.domain.chat.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {
    private final SimpMessageSendingOperations messageSendingOperations;

    @MessageMapping("/chat/message")
    @SendTo("/sub/chat/message")
    public void message(Message message) {
        String msg = message.getContent();
        messageSendingOperations.convertAndSend("/sub/chat/room/" + message.getRoom().getId(), msg);
    }
}
