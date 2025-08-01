import { ChangeDetectorRef, Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ApiPokemon } from '../../utils/services/api-pokemon';
import { Pokemon } from '../../models/pokemon';
import { TypeColorPipe } from '../../utils/pipes/type-color-pipe';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-poke-card-list',
  imports: [CommonModule, TypeColorPipe],
  templateUrl: './poke-card-list.html',
  styleUrl: './poke-card-list.css'
})
export class PokeCardList implements OnChanges {

  @Input() pokeUrl!: string;
  pokemon: Pokemon = {
    name: "",
    weight: 0,
    height: 0,
    types: [],
    sprites: {
      front: "",
      back: ""
    },
    moves: []
  };

  constructor(private api: ApiPokemon, private cdr: ChangeDetectorRef) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.api.getPokemon(this.pokeUrl).subscribe({
      next: data => {
        this.pokemon = data
        this.cdr.detectChanges()
      },
      error: err => console.log(err)
    });
  }
}
