package com.bharath.socialmedia.core.exceptions.object;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Error {
    private String message;
    private Integer statusCode;
    private LocalDateTime dateTime;
}
