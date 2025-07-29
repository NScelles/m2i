import { Component } from '@angular/core';
import { SortbynamePipe } from '../../utils/sortbyname-pipe';

@Component({
  selector: 'app-series',
  imports: [SortbynamePipe],
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

  sortbyname: "asc" | "desc" = "asc";

  delete(deletedSerie: string) {
    this.series = this.series.filter(serie => serie != deletedSerie)
  }

  sortAlphabetics(sort: "asc" | "desc") {
    this.sortbyname = sort;
  }

}
