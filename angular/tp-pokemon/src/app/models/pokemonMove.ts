import { PTypes } from "./pokemonType"

export interface PMove {
    name: string,
    description: string,
    damage: number,
    type: PTypes
}