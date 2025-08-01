import { error } from "console";
import { Pokemon } from "../../models/pokemon";
import { ApiPokemon } from "../services/api-pokemon";

export class PokemonProvider {


    constructor(private api: ApiPokemon) { }

    pokemonsProvider(): Pokemon[] | null {
        let response: Pokemon[] | null = null;

        this.api.getPokemons().subscribe({
            //next: data => response = dtoToPokemons(data),
            error: err => console.log(err)
        });

        return response;
    }
}

