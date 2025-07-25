import { Book } from "../interfaces/book";
import { Author } from "../interfaces/author";

export class Library {
    library: Book[];

    constructor(library: Book[]) {
        this.library = library;
    }

    addBook(book: Book) {
        this.library.push(book);
    }

    removeBook(title: string) {
        this.library = this.library.filter(book => book.title != title);
    }

    findBookByTitle(title: string): Book | undefined {
        this.library.forEach((book) => {
            if (book.title == title)
                return book;
        });
        return undefined;
    }

    listAvailableBooks(): Book[] {
        return this.library.filter(book => book.isAvailable);
    }

    getBooksByAuthor(authorName: string): Book[] {
        return this.library.filter(book => book.author.name == authorName);
    }
}

