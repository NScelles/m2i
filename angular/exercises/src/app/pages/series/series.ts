import { Component } from '@angular/core';

@Component({
  selector: 'app-series',
  imports: [],
  templateUrl: './series.html',
  styleUrl: './series.css'
})
export class Series {
  series: string[] = [
    "Breaking Bad",
    "The Witcher",
    "Peaky Blinders",
    "The Mandalorian",
    "Sherlock",
    "Black Mirror",
    "The Chosen"
  ];

  delete(deletedSerie: string) {
    this.series = this.series.filter(serie => serie != deletedSerie)
  }
}
