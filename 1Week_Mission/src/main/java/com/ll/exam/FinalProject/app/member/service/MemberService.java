package com.ll.exam.FinalProject.app.member.service;

import com.ll.exam.FinalProject.app.member.entity.Member;
import com.ll.exam.FinalProject.app.member.exception.EmailDuplicatedException;
import com.ll.exam.FinalProject.app.member.exception.UsernameDuplicatedException;
import com.ll.exam.FinalProject.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void delete(Member member){
        this.memberRepository.delete(member);
    }

    public void create(String username, String password, String email) {
        Member newMember = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        try{
            memberRepository.save(newMember);
        } catch (DataIntegrityViolationException e){
            if (memberRepository.existsByUsername(username)){
                throw new UsernameDuplicatedException("이미 사용중인 아이디입니다.");
            }
            if (memberRepository.existsByEmail(email)){
                throw new EmailDuplicatedException("이미 사용중인 이메일입니다.");
            }
        }
    }
}
