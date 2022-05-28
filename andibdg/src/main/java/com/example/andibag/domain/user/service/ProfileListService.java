package com.example.andibag.domain.user.service;

import com.example.andibag.domain.user.domain.repository.UserRepository;
import com.example.andibag.domain.user.present.dto.response.UserListResponse;
import com.example.andibag.domain.user.present.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProfileListService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserListResponse userList() {
        List<UserResponse> userList = userRepository.findAll()
                .stream().map(user -> new UserResponse(user.getNickname()))
                .collect(Collectors.toList());

        return new UserListResponse(userList);
    }
}
