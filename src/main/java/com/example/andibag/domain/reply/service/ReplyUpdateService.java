package com.example.andibag.domain.reply.service;

import com.example.andibag.domain.reply.domain.Reply;
import com.example.andibag.domain.reply.domain.repository.ReplyRepository;
import com.example.andibag.domain.reply.exception.ReplyNotFoundException;
import com.example.andibag.domain.reply.present.dto.request.ReplyUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReplyUpdateService {
    private final ReplyRepository replyRepository;

    @Transactional
    public void replyUpdate(Long id, ReplyUpdateRequest request) {
        Reply reply = replyRepository.findById(id)
                .orElseThrow(() -> ReplyNotFoundException.EXCEPTION);

        reply.updateReply(request.getContent());
    }
}
