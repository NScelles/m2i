package org.example;

import lombok.Data;
import org.example.exeptions.NotImplementedException;

import java.util.List;

@Data
public class RechercheVille {
   private List<String> villes;

   public List<String> rechercher(String mot)  {
      throw new NotImplementedException("Not implemented yet");
   }
}