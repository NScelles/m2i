import { Animal } from "./animal.js";


export class Lion extends Animal{
    constructor(nom,age){
        super(nom,age);
    }

    crier(){
        return "r";
    }

    static chasser(){
        return "Hmm le bon donut sucrée au... sucre";
    }
}