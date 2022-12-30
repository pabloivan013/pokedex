package com.challenge.pokedex.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

public class PokedexClientUtils {

    public static ObjectMapper snakeCaseObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return mapper;
    }

    public static Jackson2JsonDecoder decoder() {
        ObjectMapper mapper = snakeCaseObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new Jackson2JsonDecoder(mapper, MediaType.APPLICATION_JSON);
    }

    public static Jackson2JsonEncoder encoder() {
        return new Jackson2JsonEncoder(snakeCaseObjectMapper(), MediaType.APPLICATION_JSON);
    }

}
