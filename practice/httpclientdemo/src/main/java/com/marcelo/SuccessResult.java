package com.marcelo;

public record SuccessResult<T>(
    String[] messages,
    int length,
    T data) {
}
