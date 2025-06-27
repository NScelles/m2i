package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class FibTest
{
    private Fib fib;

    @Test
    public void whenGetFibSeries_1_Then_Result_IsNotEmpty(){
        //Arrange
        int range = 1;
        fib = new Fib(range);
        List<Integer> result;
        List<Integer> awaitResult = List.of(0);
        //Act
        result = fib.getFibSeries();
        //Assert
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    public void whenGetFibSeries_1_Then_Result_IsEqualsList_0(){
        //Arrange
        int range = 1;
        fib = new Fib(range);
        List<Integer> result;
        List<Integer> awaitResult = List.of(0);
        //Act
        result = fib.getFibSeries();
        //Assert
        Assertions.assertEquals(awaitResult, result);
    }

    @Test
    public void whenGetFibSeries_6_Then_ListIntRange_6(){
        //Arrange
        int range = 6;
        fib = new Fib(range);
        List<Integer> result;
        List<Integer> awaitResult = List.of(0,1,1,2,3,5);
        //Act
        result = fib.getFibSeries();
        //Assert
        Assertions.assertTrue(result.contains(3));
        Assertions.assertEquals(range, result.size());
        Assertions.assertFalse(result.contains(4));
        Assertions.assertEquals(awaitResult, result);

        var iteratorNext = result.iterator();
        iteratorNext.next();
        iteratorNext.remove();
        while (iteratorNext.hasNext())
            Assertions.assertTrue(result.iterator().next() <= iteratorNext.next());

        //Assertions.assertEquals(awaitResult.stream().sorted().toList(), result);
    }
}