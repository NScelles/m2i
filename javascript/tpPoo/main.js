import { createAnimal, getSpecificMethod } from "./models/animals/animalUtils.js";
import { Animal } from "./models/animals/animal.js";

var zoo = [];
const addAnimal = document.querySelector("form>button");
const animalName = document.getElementById("animalName");
const animalAge = document.getElementById("animalAge");
const animalSpecee = document.getElementById("animalSpecee");
const zooSection = document.getElementById("zoo");
const animalAction = document.querySelector("section#animalAction>p");

addAnimal.addEventListener("click",()=>{
    const animal = createAnimal(
        animalSpecee.value,
        animalName.value,
        animalAge.value
    );
    zoo.push(animal);
    createCard(animal,animalSpecee.value)
});

function createCard(animal,specee){
    const card = document.createElement("div");  
    const titleCard = document.createElement("h2");  
    const description = document.createElement("p");  
    const action = document.createElement("button");

    titleCard.textContent = animal.sePresenter();
    description.textContent = animal.crier() + " Je suis un " + specee;
    action.textContent = "action";
    action.addEventListener("click",()=>{
        animalAction.textContent = getSpecificMethod(specee);
        
    });
    
    card.appendChild(titleCard);
    card.appendChild(description);
    card.appendChild(action);
    zooSection.appendChild(card);
    
}
