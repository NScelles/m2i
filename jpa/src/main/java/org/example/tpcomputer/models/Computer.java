package org.example.tpcomputer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String model;

    /**
     * On met @Embedded pour signifier que l'attribut contient aussi les attributs de la classe dit "embarqué"
     * sur laquelle on viendra mettre @Embedded pour y faire le lien (Voir Classe Identification)
     *
     * Donc dans la BDD, on aura une seule table avec les attributs de la classe Computer et aussi de la classe Identification
     */
    @Embedded
    private Identification identification;

    /**
     * Relation @OneToMany et @ManyToOne :
     * Tu as deux types de relations : les unidirectionnelles et les bidirectionnelles
     * avec le @JoinColumn dans les 2 classes que tu relies, c'est unidirectionnelle et
     * avec 1 seul @JoinColumn et un (mapped by=?) c'est bidirectionnelle
     *
     * bidirectionnelle : ça veut dire que quand tu vas récupérer les données de la table 1,
     *                    tu vas récupérer les données qui lui sont associées dans la table 2
     *                    et pareil quand tu vas récuperer les données de la table 2 tu vas aussi récuperer les données
     *                    de la table 1
     *
     * unidirectionnelle : ça veut dire que quand tu vas récupérer les données de la table 1,
     *                     tu vas récupérer les données qui lui sont associées dans la table 2 mais
     *                     quand tu vas récuperer les données de la table 2 tu ne récupéreras les données de la Table 1
     *
     *  DANS Le TP : Quand je récupère les données de Computer je récupères aussi les données de OS et de Processor.
     *               Quand je récupère les données de OS comme je suis en unidirectionnelle je récupère que les données de la table OS.
     *               Quand je récupère les données de Processor comme je suis en Bidirectionnelle je récupère aussi les données des Computer associés.
     *
     *
     * dans les parentheses :
     *
     * (name = ?), tu vas mettre le nom que la colonne va avoir dans le BDD
     * (mappedBy = "?") Voir Classe Processor, tu vas mettre le nom de l'attribut comme clé secondaire ici computer correspond au processor de la classe Computer)
     * (cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
     * Pour la cascade tu connais déja le DELETE CASCADE dans SQL ici c'est le même principe
     * sauf que PERSIST ça va enregistrer les données en même temps que la classe je m'explique:
     * Exemple : J'ai 2 tables Personne et Adresse Quand j'enregistre une Personne, si je Cascade.PERSIST sur Adresse, grâce au PERSIST,
     * je vais enregistrer l'Adresse en même temps que la Personne
     *
     * Et pour REFRESH c'est pour garder à jour ta BDD en local mais c'est utile que quand tu es plusieurs sur une même BDD
     * En gros c'est utile qu'en entreprise
     * Aucune cascade n'est pas utilisé ici car cela n'est pas utile
     */
    @ManyToOne
    @JoinColumn(name = "id_os")
    private OperatingSystem operatingSystem;

    @ManyToOne
    @JoinColumn(name = "id_processor")
    private Processor processor;

    /**
     * Pour la dernière partie du TP, on a ajouté une relation @ManyToMany
     * Il n'y pas grand de différent par rapport à une @ManyToOne
     * Seulement la syntaxe (Voir la Classe Project)
     * et la création d'une table d'association qui est faite automatiquement par JPA.
     */

    @ManyToMany(mappedBy = "computers")
    private List<Project> projects;

    @Override
    public String toString() {
        return "\nComputer: " +
                id +
                " | model:" + model +
                " | " + identification.getDisplay() +
                " | OS: [" + operatingSystem.getDisplay() + "]" +
                " | Processeur: [" + processor.getDisplay() + "]";
    }
}
