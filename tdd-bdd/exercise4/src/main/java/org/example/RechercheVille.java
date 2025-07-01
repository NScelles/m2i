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
       if(mot.equals("*"))
         return villes;
      if (mot.length() >= 2)
         return new ArrayList<>(villes.stream()
                 .filter(v ->
                         v.toLowerCase().equals(mot.toLowerCase()) ||
                         v.toLowerCase().contains(mot.toLowerCase()) ||
                         v.toLowerCase().startsWith(mot.toLowerCase())
                 ).toList());
      throw new NotFoundExeption("Ville inexistante");
   }
}