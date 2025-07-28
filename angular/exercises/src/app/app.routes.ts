import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { Counter } from './pages/counter/counter';
import { Series } from './pages/series/series';

export const routes: Routes = [
    { path: "series", component: Series },
    { path: "counter", component: Counter },
    { path: "home", component: Home },
    { path: "", component: Home }
];

