package com.example.andibag.domain.chat.domain.repository;

import com.example.andibag.domain.chat.present.dto.RoomDtoRequest;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, RoomDtoRequest> chatRoomDTOMap;

    @PostConstruct
    private void init(){
        chatRoomDTOMap = new LinkedHashMap<>();
    }

    public List<RoomDtoRequest> findAllRooms(){
        //채팅방 생성 순서 최근 순으로 반환
        List<RoomDtoRequest> result = new ArrayList<>(chatRoomDTOMap.values());
        Collections.reverse(result);

        return result;
    }

    public RoomDtoRequest findRoomById(String id){
        return chatRoomDTOMap.get(id);
    }

    public RoomDtoRequest createChatRoomDTO(String name){
        RoomDtoRequest room = RoomDtoRequest.create(name);
        chatRoomDTOMap.put(room.getRoomId(), room);

        return room;
    }
}