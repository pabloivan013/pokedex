package com.challenge.pokedex.service;

import com.challenge.pokedex.client.PokedexClientConfiguration;
import com.challenge.pokedex.model.pokemon.basic.Pokemon;
import com.challenge.pokedex.model.pokemon.details.PokemonDetail;
import com.challenge.pokedex.model.pokemon.details.specie.PokemonSpecie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PokedexService {

    @Autowired
    @Qualifier(PokedexClientConfiguration.POKEDEX_CLIENT_BEAN)
    WebClient pokedexClient;

    private <T> T getPokemonResource(String endpoint, String value, Class<T> resource) {
        return pokedexClient
                .get()
                .uri(endpoint + "/" + value)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(resource);
                    } else {
                        return response.createError();
                    }
                })
                .block();
    }

    public Pokemon getPokemonByName(String name) {
        return getPokemonResource(Pokemon.ENDPOINT, name, Pokemon.class);
    }

    public PokemonDetail getPokemonDetail(String name) {
        PokemonDetail pokemonDetail = getPokemonResource(Pokemon.ENDPOINT, name, PokemonDetail.class);
        PokemonSpecie pokemonSpecie = getPokemonResource(PokemonSpecie.ENDPOINT, name, PokemonSpecie.class);
        pokemonDetail.setPokemonSpecie(pokemonSpecie);
        return pokemonDetail;
    }

}
