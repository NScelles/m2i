package example;

import org.example.GradingCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GradingCalculatorTest {
    private GradingCalculator calculator;

    @ParameterizedTest
    @CsvSource({"95,90,A",
                    "95,90,A",
                    "85,90,B",
                    "65,90,C",
                    "95,65,B",
                    "95,55,F",
                    "65,55,F",
                    "50,90,F"
    })
    public void whenGetGrade_GradeAndPresence_ThenAwaitedGrade(int grade, int presence, char awaitedGrade) {
        calculator = new GradingCalculator(grade, presence);
        Assertions.assertEquals(awaitedGrade, calculator.getGrade());
    }

    /// Méthode 2

//    @ParameterizedTest
//    @MethodSource("providerParameter")
//    public void whenGetGrade_GradeAndPresence_ThenAwaitedGrade(int grade, int presence, char awaitedGrade) {
//        calculator = new GradingCalculator(grade, presence);
//        Assertions.assertEquals(awaitedGrade, calculator.getGrade());
//    }
//
//    private static Stream<Arguments> providerParameter() {
//        return Stream.of(
//                Arguments.of(95,90,'A'),
//                Arguments.of(85,90,'B'),
//                Arguments.of(65,90,'C'),
//                Arguments.of(95,65,'B'),
//                Arguments.of(95,55,'F'),
//                Arguments.of(65,55,'F'),
//                Arguments.of(50,90,'F')
//        );
//    }

    /// Méthode 1

//    @Test
//    public void whenGetGrade_95_90_Then_A(){
//
//        // Arrange
//        int score = 95;
//        int attendancePercentage = 90;
//        calculator = new GradingCalculator(score, attendancePercentage);
//
//        //Act
//        char result = calculator.getGrade();
//
//        //Assert
//        Assert.assertEquals('A', result);
//
//    }
//
//    @Test
//    public void whenGetGrade_85_90_Then_B(){
//        // Arrange
//        int score = 85;
//        int attendancePercentage = 90;
//        calculator = new GradingCalculator(score, attendancePercentage);
//
//        //Act
//        char result = calculator.getGrade();
//
//        //Assert
//        Assert.assertEquals('B', result);
//    }
//
//    @Test
//    public void whenGetGrade_65_90_Then_C(){
//        // Arrange
//        int score = 65;
//        int attendancePercentage = 90;
//        calculator = new GradingCalculator(score, attendancePercentage);
//
//        //Act
//        char result = calculator.getGrade();
//
//        //Assert
//        Assert.assertEquals('C', result);
//    }
//
//    @Test
//    public void whenGetGrade_95_65_Then_B(){
//        // Arrange
//        int score = 95;
//        int attendancePercentage = 65;
//        calculator = new GradingCalculator(score, attendancePercentage);
//
//        //Act
//        char result = calculator.getGrade();
//
//        //Assert
//        Assert.assertEquals('B', result);
//    }
//
//    @Test
//    public void whenGetGrade_95_55_Then_F(){
//        // Arrange
//        int score = 95;
//        int attendancePercentage = 55;
//        calculator = new GradingCalculator(score, attendancePercentage);
//
//        //Act
//        char result = calculator.getGrade();
//
//        //Assert
//        Assert.assertEquals('F', result);
//    }
//
//    @Test
//    public void whenGetGrade_65_55_Then_F(){
//        // Arrange
//        int score = 65;
//        int attendancePercentage = 55;
//        calculator = new GradingCalculator(score, attendancePercentage);
//
//        //Act
//        char result = calculator.getGrade();
//
//        //Assert
//        Assert.assertEquals('F', result);
//    }
//
//    @Test
//    public void whenGetGrade_50_90_Then_F(){
//        // Arrange
//        int score = 50;
//        int attendancePercentage = 90;
//        calculator = new GradingCalculator(score, attendancePercentage);
//
//        //Act
//        char result = calculator.getGrade();
//
//        //Assert
//        Assert.assertEquals('F', result);
//    }

}