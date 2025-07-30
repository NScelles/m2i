import { Component } from '@angular/core';
import { PTypes } from '../../models/pokemonType';
import { FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-pokemon',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './pokemon.html',
  styleUrl: './pokemon.css'
})

export class Pokemon {
  ptypes: PTypes[] = Object.values(PTypes);

  pokemon_form: FormGroup = new FormGroup({
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
      this.pokemon_form.reset();
    }
  }

}
