package com.example.andibag.domain.chat.present;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.andibag.domain.chat.present.dto.request.JoinRoomRequest;
import com.example.andibag.domain.chat.service.ChatRoomService;
import com.example.andibag.global.socket.annotation.SocketController;
import com.example.andibag.global.socket.annotation.SocketMapping;
import lombok.RequiredArgsConstructor;

@SocketController
@RequiredArgsConstructor
public class ChatSocketController {
    private final ChatRoomService chatRoomService;

    @SocketMapping(endpoint = "join", requestCls = JoinRoomRequest.class)
    public void joinRoom(SocketIOClient client, SocketIOServer server, JoinRoomRequest request) {
        chatRoomService.joinRoom(client, server, request);
    }
}