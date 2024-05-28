package com.marcelo;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletionException;

import com.fasterxml.jackson.core.type.TypeReference;

public class UncheckedObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {
    /** Parses the given JSON string into a Map. */
    Map<String, String> readValue(String content) {
        try {
            return this.readValue(content, new TypeReference<>() {
            });
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }
}