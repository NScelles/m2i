import { Component, signal } from '@angular/core';
import { Counter } from './pages/counter/counter';
import { Navbar } from './components/navbar/navbar';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('exercises');
}
