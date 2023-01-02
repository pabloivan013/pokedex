import { Component, Input } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon.model';

@Component({
  selector: 'app-pokemon-basic',
  templateUrl: './pokemon-basic.component.html',
  styleUrls: ['./pokemon-basic.component.scss']
})
export class PokemonBasicComponent {

  @Input() pokemon: Pokemon | undefined;

}
