package com.example.andibag.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.andibag.domain.chat.domain.Member;
import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.chat.domain.repository.MemberRepository;
import com.example.andibag.domain.chat.domain.repository.RoomRepository;
import com.example.andibag.domain.chat.present.dto.request.JoinRoomRequest;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.facade.UserFacade;
import com.example.andibag.global.socket.property.SocketProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;

    public void joinRoom(SocketIOClient client, JoinRoomRequest request) {
        User currentUser = userFacade.getCurrentUser();

        User user = userRepository.findById(request.getFriendId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Room room = roomRepository.save(
                Room.builder()
                        .headUser(currentUser)
                        .friend(user)
                        .build()
        );
        memberRepository.save(
                Member.builder()
                        .user(currentUser)
                        .room(room)
                        .build()
        );

        memberRepository.save(
                Member.builder()
                        .user(user)
                        .room(room)
                        .build()
        );
        client.joinRoom(room.getId());
        
        client.sendEvent(SocketProperty.ROOM_KEY, room.getId());
    }
}
