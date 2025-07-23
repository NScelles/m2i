var user = {
    "pseudo":"",
    "description":"",
    "image":""
};
var formValid=[false,false,false];
const checker = document.querySelector('#isDark');
const descriptions=[
    "C'est le maitre de l'air !!", 
    "C'est qui lui ??", 
    "Hello, I'm under the Water Please Help Me !!"
];
const descriptionButton = document.getElementById("desciptionButton");
const pseudo = document.getElementById("pseudo");
const avatars = document.querySelectorAll('input[type="radio"]');
const divAvatar = document.querySelectorAll(".avatar");
const nextButton = document.getElementById("next");
const reload = document.getElementById("reload");

function isEnable(){
    const nextButton = document.getElementById("next");
    nextButton.disabled=false;
    formValid.forEach(response=>{
        if(!response)
            nextButton.disabled=true;
    });
}

checker.addEventListener("change",()=>{
    (checker.checked) ? document.body.classList.add("dark") : document.body.classList.remove("dark");
});

// Q.2 Description Dynamique

function changeDescription(textes){
    let description = document.getElementById("description");
    let oldDescription = description.value;
    do{
        description.value = textes[Math.floor(Math.random() * textes.length)];
    }while(oldDescription == description.value);
    formValid[0]=true;
    isEnable();
}

window.addEventListener("DOMContentLoaded", changeDescription(descriptions));
descriptionButton.addEventListener("click", () => {
    changeDescription(descriptions);
});

//Q.3 
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

nextButton.addEventListener("click",()=>{
    user["pseudo"] = document.getElementById("pseudo").value;
    user["description"] = document.querySelector("textarea").value;
    user["image"] = document.querySelector("#selected>label>img").src;
    localStorage.setItem("user",JSON.stringify(user));
    showProfile();
});

reload.addEventListener("click",()=>{
    localStorage.clear();
    user = {
        "pseudo":"",
        "description":"",
        "image":""
    };
    location.reload();
})

// LocalStorage

function showProfile(){ 
    let user = JSON.parse(localStorage.getItem("user"));
    if(user["pseudo"]!=""){
        const form = document.querySelector("form");
        form.hidden=true;
        const card = document.querySelector("#card");
        card.hidden=false
        
        document.getElementById("avatar").src = user["image"];
        document.getElementById("desciption").innerText = user["description"];
        document.getElementById("pseudoCard").textContent = user["pseudo"];
    }
}

window.addEventListener("DOMContentLoaded", showProfile());

