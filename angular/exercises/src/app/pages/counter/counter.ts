import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-counter',
  imports: [],
  templateUrl: './counter.html',
  styleUrl: './counter.css'
})
export class Counter {
  myCounter: number = 0;

  more() {
    this.myCounter++;
  }

  less() {
    this.myCounter--;
  }
}
