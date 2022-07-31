package com.example.andibag.domain.chat.present;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.andibag.domain.chat.service.ChatRoomService;
import com.example.andibag.global.socket.annotation.SocketController;
import com.example.andibag.global.socket.annotation.SocketMapping;
import lombok.RequiredArgsConstructor;

@SocketController
@RequiredArgsConstructor
public class ChatSocketController {
    private final ChatRoomService chatRoomService;

    @SocketMapping(endpoint = "join", requestCls = String.class)
    public void joinRoom(SocketIOClient client, SocketIOServer server, String friendId) {
        chatRoomService.joinRoom(client, server, Long.parseLong(friendId));
    }
}
