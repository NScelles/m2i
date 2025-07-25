export class Library {
    constructor(library) {
        this.library = library;
    }
    addBook(book) {
        this.library.push(book);
    }
    removeBook(title) {
        this.library = this.library.filter(book => book.title != title);
    }
    findBookByTitle(title) {
        this.library.forEach((book) => {
            if (book.title == title)
                return book;
        });
        return undefined;
    }
    listAvailableBooks() {
        return this.library.filter(book => book.isAvailable);
    }
    getBooksByAuthor(authorName) {
        return this.library.filter(book => book.author.name == authorName);
    }
}
