package org.example.tpcomputer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/** On met @Embeddable pour signifier que la classe sera contenu dans une autre table
 * sur laquelle on viendra mettre @Embedded pour y faire le lien (Voir Classe Computeur)
 *
 * Donc dans la BDD, on aura une seule table avec les attributs de la classe Computer et aussi de la classe Identification
 *
 * ATTENTION :
 * ne pas mettre le @Entity sur la classe @Embeddable car sinon JPA en fera une Table en BDD et on perd l'interet de @Embeddable
 * Ainsi, si tu as compris ne pas mettre aussi d'@Id parce que la classe @Embeddable n'est pas une table dans la BDD
 * On ne fera pas non plus de IndentificationDao
 */
@Embeddable
public class Identification {
    private String macAddress;
    private String ipAddress;
}
