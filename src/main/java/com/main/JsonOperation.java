package com.main;
import com.fasterxml.jackson.databind.ObjectMapper;

@FunctionalInterface
public interface JsonOperation<T> {
    T perform(ObjectMapper objectMapper) throws Exception;
}