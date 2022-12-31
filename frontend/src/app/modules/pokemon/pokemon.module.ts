import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokemonComponent } from './pages/pokemon/pokemon.component';
import { PokemonBasicComponent } from './components/pokemon-basic/pokemon-basic.component';

@NgModule({
  declarations: [
    PokemonComponent,
    PokemonBasicComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    PokemonComponent,
    PokemonBasicComponent
  ]
})
export class PokemonModule { }
