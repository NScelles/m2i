package example;

import org.example.GradingCalculator;
import org.junit.Assert;
import org.junit.Test;

public class GradingCalculatorTest {
    private GradingCalculator calculator;

    @Test
    public void whenGetGrade_95_90_Then_A(){

        // Arrange
        int score = 95;
        int attendancePercentage = 90;
        calculator = new GradingCalculator(score, attendancePercentage);

        //Act
        char result = calculator.getGrade();

        //Assert
        Assert.assertEquals('A', result);
        
    }

    @Test
    public void whenGetGrade_85_90_Then_B(){
        // Arrange
        int score = 85;
        int attendancePercentage = 90;
        calculator = new GradingCalculator(score, attendancePercentage);

        //Act
        char result = calculator.getGrade();

        //Assert
        Assert.assertEquals('B', result);
    }

    @Test
    public void whenGetGrade_65_90_Then_C(){
        // Arrange
        int score = 65;
        int attendancePercentage = 90;
        calculator = new GradingCalculator(score, attendancePercentage);

        //Act
        char result = calculator.getGrade();

        //Assert
        Assert.assertEquals('C', result);
    }

    @Test
    public void whenGetGrade_95_65_Then_B(){
        // Arrange
        int score = 95;
        int attendancePercentage = 65;
        calculator = new GradingCalculator(score, attendancePercentage);

        //Act
        char result = calculator.getGrade();

        //Assert
        Assert.assertEquals('B', result);
    }

    @Test
    public void whenGetGrade_95_55_Then_F(){
        // Arrange
        int score = 95;
        int attendancePercentage = 55;
        calculator = new GradingCalculator(score, attendancePercentage);

        //Act
        char result = calculator.getGrade();

        //Assert
        Assert.assertEquals('F', result);
    }

    @Test
    public void whenGetGrade_65_55_Then_F(){
        // Arrange
        int score = 65;
        int attendancePercentage = 55;
        calculator = new GradingCalculator(score, attendancePercentage);

        //Act
        char result = calculator.getGrade();

        //Assert
        Assert.assertEquals('F', result);
    }

    @Test
    public void whenGetGrade_50_90_Then_F(){
        // Arrange
        int score = 50;
        int attendancePercentage = 90;
        calculator = new GradingCalculator(score, attendancePercentage);

        //Act
        char result = calculator.getGrade();

        //Assert
        Assert.assertEquals('F', result);
    }

}