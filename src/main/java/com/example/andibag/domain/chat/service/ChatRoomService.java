package com.example.andibag.domain.chat.service;

import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.chat.domain.repository.RoomRepository;
import com.example.andibag.domain.chat.exception.RoomNotFoundException;
import com.example.andibag.domain.chat.present.dto.response.EnterRoomResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final RoomRepository roomRepository;
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public EnterRoomResponse createRoom(Long friendId) {
        User currentUser = userFacade.getCurrentUser();
        User user = userRepository.findById(friendId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Room room;

        if (roomRepository.findByHeadUserAndFriend(currentUser, user).isPresent()) {
            room = roomRepository.findByHeadUserAndFriend(currentUser, user)
                    .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
        } else {
            room = roomRepository.save(
                    Room.builder()
                            .headUser(currentUser)
                            .friend(user)
                            .build()
            );
        }
        return enterRoom(room.getId());
    }

    private EnterRoomResponse enterRoom(String roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);

        return EnterRoomResponse.builder()
                .id(roomId)
                .messages(room.getMessages())
                .build();
    }
}
