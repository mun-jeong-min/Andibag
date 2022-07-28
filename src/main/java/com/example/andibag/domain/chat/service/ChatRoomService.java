package com.example.andibag.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.andibag.domain.chat.domain.Member;
import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.chat.domain.repository.MemberRepository;
import com.example.andibag.domain.chat.domain.repository.RoomRepository;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public void joinRoom(SocketIOServer server, SocketIOClient client, Long friendId) {
        User currentUser = userFacade.getCurrentUser();

        User user = userRepository.findById(friendId)
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
        System.out.println("입장");
    }
}
