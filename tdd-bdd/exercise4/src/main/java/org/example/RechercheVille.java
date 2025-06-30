package org.example;

import lombok.Data;
import org.example.exeptions.NotFoundExeption;
import org.example.exeptions.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RechercheVille {
   private List<String> villes;

   public List<String> rechercher(String mot)  {
      List<String> found = new ArrayList<>();
      if(mot.equals("*"))
         return villes;
      if (mot.length() >= 2){
         found.addAll(villes.stream().map(String::toLowerCase).filter(v -> v.startsWith(mot.toLowerCase())).toList());
         found.addAll(villes.stream().map(String::toLowerCase).filter(v-> !found.contains(v)).filter(v -> v.contains(mot.toLowerCase())).toList());
         found.addAll(villes.stream().map(String::toLowerCase).filter(v-> !found.contains(v)).filter(v -> v.equals(mot.toLowerCase())).toList());
         return found.stream().map(v -> { return v.substring(0,1).toUpperCase() + v.substring(1);}).toList();
      }
      throw new NotFoundExeption("Ville inexistante");
   }
}