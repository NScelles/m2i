// Q.1
const playerScores=[30, 45, 52, 65, 79,92.1,100];

//Q.2

function filtrerScores(scores, callback){
    let filtered = [];
    scores.forEach(score => {
        if(callback(score))
            filtered.push(score);
    });
    return filtered;
}

//Q.3
function estExcellent(score){
    return score>=90;
}

function estMoyen(score){
    return score>=50 && score < 80;
}

function estInsuffisant(score){
    return score<50;
}

console.log("Scores excellents : " + filtrerScores(playerScores,estExcellent))
console.log("Scores moyens : " + filtrerScores(playerScores,estMoyen))
console.log("Scores insuffisants : " + filtrerScores(playerScores,estInsuffisant))



// Bonus 
function doubler(score) { return score * 2; }
function arrondir(score) { return Math.round(score); }

function traiterScores(scores, callback){
    return scores.map(score=>callback(score));  
}

console.log(traiterScores(playerScores,doubler));
console.log(traiterScores(playerScores,arrondir));