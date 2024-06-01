package com.wollmann.totvs.rmrestdataserver.service;

public record Return<T>(
    Message[] messages, 
    Integer length,
    T data
) {

}
