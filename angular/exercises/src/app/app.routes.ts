import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { Counter } from './pages/counter/counter';
import { Series } from './pages/series/series';
import { Library } from './pages/library/library';
import { Pokemon } from './pages/pokemon/pokemon';

export const routes: Routes = [
    { path: "pokemon", component: Pokemon },
    { path: "library", component: Library },
    { path: "series", component: Series },
    { path: "counter", component: Counter },
    { path: "home", component: Home },
    { path: "", component: Home }
];

