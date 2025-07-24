import { Animal } from "./animal.js";


export class Parrot extends Animal{

    constructor(nom,age){
        super(nom,age);
    }

    crier(){
        return "Tu crois quoi ? Crier c'est parler pour moi sisi la famille !"
    }

    static parler(){
        return "Wesh Mon frère";        
    }
}