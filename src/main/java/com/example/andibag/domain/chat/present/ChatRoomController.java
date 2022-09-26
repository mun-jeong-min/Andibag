package com.example.andibag.domain.chat.present;

import com.example.andibag.domain.chat.present.dto.response.EnterRoomResponse;
import com.example.andibag.domain.chat.present.dto.response.RoomResponse;
import com.example.andibag.domain.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @PostMapping("/room/{friendId}")
    public EnterRoomResponse createRoom(@PathVariable("friendId") Long friendId) {
        return chatRoomService.createRoom(friendId);
    }

    @GetMapping("/room")
    public RoomResponse getAllRooms() {
        return chatRoomService.getAllRooms();
    }

    @GetMapping("/room/{id}")
    public EnterRoomResponse enterRoom(@PathVariable("id") String roomId) {
        return chatRoomService.EnterRoom(roomId);
    }

}