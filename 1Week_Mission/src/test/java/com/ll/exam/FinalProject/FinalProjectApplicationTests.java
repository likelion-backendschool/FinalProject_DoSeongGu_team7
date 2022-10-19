package com.ll.exam.FinalProject;

import com.ll.exam.FinalProject.app.member.repository.MemberRepository;
import com.ll.exam.FinalProject.app.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinalProjectApplicationTests {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;


	@Test
	@DisplayName("샘플 유저 생성")
	void t1() {
		memberService.create("admin", "1234", "admin@test.com");
		memberService.create("user1", "1234", "user1@test.com");

	}

}
