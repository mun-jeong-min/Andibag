package com.example.andibag.domain.chat.present;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.example.andibag.domain.chat.service.ChatRoomService;
import com.example.andibag.global.socket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class SocketController {
    private final ChatRoomService chatRoomService;

    @OnEvent(SocketProperty.ROOM_KEY)
    public void event(SocketIOClient client, @RequestBody @Valid Long friendId) {
        chatRoomService.joinRoom(client, friendId);
    }
}
