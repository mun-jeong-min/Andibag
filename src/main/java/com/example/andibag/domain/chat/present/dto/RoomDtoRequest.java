package com.example.andibag.domain.chat.present.dto;

import com.example.andibag.domain.chat.domain.Room;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class RoomDtoRequest {

    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션

    public static RoomDtoRequest create(String name){
        RoomDtoRequest room = new RoomDtoRequest();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
