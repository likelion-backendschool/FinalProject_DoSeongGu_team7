package com.ll.exam.FinalProject.app.member;

import lombok.Getter;

@Getter
public enum MemberRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    MemberRole(String value) {
        this.value = value;
    }

    private String value;
}
