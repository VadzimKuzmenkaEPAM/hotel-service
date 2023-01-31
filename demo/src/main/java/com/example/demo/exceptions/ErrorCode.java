package com.example.demo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
public enum ErrorCode {

    ROOM_NOT_FOUND("404_ROOM_NOT_FOUND", HttpStatus.NOT_FOUND, LocalDateTime.now()),
    BOOKING_NOT_FOUND("404_BOOKING_NOT_FOUND", HttpStatus.NOT_FOUND, LocalDateTime.now()),
    USER_NOT_FOUND("404_USER_NOT_FOUND", HttpStatus.NOT_FOUND, LocalDateTime.now()),
    USER_LOGIN_INVALID("422_UNPROCESSABLE_ENTITY_LOGIN", HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now()),
    USER_PASSWORD_INVALID ("422_UNPROCESSABLE_ENTITY_PASSWORD", HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now()),
    USER_EMAIL_INVALID("422_UNPROCESSABLE_ENTITY_EMAIL", HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now()),
    USER_CARD_NUMBER_INVALID ("422_UNPROCESSABLE_ENTITY_CARD_NUMBER", HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now());

    private String code;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;

    ErrorCode(String code, HttpStatus httpStatus, LocalDateTime localDateTime) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.localDateTime = localDateTime;
    }
}