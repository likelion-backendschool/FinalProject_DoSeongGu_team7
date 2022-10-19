package com.ll.exam.FinalProject.app.member.controller;

import com.ll.exam.FinalProject.app.member.CreateMemberForm;
import com.ll.exam.FinalProject.app.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("login")
    public String showLogin() {
        return "member/login";
    }

    @GetMapping("logout")
    @PreAuthorize("isAuthenticated()")
    public String memberLogout(Principal principal) {
        return "member/logout";
    }

    @GetMapping("join")
    public String signup(CreateMemberForm createMemberForm) {
        return "member/join";
    }

    @PostMapping("join")
    public String signup(@Valid CreateMemberForm createMemberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/join";
        }

        if (!createMemberForm.getPassword1().equals(createMemberForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "member/join";
        }

        memberService.create(createMemberForm.getUsername(), createMemberForm.getPassword1(), createMemberForm.getEmail());


        return "redirect:/";
    }


}
