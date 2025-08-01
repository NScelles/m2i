import { PTypes } from "./pokemonType"

export interface PMove {
    url: string,
    name: string,
    description?: string,
    damage?: number,
    type?: PTypes
}