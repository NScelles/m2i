package org.example;

import junit.framework.JUnit4TestAdapter;
import junit.framework.JUnit4TestCaseFacade;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.Description;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DiceScoreTest {

    private DiceScore diceScore;
    private Ide de = Mockito.mock(Ide.class);

    @BeforeEach
    public void setUp() {
        diceScore = new DiceScore(de);
    }

    @Test
    public void whenGetScore_SameDiceScore_ThenReturnDiceScoreMultiply2Plus10() {
        //Arrange

        int sameDiceScore = 1;
        int awaitResult = sameDiceScore * 2 + 10;
        int result;

        //Act
        Mockito.when(de.getRoll()).thenReturn(sameDiceScore);
        result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(awaitResult, result);
    }

    @Test
    public void whenGetScore_DicesEquals6_ThenReturn30() {
        //Arrange
        int dicesEquals6 = 6;
        int awaitResult = 30;
        int result;

        //Act
        Mockito.when(de.getRoll()).thenReturn(dicesEquals6);
        result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(awaitResult, result);
    }

    @Test
    public void whenGetScore_DefaultDiceScore_ThenReturnDiceHighestScoreOfBoth() {
        //Arrange
        int scoreFirstDice = 6;
        int scoreSecondDice = 1;
        int awaitResult = Math.max(scoreFirstDice, scoreSecondDice);
        int result;

        //Act
        Mockito.when(de.getRoll()).thenReturn(scoreFirstDice).thenReturn(scoreSecondDice);

        result = diceScore.getScore();

        //Assert
        Assertions.assertEquals(awaitResult, result);
    }
}
