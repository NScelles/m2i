import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../../models/pokemonData';
import { PMove } from '../../models/pokemonMove';

@Injectable({
  providedIn: 'root'
})
export class ApiPokemon {
  private baseUrl: string = "https://pokeapi.co/api/v2/pokemon?limit=150";
  constructor(private http: HttpClient) { }

  getPokemons(): Observable<any> {
    return this.http.get<any>(this.baseUrl)
  }

  getPokemon(pokeUrl: string): Observable<any> {
    return this.http.get<any>(pokeUrl)
  }

  getMove(moveUrl: string): Observable<any> {
    return this.http.get<any>(moveUrl)
  }

}

