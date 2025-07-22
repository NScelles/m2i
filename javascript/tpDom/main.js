//Q.5
var formValid=[false,false,false];

function isEnable(){
    const nextButton = document.getElementById("next");
    nextButton.disabled=false;
    formValid.forEach(response=>{
        if(!response)
            nextButton.disabled=true;
    });
}

// Q.1 Dark Mode
const checker = document.querySelector('#isDark');
checker.addEventListener("change",()=>{
    (checker.checked) ? document.body.classList.add("dark") : document.body.classList.remove("dark");
});

// Q.2 Description Dynamique
const descriptions=[
    "C'est le maitre de l'air !!", 
    "C'est le maitre de quoi ??", 
    "Hello, I'm under the Water Please Help Me !!"
];
const descriptionButton = document.getElementById("desciptionButton");
function changeDescription(textes){
    let description = document.getElementById("description");
    let oldDescription = description.value;
    do{
        description.value = textes[Math.floor(Math.random() * textes.length)];
    }while(oldDescription == description.value);
    formValid[0]=true;
    isEnable();
}

changeDescription(descriptions);
descriptionButton.addEventListener("click", () => {
    changeDescription(descriptions);
});

//Q.3 
const pseudo = document.getElementById("pseudo");
pseudo.addEventListener("input", () => {
    let pseudo2 = document.getElementById("pseudo");
    let validity = document.getElementById("validity");
    
    if(!pseudo2.value.match(/^[a-zA-Z]+$/)){
        validity.textContent = "Que des lettres on a dit !";
        formValid[1]=false;
    }
    else{
        validity.textContent = " ";
        formValid[1]=true;
    }
    isEnable();
    });

// Q.4 

const avatars = document.querySelectorAll('input[type="radio"]');
const divAvatar = document.querySelectorAll(".avatar");


avatars.forEach((avatar)=>{
    avatar.addEventListener("input",()=>{
        formValid[2]=true;
        divAvatar.forEach((div)=>{
            div.id="";
        });
        avatar.parentElement.id="selected";
        isEnable()
    });
});


//Q.6

const nextButton = document.getElementById("next");
nextButton.addEventListener("click",()=>{
    const form = document.querySelector("form");
    form.hidden=true;
    
    const card = document.querySelector("#card");
    card.hidden=false

    document.getElementById("avatar").src = document.querySelector("#selected>label>img").src
    document.getElementById("desciption").innerText = document.querySelector("textarea").value
    document.getElementById("pseudoCard").textContent = document.getElementById("pseudo").value
});

const reload = document.getElementById("reload");
reload.addEventListener("click",()=>{
    location.reload();
})

