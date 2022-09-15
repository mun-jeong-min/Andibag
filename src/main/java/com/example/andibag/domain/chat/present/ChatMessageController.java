package com.example.andibag.domain.chat.present;

import com.example.andibag.domain.chat.domain.Message;
import com.example.andibag.domain.chat.domain.repository.MessageRepository;
import com.example.andibag.domain.chat.domain.types.MessageType;
import com.example.andibag.domain.chat.present.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {
    private final SimpMessageSendingOperations messageSendingOperations;
    private final MessageRepository messageRepository;

    @MessageMapping("/chat/message")
    @SendTo("/sub/chat/message")
    public MessageDto message(MessageDto message) {
        String msg = message.getMessage();
        messageSendingOperations.convertAndSend("/sub/chat/room/" + message.getRoomId(), msg);

        return new MessageDto(MessageType.SEND, message.getRoomId(), message.getWriter(), message.getMessage());
    }
}
