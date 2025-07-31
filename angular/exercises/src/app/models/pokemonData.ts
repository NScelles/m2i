import { PMove } from "./pokemonMove";
import { PTypes } from "./pokemonType";

export interface PokemonData {
    id: number,
    name: string,
    description: string,
    types: PTypes[],
    moves: PMove[]
}