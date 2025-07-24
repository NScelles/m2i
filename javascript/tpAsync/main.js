const sectionPreparation = document.querySelector("section#preparation");
const sectionExpedition = document.querySelector("section#expedition");
const sectionLivraison = document.querySelector("section#livraison");
const sectionMsg = document.querySelector("section#msg");

function attendre(ms) {
    return new Promise( (resolve,reject) => {
        if(Math.floor(Math.random() * 10) == 1)
            reject("Pcq t'as pas de chance mec");
        else
            setTimeout(resolve, ms);
    });
}

async function animerProgress(id, duree){
    const progressBar = document.getElementById(id);
    const interval = setInterval(()=>{
        progressBar.value++;
    },duree/100);
    await attendre(duree);
    clearInterval(interval);
}


document.getElementById("missionButton").addEventListener("click", async ()=>{
    sectionMsg.innerHTML=``;
    let msg;
    try{
        sectionPreparation.hidden=false;
        await attendre(500);
        await animerProgress("preparationBar",2000);
        document.querySelector("section#preparation>.status").innerHTML=
        `<p><strong> Préparation Terminé </stong></p>`;
        await attendre(2000);
        sectionPreparation.querySelector("input").hidden=true;

        sectionExpedition.hidden=false;
        await animerProgress("expeditionBar",1500);
        document.querySelector("section#expedition>.status").innerHTML=
        `<p><strong> Expédition Terminé </stong></p>`;
        await attendre(2000);
        sectionExpedition.querySelector("input").hidden=true;
        sectionLivraison.hidden=false;

        await animerProgress("livraisonBar",2500); 
        document.querySelector("section#livraison>.status").innerHTML=
        `<p><strong> Livré </stong></p>`;
        await attendre(2000);
        sectionLivraison.querySelector("input").hidden=true;
        msg = "Commande Livré";
    } catch(e){
        msg = e;
    } finally {
        sectionPreparation.hidden=true;
        sectionExpedition.hidden=true;
        sectionLivraison.hidden=true;
        sectionPreparation.querySelector("input").hidden=false;
        sectionPreparation.querySelector("input").value=0;
        sectionExpedition.querySelector("input").hidden=false;
        sectionExpedition.querySelector("input").value=0;
        sectionLivraison.querySelector("input").hidden=false;
        sectionLivraison.querySelector("input").value=0;
        sectionMsg.innerHTML=`<p><strong> ${msg} </stong></p>`;
    }
}); 


