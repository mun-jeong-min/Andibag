package com.example.andibag.domain.chat.domain.repository;

import com.example.andibag.domain.chat.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
