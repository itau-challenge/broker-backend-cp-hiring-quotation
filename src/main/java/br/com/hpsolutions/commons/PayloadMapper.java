package br.com.hpsolutions.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public interface PayloadMapper {

    static <T> T mapPayload(final String input, final Class<T> clazz) throws JsonProcessingException {
        final var objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        Matcher matcher = Pattern.compile("\\\\*\"").matcher(input);
        final String s1 = matcher.replaceAll("\"");

        matcher = Pattern.compile("\"*\\{").matcher(s1);
        final String s2 = matcher.replaceAll("{");

        String cleanedPayload = s2.replace("}\"", "}");

        return objectMapper.readValue(cleanedPayload, clazz);
    }

    static <T> String convertToString(T payload) throws  JsonProcessingException {
        final var objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .findAndRegisterModules();

        var input = objectMapper.writeValueAsString(payload);

        Matcher matcher = Pattern.compile("\\\\*\"").matcher(input);
        final String s1 = matcher.replaceAll("\"");

        matcher = Pattern.compile("\"*\\{").matcher(s1);
        final String s2 = matcher.replaceAll("{");

        String cleanedPayload = s2.replace("}\"", "}");

        return  cleanedPayload;
    }

    static  <T, X> Stream<X> serializeObject(T object, Class<X> clazz) {
        final var objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        if(object instanceof ArrayList) {
            return objectMapper.convertValue(object, new TypeReference<List<X>>() {
                    }).stream()
                    .flatMap(it -> serializeObject(it, clazz));
        } else {
            return Stream.of(objectMapper.convertValue(object, clazz));
        }
    }
}
