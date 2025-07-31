import { Routes } from '@angular/router';
import { PokemonsList } from './pages/pokemons-list/pokemons-list';

export const routes: Routes = [
    { path: "list", component: PokemonsList },
    { path: "", component: PokemonsList }
];
