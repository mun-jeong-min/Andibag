package com.example.andibag.domain.chat.service;

import com.example.andibag.domain.chat.domain.Room;
import com.example.andibag.domain.chat.domain.repository.RoomRepository;
import com.example.andibag.domain.chat.exception.RoomNotFoundException;
import com.example.andibag.domain.chat.present.dto.response.BasicRoomResponse;
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

    public void createRoom(Long friendId) {
        User currentUser = userFacade.getCurrentUser();
        User user = userRepository.findById(friendId)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        roomRepository.save(
                Room.builder()
                        .headUser(currentUser)
                        .friend(user)
                        .build()
        );
    }

    public RoomResponse findAllRoom() {
        User currentUser = userFacade.getCurrentUser();
        
        List<BasicRoomResponse> basicRoomResponses = roomRepository.findRoomsByHeadUser(currentUser)
                .stream()
                .map(
                        room -> new BasicRoomResponse(
                                room.getId(),
                                room.getFriend().getNickname()
                        )
                )
                .collect(Collectors.toList());

        return new RoomResponse(basicRoomResponses);
    }

    public BasicRoomResponse findRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);

        return BasicRoomResponse.builder()
                .id(room.getId())
                .roomName(room.getFriend().getNickname())
                .build();

    }
}
