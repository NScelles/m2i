import { createAnimal, getImage, getSpecee, getSpecificMethod } from "./models/animals/animalUtils.js";
import { Animal } from "./models/animals/animal.js";

var zoo = [];
const addAnimalButton = document.querySelector("form>button");
const animalName = document.getElementById("animalName");
const animalAge = document.getElementById("animalAge");
const animalSpecee = document.getElementById("animalSpecee");
const zooSection = document.getElementById("zoo");
const animalAction = document.querySelector("section#animalAction>p");

addAnimalButton.addEventListener("click",()=>{
    const animal = createAnimal(
        animalSpecee.value,
        animalName.value,
        animalAge.value
    );
    addAnimal(animal);
    createCard(animal);
});

function createCard(animal){
    const card = document.createElement("div");  
    const titleCard = document.createElement("h2");  
    const description = document.createElement("p");  
    const action = document.createElement("button");
    const killButton = document.createElement("button");
    const image = document.createElement("img");

    titleCard.textContent = animal.sePresenter();
    description.textContent = animal.crier() + " Je suis un " + getSpecee(animal);
    action.textContent = "action";
    action.addEventListener("click",()=>{
        animalAction.textContent = getSpecificMethod(animal);
        
    });
    killButton.textContent = "Kill"
    killButton.addEventListener("click",()=>{
        removeAnimal(animal);
        showZoo();
    });
    image.src=getImage(animal);

    card.appendChild(image);
    card.appendChild(titleCard);
    card.appendChild(description);
    card.appendChild(action);
    card.appendChild(killButton);
    zooSection.appendChild(card);
}

function showZoo(){
    zooSection.innerHTML="";
    zoo.forEach((animal)=>{
        createCard(animal)
    });
}

function addAnimal(animal){
    zoo.push(animal);
    registerToLocalStorage();
}

function removeAnimal(animal){
    zoo = zoo.filter(zooAnimal => animal!==zooAnimal);
    registerToLocalStorage();
}

window.addEventListener("DOMContentLoaded",()=>{
    getZooLocalStorage();
    console.log(zoo);
    showZoo();
});

function registerToLocalStorage(){
    let zooJson = []; 
    zoo.forEach((animalZoo)=>{
        let animalObject = {
            "animal":JSON.stringify(animalZoo),
            "specee":getSpecee(animalZoo)
        }
        zooJson.push(animalObject);
    })
    localStorage.setItem("zoo",JSON.stringify(zooJson));
}

function getZooLocalStorage(){
    let zooJson = JSON.parse(localStorage.getItem("zoo"));
    console.log(zooJson);
    
    zooJson.forEach((animalZoo)=>{
        let animalObject = JSON.parse( animalZoo["animal"]);
        zoo.push(createAnimal(animalZoo["specee"],
            animalObject["nom"],
            animalObject["age"]
        ));
    })
}

