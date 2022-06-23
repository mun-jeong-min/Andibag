package com.example.andibag.domain.reply.present;

import com.example.andibag.domain.reply.present.dto.request.ReplyCreateRequest;
import com.example.andibag.domain.reply.present.dto.request.ReplyUpdateRequest;
import com.example.andibag.domain.reply.service.ReplyCreateService;
import com.example.andibag.domain.reply.service.ReplyDeleteService;
import com.example.andibag.domain.reply.service.ReplyUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("reply")
public class ReplyController {
    private final ReplyCreateService replyCreateService;
    private final ReplyUpdateService replyUpdateService;
    private final ReplyDeleteService replyDeleteService;

    @PostMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void replyCreate(@PathVariable("comment-id") Long id, @RequestBody @Valid ReplyCreateRequest request) {
        replyCreateService.replyCreate(request, id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void replyUpdate(@PathVariable("id") Long id, @RequestBody @Valid ReplyUpdateRequest request) {
        replyUpdateService.replyUpdate(id, request);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReply(@PathVariable("id") Long id) {
        replyDeleteService.deleteReply(id);
    }
}
