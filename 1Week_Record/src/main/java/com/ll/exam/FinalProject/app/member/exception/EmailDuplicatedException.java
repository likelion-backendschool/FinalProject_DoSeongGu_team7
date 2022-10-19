package com.ll.exam.FinalProject.app.member.exception;

public class EmailDuplicatedException extends RuntimeException {
    public EmailDuplicatedException(String message) {
        super(message);
    }
}
