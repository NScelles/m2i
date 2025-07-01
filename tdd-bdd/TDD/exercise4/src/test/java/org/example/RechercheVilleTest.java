package org.example;

import org.example.exeptions.NotFoundExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RechercheVilleTest {
   private RechercheVille rechercheVille;
   private List<String> exemples;


   @BeforeEach
   public void setUp() {
      rechercheVille = new RechercheVille();
      exemples = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok","Hong Kong", "Dubaï", "Rome", "Istanbul");
      rechercheVille.setVilles(exemples);
   }

   @Test
   public void whenRechercher_d_thenThrowNotFoundExeption() {
      //Arrange
      String motInferior3Caractere = "d";

      //Act Assert
      Assertions.assertThrows(NotFoundExeption.class, () -> {rechercheVille.rechercher(motInferior3Caractere);});
   }

   @Test
   public void whenRechercher_va_thenValanceVancouver(){

      //Arrange
      String motRechercher = "va";
      List<String> expected = List.of("Valence", "Vancouver");
      List<String> result;

      //Act
      result = rechercheVille.rechercher(motRechercher);

      //Assert
      Assertions.assertEquals(expected,result);
   }

   @Test
   public void whenRechercher_VaNcOuVeR_thenVancouver(){

      //Arrange
      String motRechercher = "VaNcOuVeR";
      List<String> expected = List.of("Vancouver");
      List<String> result;

      //Act
      result = rechercheVille.rechercher(motRechercher);

      //Assert
      Assertions.assertEquals(result, expected);
   }

   @Test
   public void whenRechercher_ape_thenBudapest(){
      //Arrange
      String motRechercher = "ape";
      List<String> expected = List.of("Budapest");
      List<String> result;

      //Act
      result = rechercheVille.rechercher(motRechercher);

      //Assert
      Assertions.assertEquals(result, expected);
   }

   @Test
   public void whenRechercher_asterisk_thenAll(){
      //Arrange
      String motRechercher = "*";
      List<String> expected = exemples;
      List<String> result;

      //Act
      result = rechercheVille.rechercher(motRechercher);

      //Assert
      Assertions.assertEquals(result, expected);
   }

}