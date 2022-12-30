package com.challenge.pokedex.model.pokemon.details.specie;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

public class PokemonSpecie {

    public static final String ENDPOINT = "pokemon-species";

    private Integer id;
    private String name;
    @JsonDeserialize(using = FlavorDeserializer.class)
    private List<FlavorTextEntry> flavorTextEntries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }
}
