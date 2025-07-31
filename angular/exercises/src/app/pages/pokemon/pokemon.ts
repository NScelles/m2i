import { Component } from '@angular/core';
import { PTypes } from '../../models/pokemonType';
import { FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { PokemonData } from '../../models/pokemonData';
import { PokemonCard } from '../../components/pokemon-card/pokemon-card';

@Component({
  selector: 'app-pokemon',
  imports: [FormsModule, ReactiveFormsModule, PokemonCard],
  templateUrl: './pokemon.html',
  styleUrl: './pokemon.css'
})

export class Pokemon {
  ptypes: PTypes[] = Object.values(PTypes);
  pokemons: PokemonData[] = [];

  pokemon_form: FormGroup = new FormGroup({
    id: new FormControl(this.pokemons.length),
    name: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    types: new FormArray([
      new FormControl(PTypes.NORMAL, [Validators.required])
    ]),
    moves: new FormArray([
      new FormGroup({
        name: new FormControl('', [Validators.required]),
        description: new FormControl('', [Validators.required]),
        damage: new FormControl(0, [Validators.required]),
        type: new FormControl(PTypes.NORMAL, [Validators.required])
      })
    ])
  });

  get types() {
    return this.pokemon_form.controls['types'] as FormArray;
  }

  get moves() {
    return this.pokemon_form.controls['moves'] as FormArray;
  }

  addType(): void {
    if (this.types.length < 2)
      this.types.push(new FormControl(PTypes.NORMAL, [Validators.required]));
  }

  deleteType(index: number): void {
    if (this.types.length > 1) {
      this.types.removeAt(index);
    }
  }

  addMove(): void {
    if (this.moves.length < 4)
      this.moves.push(
        new FormGroup({
          name: new FormControl('', [Validators.required]),
          description: new FormControl('', [Validators.required]),
          damage: new FormControl(0, [Validators.required]),
          type: new FormControl(PTypes.NORMAL, [Validators.required])
        })
      );
  }

  deleteMove(index: number): void {
    if (this.moves.length > 1) {
      this.moves.removeAt(index);
    }
  }

  savePokemon(): void {
    if (this.pokemon_form.valid) {
      console.log("Pokemon:", this.pokemon_form.value);
      this.pokemons.push(this.pokemon_form.value);
      this.pokemons[this.pokemons.length - 1].id = this.pokemons.length - 1;
      console.log(this.pokemons);
      this.pokemon_form.reset();
    }
  }

  deletePokemon(id: number) {
    this.pokemons = this.pokemons.filter(pokemon => pokemon.id != id);
  }

}
