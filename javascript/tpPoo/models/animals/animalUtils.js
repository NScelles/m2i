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

export function getSpecificMethod(animal){
    if (animal instanceof Lion) {
        return Lion.chasser();
      } else if (animal instanceof Parrot) {
        return Parrot.parler();
      } else if (animal instanceof Snake) {
        return Snake.ramper();
      }
}

export function getSpecee(animal){
    if (animal instanceof Lion) {
        return "Lion";
      } else if (animal instanceof Parrot) {
        return "Parrot";
      } else if (animal instanceof Snake) {
        return "Snake";
      }
}

export function getImage(animal){
    if (animal instanceof Lion) {
        return "https://upload.wikimedia.org/wikipedia/commons/7/73/Lion_waiting_in_Namibia.jpg";
      } else if (animal instanceof Parrot) {
        return "https://www.parrotworld.fr/fr/m_enhance/154?filename=perroquets-entrelaces&ext=jpg&style_name=gallery_image_large_1308_1088&h=544&w=654&rule=654w";
      } else if (animal instanceof Snake) {
        return "https://static.vecteezy.com/ti/vecteur-libre/t1/7270752-cartoon-vert-serpent-sur-fond-blanc-vectoriel.jpg";
      }
}