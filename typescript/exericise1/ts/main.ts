import { Author } from "./models/interfaces/author.js";
import { Book } from "./models/interfaces/book.js";
import { Library } from "./models/classes/library.js";

var libary: Library = new Library([]);

var authors: Author[] = [
    {
        name: "De Vinci",
        birthYear: 1928,
        genres: [
            "Science"
        ]
    },
    {
        name: "J.K. Rowling",
        birthYear: 1982,
        genres: [
            "Fantasy"
        ]
    },
    {
        name: "J.R.R. Tolkien",
        birthYear: 1892,
        genres: [
            "Fantasy"
        ]
    }
];

const authorSelect = document.querySelector("select#author");
const registerButton = document.querySelector("button#register");
const avaiblableFilter = document.getElementById("onlyAvailable") as HTMLInputElement;

avaiblableFilter.addEventListener("input", () => {
    console.log(libary);
    console.log(avaiblableFilter.checked);
    if (avaiblableFilter.checked)
        displaylibrary(new Library(libary.listAvailableBooks()));
    else
        displaylibrary(libary);
});

window.addEventListener("DOMContentLoaded", () => {
    console.log("test");
    authors.forEach((author) => {
        let option = document.createElement("option");
        option.textContent = author.name;
        option.value = author.name;
        authorSelect.appendChild(option);



    });
});

registerButton.addEventListener("click", () => {
    let values = document.querySelectorAll(".book") as NodeListOf<HTMLInputElement>;
    libary.addBook(createBook(
        values[0].value,
        authors.filter(author => author.name == values[1].value)[0],
        values[2].value as unknown as number
    ));
    displaylibrary(libary);
});



function createBook(title: string, author: Author, pages: number): Book {
    return {
        title: title,
        author: author,
        pages: pages,
        isAvailable: true
    }

}

function toggleAvailability(book: Book) {
    book.isAvailable = !book.isAvailable;
}

function displaylibrary(theLibrary: Library) {
    let section = document.getElementById("library");
    section.innerHTML = '';
    theLibrary.library.forEach((book) => {
        let card = document.createElement("div");
        card.innerHTML =
            `
            <h1>${book.title}</h1>
            <div>
                <p>${book.author.name} - ${book.author.birthYear}</p>
                <p>${book.author.genres[0]}</p>
                <p> ${book.pages} pages </p>
            </div>
            <p>${book.isAvailable ? "Available" : "Unavailable"}</p>
        `
        let removeButton = document.createElement("button");
        let setAvailableButton = document.createElement("button");

        removeButton.textContent = "Remove";
        setAvailableButton.textContent = `${book.isAvailable ? "Set Unavailable" : "Set Available"}`

        setAvailableButton.addEventListener("click", () => {
            toggleAvailability(book);
            displaylibrary(theLibrary);
        });

        removeButton.addEventListener("click", () => {
            theLibrary.removeBook(book.title);
            displaylibrary(theLibrary);
        })

        card.appendChild(setAvailableButton);
        card.appendChild(removeButton);
        section.appendChild(card);

    });
}



