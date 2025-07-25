import { Author } from "./author.js"
export interface Book{
    title : string,
    author : Author,
    pages : number,
    isAvailable : boolean
}