import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../models/pokemon.model';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  // TODO: Import endpoint from file
  API_ENDPOINT  = `http://localhost:8080/api/pokemon`

  constructor(private http: HttpClient) { }

  getPokemon(name: string): Observable<Pokemon> {
    return this.http.get<Pokemon>(`${this.API_ENDPOINT}/${name}`)
  }



}
