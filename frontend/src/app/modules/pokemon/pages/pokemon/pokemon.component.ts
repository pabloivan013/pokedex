import { Component } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon.model';
import { PokemonService } from 'src/app/services/pokemon.service'

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.scss']
})
export class PokemonComponent {

  pokemon: Pokemon | undefined;

  // TODO: Add search element
  constructor(
    private pokemonService: PokemonService
  ) {
    this.pokemon = new Pokemon();
    console.log("Real: ", this.pokemon.constructor.name)
    console.log("Real Pokemon Object: ", this.pokemon.getData())
    this.getPokemon('ditto');
  }

  getPokemon(name: string) {
    this.pokemon = undefined;

    this.pokemonService.getPokemon(name).subscribe({
      next: (pokemon: Pokemon) => {
        console.log("False: ", pokemon.constructor.name)
        // TODO: Fix 'pokemon' to be a 'Pokemon' object
        //console.log("False Pokemon Object: ", pokemon.getData())
        this.pokemon = pokemon
      },
      error: (error) => {
        console.log("ERROR getPokemon:", error)
      }
    })

  }


}
