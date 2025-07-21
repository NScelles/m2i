// Q.1
const playerScores=[78, 95, 48, 63, 85];

//Q.2

function afficherScores(scores){
    console.log("Scores des joueurs :");
    console.table(scores);
    // OU
    scores.forEach(score => {
        console.log(score);
    });
}


//Q.3
function moyenne(scores){
    let som = 0;
    // scores.forEach(score => {
    //     som+=score;
    // });
    for(let i=0;i<scores.length;i++)
        som = som + scores[i];
    console.log("Score moyen : " + (som/scores.length));
}


//Q.4
function meilleurScore(scores){
    return scores.sort((b,a) => a - b)[0];
}

//Q.5
function mention(score){
        if (score<50) return "Insuffisant";
        if (score<=64) return "Passable";
        if (score<=79)  return "Bien";
        if (score<=89) return "Très bien"; 
        if (score<=100) return "Excellent";
}

//Q.6
function showMention(scores){
    for(let i=0;i<scores.length;i++)
        console.log("Joueur "+ (i+1) + " : " + mention(playerScores[i]));
}

afficherScores(playerScores);
moyenne(playerScores);
console.log("Meilleur score : " + meilleurScore(playerScores));
showMention(playerScores);

//Bonus

function nombreMentions(scores){
    let result = {
        "Insuffisant":0,
        "Passable":0,
        "Bien":0,
        "Très bien":0,
        "Excellent":0
    };
    scores.forEach(score=>{
        switch(mention(score)){
            case "Insuffisant":result["Insuffisant"]++; break;
            case "Passable":result["Passable"]++; break;
            case "Bien":result["Bien"]++; break;
            case "Très bien":result["Très bien"]++; break;
            case "Excellent":result["Excellent"]++; break;
        }
    });
    return result; 
}

console.log(nombreMentions(playerScores));
    
