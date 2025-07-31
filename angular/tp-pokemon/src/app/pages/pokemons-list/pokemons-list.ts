import { Component, OnInit } from '@angular/core';
import { on } from 'node:events';
import { ApiPokemon } from '../../utils/services/api-pokemon';
import { DtoToPokemon } from '../../dtos/dtoToPokemon';
import { Pokemon } from '../../models/pokemonData';

@Component({
  selector: 'app-pokemons-list',
  imports: [],
  templateUrl: './pokemons-list.html',
  styleUrl: './pokemons-list.css'
})
export class PokemonsList implements OnInit {

  constructor(private api: ApiPokemon) { }

  pData: any;
  pokemons: Pokemon[] | null = null;

  ngOnInit(): void {
    let dtoPokemon: DtoToPokemon = new DtoToPokemon(this.api);
    this.pokemons = dtoPokemon.dtoToPokemons();

  }
}
