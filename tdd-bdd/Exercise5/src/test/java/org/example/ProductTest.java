package org.example;


import org.junit.jupiter.api.Test;

public class ProductTest {
   private Product product;

   @Test
   public void whenUpdateQuality_25_Sellin_25_thenQuality_24_Sellin_24() {

   }

   @Test
   public void whenUpdateExpiryDate_0_thenQualityDowngrade2TimesFaster(){

   }

   @Test
   public void whenUpdateQuality_0_thenQualityNeverNegative(){

   }

   @Test
   public void whenUpdateQuality_50_thenQualityNeverOver50(){

   }

   @Test
   public void whenUpdateNameProduct_BrieVieilli_thenQualityUpgraded(){

   }

   @Test
   public void whenUpdateTypeProduct_Milk_thenQualityDowngrade2TimesFasterThanNormalProduct(){

   }
}
