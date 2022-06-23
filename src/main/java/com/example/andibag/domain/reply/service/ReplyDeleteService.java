package com.example.andibag.domain.reply.service;

import com.example.andibag.domain.reply.domain.Reply;
import com.example.andibag.domain.reply.domain.repository.ReplyRepository;
import com.example.andibag.domain.reply.exception.ReplyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyDeleteService {
    private final ReplyRepository replyRepository;

    public void deleteReply(Long id) {
        Reply reply = replyRepository.findReplyById(id)
                .orElseThrow(() -> ReplyNotFoundException.EXCEPTION);

        replyRepository.delete(reply);
    }
}
