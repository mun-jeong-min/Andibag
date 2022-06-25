package com.example.andibag.domain.comment.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryResponse {
    private final List<QueryReadResponse> list;
}
