import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokemonComponent } from './pages/pokemon/pokemon.component';
import { PokemonBasicComponent } from './components/pokemon-basic/pokemon-basic.component';

import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input'
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatExpansionModule } from '@angular/material/expansion';


@NgModule({
  declarations: [
    PokemonComponent,
    PokemonBasicComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatProgressBarModule,
    MatExpansionModule 
  ],
  exports: [
    PokemonComponent,
    PokemonBasicComponent
  ]
})
export class PokemonModule { }
