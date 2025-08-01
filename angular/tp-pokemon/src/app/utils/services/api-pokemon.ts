import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Pokemon } from '../../models/pokemon';
import { PMove } from '../../models/pokemonMove';
import { PUrl } from '../../models/pokemonUrl';
import { PTypes } from '../../models/pokemonType';
import { dtoToPTypes, getMoves } from '../../dtos/dtoToPokemon';

@Injectable({
  providedIn: 'root'
})
export class ApiPokemon {
  private baseUrl: string = "https://pokeapi.co/api/v2/pokemon?limit=150";
  constructor(private http: HttpClient) { }

  getPokemons(): Observable<PUrl[]> {
    return this.http.get<any>(this.baseUrl).pipe(
      map((data) => (data.results))
    );
  }

  getPokemon(pokeUrl: string): Observable<Pokemon> {
    return this.http.get<any>(pokeUrl).pipe(
      map((data) => ({
        name: data.name,
        weight: data.weight,
        height: data.height,
        sprites: {
          front: data.sprites.other.showdown.front_default,
          back: data.sprites.other.showdown.back_default
        },
        types: dtoToPTypes(data.types),
        moves: getMoves(data.moves)
      })))
  }

  /*getMoveDetail(moveUrl: string): Observable<PMove> {
    return this.http.get<any>(moveUrl).pipe(map<any, PMove>(

    )
    )
  }*/

}

