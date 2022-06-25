package com.example.andibag.domain.comment.present.dto.response;

import com.example.andibag.domain.reply.domain.Reply;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class QueryReadResponse {
    private final String nickname;
    private final String content;
    private final List<ReplyDto> replyDtoList;

    @Getter
    @AllArgsConstructor
    public static class ReplyDto{
        private final String nickname;
        private final String content;
    }

    public QueryReadResponse(String nickname, String content, List<Reply> list) {
        this.nickname = nickname;
        this.content = content;
        this.replyDtoList = new ArrayList<>();
        for(Reply reply : list) {
            replyDtoList.add(new ReplyDto(reply.getUser().getNickname(), reply.getContent()));
        }
    }
}
