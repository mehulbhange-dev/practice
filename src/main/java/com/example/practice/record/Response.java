package com.example.practice.record;

import java.time.LocalDateTime;

public record Response<T>(T data, boolean success, int status, String message, LocalDateTime timestamp) {
}
