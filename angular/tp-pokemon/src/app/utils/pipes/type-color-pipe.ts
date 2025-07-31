import { Pipe, PipeTransform } from '@angular/core';
import { PTypes } from '../../models/pokemonType';

@Pipe({
  name: 'typeColor'
})
export class TypeColorPipe implements PipeTransform {

  transform(value: PTypes): string {
    switch (value) {
      case PTypes.FIRE: return 'bg-red-500';
      case PTypes.WATER: return 'bg-blue-500';
      case PTypes.GRASS: return 'bg-green-500';
      case PTypes.ELECTRIC: return 'bg-yellow-400 text-black';
      case PTypes.ICE: return 'bg-cyan-300 text-black';
      case PTypes.DARK: return 'bg-gray-800';
      case PTypes.FAIRY: return 'bg-pink-400 text-black';
      case PTypes.DRAGON: return 'bg-purple-700';
      case PTypes.GHOST: return 'bg-indigo-700';
      case PTypes.ROCK: return 'bg-yellow-700';
      case PTypes.GROUND: return 'bg-yellow-600';
      case PTypes.STEEL: return 'bg-gray-400 text-black';
      case PTypes.FIGHT: return 'bg-orange-700';
      case PTypes.FLY: return 'bg-indigo-400';
      case PTypes.BUG: return 'bg-lime-500 text-black';
      case PTypes.PSYCHIC: return 'bg-pink-600';
      case PTypes.POISON: return 'bg-purple-500';
      default: return 'bg-gray-300 text-black';
    }
  }

}
