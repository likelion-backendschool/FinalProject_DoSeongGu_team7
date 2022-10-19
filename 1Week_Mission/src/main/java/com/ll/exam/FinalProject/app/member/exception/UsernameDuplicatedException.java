package com.ll.exam.FinalProject.app.member.exception;

public class UsernameDuplicatedException extends RuntimeException {
    public UsernameDuplicatedException(String message) {
        super(message);
    }
}
