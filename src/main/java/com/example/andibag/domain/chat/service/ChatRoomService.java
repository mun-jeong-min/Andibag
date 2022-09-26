package com.example.andibag.domain.chat.service;

import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.chat.domain.repository.RoomRepository;
import com.example.andibag.domain.chat.exception.RoomNotFoundException;
import com.example.andibag.domain.chat.present.dto.response.BasicRoomResponse;
import com.example.andibag.domain.chat.present.dto.response.EnterRoomResponse;
import com.example.andibag.domain.chat.present.dto.response.RoomResponse;
import com.example.andibag.domain.user.domain.User;
import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.exception.UserNotFoundException;
import com.example.andibag.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

             roomRepository.save(
                    Room.builder()
                            .headUser(user)
                            .friend(currentUser)
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

    public RoomResponse getAllRooms() {
        User user = userFacade.getCurrentUser();

        List<BasicRoomResponse> list = roomRepository.findAllByHeadUser(user)
                .stream()
                .map(room -> new BasicRoomResponse(room.getId(), room.getFriend().getNickname()))
                .collect(Collectors.toList());

        return new RoomResponse(list);
    }

    public EnterRoomResponse EnterRoom(String id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);

        return EnterRoomResponse.builder()
                .id(room.getId())
                .messages(room.getMessages())
                .build();
    }
}
