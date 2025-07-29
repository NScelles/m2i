import { Component } from '@angular/core';
import { Book } from '../../models/book';
import { ShowReadingStatusPipe } from '../../utils/show-reading-status-pipe';

@Component({
  selector: 'app-library',
  imports: [ShowReadingStatusPipe],
  templateUrl: './library.html',
  styleUrl: './library.css'
})
export class Library {
  books: Book[] = [
    {
      title: "1984",
      author: "George Orwell",
      isRead: false
    },
    {
      title: "Le Petit Prince",
      author: "Antoine de Saint-Exupéry",
      isRead: false
    },
    {
      title: "Lord of the Rings",
      author: "J.R.R Tolkien",
      isRead: false
    },
    {
      title: "Évangile tel qu'il m'à été révélé",
      author: "Maria Valtorta",
      isRead: false
    },
    {
      title: "Confessions",
      author: "Augustin d'Hiponne",
      isRead: false
    }
  ];

  toggleRead(book: Book) {
    book.isRead = !book.isRead;
  }

}
