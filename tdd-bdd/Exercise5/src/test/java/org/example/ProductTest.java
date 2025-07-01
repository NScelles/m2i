package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductTest {
   private Product product;

   @BeforeEach
   public void setUp() {
      product = new Product();
      product.setName("Lorem ipsum");
      product.setType("Lorem ipsum");
   }

   @ParameterizedTest
   @CsvSource({
           "25,25,24,24",
           "1,1,0,0",
           "45,25,44,24"
   })
   public void whenUpdateQuality_n_Sellin_n_thenQuality_nless1_Sellin_nless1(int quality, int sellIn, int expectedQuality, int expectedSellIn) {

      //Arrange
      product.setQuality(quality);
      product.setSellin(sellIn);
      Product expected = Product.builder().quality(expectedQuality).sellin(expectedSellIn).type(product.getType()).name(product.getName()).build();

      //Act
      product.update();

      //Assert
      Assertions.assertEquals(expected,product);

   }

   @ParameterizedTest
   @CsvSource({
           "25,23",
           "2,0",
           "45,43"
   })
   public void whenUpdateSellin_0_thenQualityDowngrade2TimesFaster(int quality, int expectedQuality) {

      //Arrange
      product.setQuality(quality);
      product.setSellin(0);

      //Act
      product.update();

      //Assert
      Assertions.assertEquals(expectedQuality,product.getQuality());
   }

   @ParameterizedTest
   @ValueSource(ints = {0,25,50})
   public void whenUpdateQuality_0_thenQualityNeverNegative(int sellin){
      //Arrange
      product.setQuality(0);
      product.setSellin(sellin);

      //Act
      product.update();

      //Assert
      Assertions.assertTrue(product.getQuality()>=0);
   }

   @ParameterizedTest
   @ValueSource(ints = {0,25,50})
   public void whenUpdateQuality_50_thenQualityNeverOver50(int sellin){
      //Arrange
      product.setQuality(50);
      product.setSellin(sellin);

      //Act
      product.update();

      //Assert
      Assertions.assertTrue(product.getQuality()<=50);
   }

   @ParameterizedTest
   @CsvSource({
           "25,26",
           "1,2"
   })
   public void whenUpdateNameProduct_BrieVieilli_thenQualityUpgraded(int quality, int expectedQuality) {
      //Arrange
      product.setName("Brie vieilli");
      product.setQuality(quality);
      product.setSellin(25);

      //Act
      product.update();

      //Assert
      Assertions.assertEquals(expectedQuality,product.getQuality());
   }

   @ParameterizedTest
   @CsvSource({
           "25,25,23",
           "25,0,21",
   })
   public void whenUpdateTypeProduct_Milk_thenQualityDowngrade2TimesFasterThanNormalProduct(int quality, int sellin, int expectedQuality) {
      //Arrange
      product.setQuality(quality);
      product.setSellin(sellin);
      product.setType("Milk");

      //Act
      product.update();

      //Assert
      Assertions.assertEquals(expectedQuality,product.getQuality());
   }
}
