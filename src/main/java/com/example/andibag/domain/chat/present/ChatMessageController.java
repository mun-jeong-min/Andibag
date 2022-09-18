package com.example.andibag.domain.chat.present;

import com.example.andibag.domain.chat.domain.Message;
import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.chat.domain.repository.MessageRepository;
import com.example.andibag.domain.chat.domain.repository.RoomRepository;
import com.example.andibag.domain.chat.domain.types.MessageType;
import com.example.andibag.domain.chat.exception.RoomNotFoundException;
import com.example.andibag.domain.chat.present.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {
    private final SimpMessagingTemplate template;
    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    @MessageMapping("/chat/message")
    public void message(MessageDto messageDto) {
        Room room = roomRepository.findById(messageDto.getRoomId())
                        .orElseThrow(() -> RoomNotFoundException.EXCEPTION);

        messageRepository.save(
                Message.builder()
                        .type(MessageType.JOIN)
                        .content(messageDto.getMessage())
                        .room(room)
                        .build()
        );
        template.convertAndSend("/queue/chat/room/" + messageDto.getRoomId(), messageDto);
    }
}
