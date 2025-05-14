package org.example.jeudupendu;

import static org.example.outils.Outils.getString;

public class main {
    public static void main(String[] args) {
        final String leMot = demandeMot();
        String reponse= initMotCachee(leMot), lettreDonne, lettresDonnes = "";
        int vie=10;

        do{
            afficheStatusJeu(reponse,vie,lettresDonnes);
            lettreDonne= demandeLettre();
            if (!lettresDonnes.contains(lettreDonne))
                lettresDonnes += lettreDonne + " ";
            if(leMot.contains(lettreDonne))
                reponse = decouvrirLettre(reponse,leMot,lettreDonne);
            else
                vie--;

            if(vie<0) {
                System.out.println("Vous avez perdu ! \n le mot était " + leMot);
                break;
            }
        }while (!leMot.equals(reponse));

        System.out.println("Bravo vous trouvé le mot " + leMot);
    }

    public static String demandeMot(){
        boolean isCorrectWord = true;
        String motDonne = "";
        do{
            motDonne = getString("Donnez un mot français : ");
            if (motDonne.trim().isEmpty()){
                System.out.println("Votre mot est invalide");
                isCorrectWord = false;
            }
            else
                isCorrectWord = true;
        }while (!isCorrectWord);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        return motDonne.toLowerCase();
    }

    public static String initMotCachee(String leMot){
        String motCachee = "";
        for (int i=0;i<leMot.length();i++)
            if (Character.isLetter(leMot.charAt(i)))
                motCachee += "_";
            else
                motCachee += leMot.substring(i,i+1);
        return motCachee;
    }

    public static void afficheStatusJeu(String reponse,int vie, String lettresDonnees) {
        System.out.println("Le mot : " + reponse);
        System.out.println("Il vous reste " + vie + " vie(s)");
        if (!lettresDonnees.trim().isEmpty())
            System.out.println("Vous avez déjà donné les lettres " + lettresDonnees);
    }

    public static String demandeLettre(){
        String string="";
        do {
            string = getString("Donné une lettre").toLowerCase().substring(0,1);
        }while (!Character.isLetter(string.charAt(0)));
        return string;
    }

    public static String decouvrirLettre(String reponseUtilisateur, String leMot,String lettreDonne) {

        String resultatLettreDonne = "";
        String[] tabMotTrouve=reponseUtilisateur.split("");
            for (int i=0;i<leMot.length();i++){
                if(lettreDonne.equals(leMot.substring(i, i + 1)))
                    tabMotTrouve[i] = lettreDonne;
                resultatLettreDonne+=tabMotTrouve[i];
            }
        return resultatLettreDonne;
    }


}
