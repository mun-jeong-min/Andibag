package com.example.andibag.domain.comment.present;

import com.example.andibag.domain.comment.present.dto.request.CommentCreateRequest;
import com.example.andibag.domain.comment.present.dto.request.CommentUpdateRequest;
import com.example.andibag.domain.comment.service.CommentCreateService;
import com.example.andibag.domain.comment.service.CommentDeleteService;
import com.example.andibag.domain.comment.service.CommentUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentCreateService commentCreateService;
    private final CommentUpdateService commentUpdateService;
    private final CommentDeleteService commentDeleteService;

    @PostMapping
    public void commentCreate(@RequestBody @Valid CommentCreateRequest request) {
        commentCreateService.commentCreate(request);
    }

    @PutMapping("/{id}")
    public void commentUpdate(@RequestBody @Valid CommentUpdateRequest request, @PathVariable("id") Long id) {
        commentUpdateService.commentUpdate(request, id);
    }

    @DeleteMapping("/{id}")
    public void commentDelete(@PathVariable("id") Long id) {
        commentDeleteService.commentDelete(id);
    }
}
