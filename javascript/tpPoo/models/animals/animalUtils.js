import { Lion } from "./lion.js";
import { Parrot } from "./parrot.js";
import { Snake } from "./snake.js";

export function createAnimal(type,name,age){
    switch(type){
        case "Lion":
            return new Lion(name,age);
        case "Parrot":
            return new Parrot(name,age);
        case "Snake":
            return new Snake(name,age);
    }
}

export function getSpecificMethod(type){
    switch(type){
        case "Lion":
            return Lion.chasser();
        case "Parrot":
            return Parrot.parler();
        case "Snake":
            return Snake.ramper();
    }
}