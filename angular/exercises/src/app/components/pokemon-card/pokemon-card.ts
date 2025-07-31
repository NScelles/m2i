import { Component, Input, Output, EventEmitter } from '@angular/core';
import { TypeColorPipe } from '../../utils/type-color-pipe';
import { PokemonData } from '../../models/pokemonData';

@Component({
  selector: 'app-pokemon-card',
  imports: [TypeColorPipe],
  templateUrl: './pokemon-card.html',
  styleUrl: './pokemon-card.css'
})
export class PokemonCard {
  @Input() pokemon!: PokemonData

  @Output() pokemonDeleted = new EventEmitter<number>()

  deletePokemon(id: number) {
    this.pokemonDeleted.emit(id);
  }

}
