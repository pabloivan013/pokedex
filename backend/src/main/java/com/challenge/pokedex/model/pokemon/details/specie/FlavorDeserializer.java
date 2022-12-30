package com.challenge.pokedex.model.pokemon.details.specie;

import com.challenge.pokedex.PokedexConfigurationProperties;
import com.challenge.pokedex.client.PokedexClientUtils;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Deserializer class used to obtain the flavor text (brief description) of a Pokemon
 * filtering by language.
 *
 * TODO: Allow the user select the language
 */
@Component
public class FlavorDeserializer extends JsonDeserializer<List<FlavorTextEntry>> {

    @Autowired
    private static PokedexConfigurationProperties configurationProperties;

    public FlavorDeserializer() {}

    @Autowired
    public FlavorDeserializer(PokedexConfigurationProperties configurationProperties) {
        FlavorDeserializer.configurationProperties = configurationProperties;
    }

    @Override
    public List<FlavorTextEntry> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        List<FlavorTextEntry> entries = new ArrayList<>();
        JsonNode node = p.getCodec().readTree(p);

        ObjectMapper mapper = PokedexClientUtils.snakeCaseObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String language = configurationProperties.getLanguage();

        if (node.isArray()) {
            node.forEach( n -> {
                try {
                    FlavorTextEntry entry = mapper.treeToValue(n, FlavorTextEntry.class);
                    if (entry.getLanguage().getName().equals(language)) {
                        entries.add(entry);
                    }
                } catch (JsonProcessingException e) {
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error during Pokemon detail deserialization", e);
                }
            });
        }

        return entries;
    }

}
