package com.challenge.pokedex.model.pokemon.details;

import com.challenge.pokedex.model.pokemon.details.specie.PokemonSpecie;

import java.util.List;

public class PokemonDetail {

    private PokemonSpecie pokemonSpecie;

    private List<PokemonMove> moves;

    public List<PokemonMove> getMoves() {
        return moves;
    }

    public void setMoves(List<PokemonMove> moves) {
        this.moves = moves;
    }

    public PokemonSpecie getPokemonSpecie() {
        return pokemonSpecie;
    }

    public void setPokemonSpecie(PokemonSpecie pokemonSpecie) {
        this.pokemonSpecie = pokemonSpecie;
    }
}
