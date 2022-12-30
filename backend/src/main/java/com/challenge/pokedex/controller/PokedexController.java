package com.challenge.pokedex.controller;

import com.challenge.pokedex.model.pokemon.basic.Pokemon;
import com.challenge.pokedex.model.pokemon.details.PokemonDetail;
import com.challenge.pokedex.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PokedexController {

    @Autowired
    PokedexService pokedexService;

    @GetMapping("/pokemon/{name}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable(value = "name") String name) {
        return new ResponseEntity<>(pokedexService.getPokemonByName(name), HttpStatus.OK);
    }

    @GetMapping("/pokemon-details/{name}")
    public ResponseEntity<PokemonDetail> getPokemonDetails(@PathVariable(value = "name") String name) {
        return new ResponseEntity<>(pokedexService.getPokemonDetail(name), HttpStatus.OK);
    }

}
