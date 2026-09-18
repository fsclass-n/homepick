package com.onrender.test.repository;

import com.onrender.test.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// DB 대신 메모리(Map)에 회원 정보를 저장
@Repository
public class MemberRepository {

    private final Map<String, Member> store = new ConcurrentHashMap<>();

    public boolean existsByEmail(String email) {
        return store.containsKey(email);
    }

    public void save(Member member) {
        store.put(member.getEmail(), member);
    }

    public Optional<Member> findByEmail(String email) {
        return Optional.ofNullable(store.get(email));
    }
}
