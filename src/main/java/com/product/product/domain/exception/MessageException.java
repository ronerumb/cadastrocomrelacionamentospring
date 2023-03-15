package com.product.product.domain.exception;

import lombok.Data;


@Data
public class MessageException {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;

    public MessageException(Long timestamp, Integer status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
