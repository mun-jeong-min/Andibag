package com.example.andibag.domain.notice.domain.repository;

import com.example.andibag.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
    Notice findNoticeById(Long id);
}
