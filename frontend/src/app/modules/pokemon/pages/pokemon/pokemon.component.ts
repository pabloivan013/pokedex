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
  pokemonSearchName: string = '';
  loading: boolean = false;
  errorMessage: string = '';

  constructor(
    private pokemonService: PokemonService
  ) {
  }

  getPokemonOnClick() {
    console.log("Search pokemon: ", this.pokemonSearchName)
    this.getPokemon(this.pokemonSearchName);
  }

  getPokemon(name: string) {
    this.pokemon = undefined;
    this.loading = true
    this.errorMessage = ''

    this.pokemonService.getPokemon(name).subscribe({
      next: (pokemon: Pokemon) => {
        // TODO: Fix 'pokemon' to be a 'Pokemon' object
        this.pokemon = pokemon
      },
      error: (error) => {
        console.log("ERROR getPokemon:", error)
        this.loading = false
        if (error.status == 404) {
          this.errorMessage = `Pokemon '${this.pokemonSearchName}' not found`
        } else {
          this.errorMessage = "Error obtaining pokemon"
        }
      },
      complete: () => {
        this.loading = false
      }
    })

  }
}
