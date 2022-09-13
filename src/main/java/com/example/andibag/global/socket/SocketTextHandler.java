package com.example.andibag.global.socket;

import com.example.andibag.domain.chat.domain.Message;
import com.example.andibag.domain.chat.domain.repository.MessageRepository;
import com.example.andibag.domain.chat.domain.repository.RoomRepository;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequiredArgsConstructor
@Slf4j
@Component
public class SocketTextHandler extends TextWebSocketHandler {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;
    private final UserFacade userFacade;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();
        messageRepository.save(
                Message.builder()
                        .content(payload)
                        .build()
        );
        TextMessage textMessage = new TextMessage(payload);
        session.sendMessage(textMessage);
    }
}