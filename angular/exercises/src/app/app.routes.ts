import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { Counter } from './pages/counter/counter';
import { Series } from './pages/series/series';
import { Library } from './pages/library/library';

export const routes: Routes = [
    { path: "library", component: Library },
    { path: "series", component: Series },
    { path: "counter", component: Counter },
    { path: "home", component: Home },
    { path: "", component: Home }
];

