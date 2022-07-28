package com.example.andibag.domain.chat.present;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.example.andibag.domain.chat.service.ChatRoomService;
import com.example.andibag.global.socket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SocketController {
    private final ChatRoomService chatRoomService;

    @OnEvent(SocketProperty.ROOM_KEY)
    public void event(SocketIOClient client, @RequestParam("friendId") Long friendId) {
        chatRoomService.joinRoom(client, friendId);
    }
}
