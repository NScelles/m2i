import { Pokemon } from "../models/pokemonData";
import { PTypes } from "../models/pokemonType";
import { ApiPokemon } from "../utils/services/api-pokemon";
import { PMove } from "../models/pokemonMove";
import { error, log } from "node:console";

export class DtoToPokemon {

    constructor(private api: ApiPokemon) { }

    dtoToPokemons(): Pokemon[] | null {
        let pokemons: Pokemon[] = [];
        let dtos: any[] = [];
        this.api.getPokemons().subscribe({
            next: data => {
                dtos = data["results"] as any[];
                dtos.forEach(dto => {
                    pokemons.push(this.dtoToPokemon(dto) as Pokemon);
                });
            },
            error: err => console.log(err)
        });
        console.log(pokemons);
        return pokemons;
    }

    dtoToPokemon(pDto: any): Pokemon | null {
        let result: Pokemon | null = null;
        this.api.getPokemon(pDto["url"]).subscribe({
            next: data => {
                result = {
                    name: pDto["name"],
                    weight: data["weight"],
                    height: data["height"],
                    types: this.dtoToPTypes(data["types"]),
                    sprites: {
                        front: data["sprites"]["other"]["showdown"]["back_default"],
                        back: data["sprites"]["other"]["showdown"]["front_default"]
                    },
                    moves: []
                }

            },
            error: err => console.log(err)
        });


        return result;
    }

    dtoToPTypes(dtoTypes: any[]): PTypes[] {
        let result: PTypes[] = [];
        dtoTypes.forEach(dtoType => {
            result.push(
                this.getPType(dtoType["type"]["name"] as string)
            );
        });
        return result;
    }

    dtoToMoves(dtoMoves: any[]): PMove[] {
        let result: PMove[] = [];
        for (let i: number = 0; i < 4; i++) {
            console.log("Test récupération des ataques " + dtoMoves[i]);
            this.api.getMove(dtoMoves[i]["move"]["url"]).subscribe({
                next: data => {
                    result.push({
                        name: dtoMoves[i]["move"]["name"],
                        description: data["effect_entries"]["effect"] as string,
                        damage: data["power"] as number,
                        type: this.getPType(data["type"]["name"])
                    })
                },
                error: err => console.log(err)

            })

        }
        return result;
    }

    getPType(type: string): PTypes {
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
            case 'fly':
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
}

