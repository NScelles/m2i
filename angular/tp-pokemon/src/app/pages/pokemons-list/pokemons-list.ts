import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ApiPokemon } from '../../utils/services/api-pokemon';
import { PUrl } from '../../models/pokemonUrl';
import { PokeCardList } from '../../components/poke-card-list/poke-card-list';
import { Pokemon } from '../../models/pokemon';
import { FormControl, ReactiveFormsModule } from '@angular/forms'


@Component({
  selector: 'app-pokemons-list',
  imports: [PokeCardList, ReactiveFormsModule],
  templateUrl: './pokemons-list.html',
  styleUrl: './pokemons-list.css'
})
export class PokemonsList implements OnInit, OnChanges {

  constructor(private api: ApiPokemon) { }

  idForm: FormControl = new FormControl(0);
  pData: any;
  pokemons: PUrl[] = [];
  choosedPokemon: PUrl = {
    url: "https://pokeapi.co/api/v2/pokemon/1/",
    name: "bulbasaur",
    id: 0
  };


  ngOnInit(): void {
    this.api.getPokemons().subscribe({
      next: data => {
        this.pokemons = data;
      },
      error: err => console.log(err)
    })
  }

  choosePokemon(pokemon: PUrl, id: number) {
    this.choosedPokemon = {
      url: pokemon.url,
      name: pokemon.name,
      id: id
    };
  }

  previous(id: number) {
    if ((id) > 0)
      for (let i = 0; i < this.pokemons.length; i++)
        if (i == id)
          this.choosePokemon(this.pokemons[i - 1], id - 1);
  }

  next(id: number) {
    if ((id) < this.pokemons.length)
      for (let i = 0; i < this.pokemons.length; i++)
        if (i == id)
          this.choosePokemon(this.pokemons[i + 1], id + 1);
  }

  search() {
    let id: number = this.idForm.value;
    if (id < this.pokemons.length && id > 0)
      this.choosePokemon(this.pokemons[id - 1], id - 1)
  }

  ngOnChanges(changes: SimpleChanges): void {

  }
}
