package com.wollmann.totvs.rmrestdataserver.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

public class ReturnDeserializer extends JsonDeserializer<Return<?>> implements ContextualDeserializer {

    private JavaType type;

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
            throws JsonMappingException {
        this.type = property.getType().containedType(0);
    }

    @Override
    public Return<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return dese

    }

}
