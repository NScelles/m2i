import { Component } from '@angular/core';

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
