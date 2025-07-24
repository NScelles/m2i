export class Animal {
    constructor(nom, age) {
      this.nom = nom;
      this.age = age;
    }
  
    sePresenter() {
      return `Je suis ${this.nom}, j'ai ${this.age} ans.`;
    }
  
    crier() {
      return "Cet animal fait un bruit indéfini.";
    }
  }
  