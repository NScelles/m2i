import { Animal } from "./animal.js";


export class Snake extends Animal{
    constructor(nom,age){
        super(nom,age);
    }

    crier(){
        return "s";
    }

    static ramper(){
        return "_________▄";
    }
}