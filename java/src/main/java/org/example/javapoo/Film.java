package org.example.javapoo;

public class Film {
    String titre;
    String realisateur;
    int anneeSortie;
    String genre;

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", anneeSortie=" + anneeSortie +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(int anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Film() {
        this.titre = "La Passion du Christ";
        this.realisateur = "Mel Gibson";
        this.anneeSortie = 2004;
        this.genre = "Drame";
    }

    public Film(String titre, String realisateur, int anneeSortie, String genre) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.anneeSortie = anneeSortie;
        this.genre = genre;
    }
}
