import { Pokemon } from "../models/pokemon";
import { PTypes } from "../models/pokemonType";
import { ApiPokemon } from "../utils/services/api-pokemon";
import { PMove } from "../models/pokemonMove";
import { error, log } from "node:console";



export function dtoToPokemons(): Pokemon[] | null {
    let pokemons: Pokemon[] = [];
    let dtos: any[] = [];
    let data: any;
    dtos = data["results"] as any[];
    dtos.forEach(dto => {
        pokemons.push(dtoToPokemon(dto) as Pokemon);
    });
    return pokemons;
}

export function dtoToPokemon(pDto: any): Pokemon | null {
    let result: Pokemon;
    result = {
        name: pDto["name"],
        weight: pDto["weight"],
        height: pDto["height"],
        types: dtoToPTypes(pDto["types"]),
        sprites: {
            front: pDto["sprites"]["other"]["showdown"]["back_default"],
            back: pDto["sprites"]["other"]["showdown"]["front_default"]
        },
        moves: []
    }
    return result;
}

export function dtoToPTypes(dtoTypes: any[]): PTypes[] {
    let result: PTypes[] = [];
    dtoTypes.forEach(dtoType => {
        result.push(
            getPType(dtoType["type"]["name"] as string)
        );
    });
    return result;
}

export function getMoves(moves: any[]): PMove[] {
    let result: PMove[] = [];
    for (let i = 0; i < 4; i++) {
        result.push({
            url: moves[i]["move"]["url"],
            name: moves[i]["move"]["name"]
        })
    }
    return result;
}

export function getPType(type: string): PTypes {
    switch (type.toLowerCase()) {
        case 'normal':
            return PTypes.NORMAL;
        case 'grass':
            return PTypes.GRASS;
        case 'water':
            return PTypes.WATER;
        case 'fire':
            return PTypes.FIRE;
        case 'bug':
            return PTypes.BUG;
        case 'fight':
            return PTypes.FIGHT;
        case 'flying':
            return PTypes.FLY;
        case 'psychic':
            return PTypes.PSYCHIC;
        case 'fairy':
            return PTypes.FAIRY;
        case 'steel':
            return PTypes.STEEL;
        case 'rock':
            return PTypes.ROCK;
        case 'ground':
            return PTypes.GROUND;
        case 'dragon':
            return PTypes.DRAGON;
        case 'ice':
            return PTypes.ICE;
        case 'ghost':
            return PTypes.GHOST;
        case 'dark':
            return PTypes.DARK;
        case 'electric':
            return PTypes.ELECTRIC;
        case 'poison':
            return PTypes.POISON;
        default:
            return PTypes.NORMAL;
    }
}

