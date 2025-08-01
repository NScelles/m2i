import { PMove } from "./pokemonMove";
import { PSprites } from "./pokemonSprites";
import { PTypes } from "./pokemonType";

export interface Pokemon {
    name: string,
    weight: number,
    height: number,
    types: PTypes[],
    sprites: PSprites
    moves: PMove[]
}