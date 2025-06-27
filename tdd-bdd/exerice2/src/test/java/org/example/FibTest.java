package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.Parameter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class FibTest
{
    private Fib fib;

    @Test
    public void whenGetFibSeries_1_Then_ListIntRange_1(){
        //Arrange
        int range = 1;
        fib = new Fib(range);
        List<Integer> result;
        List<Integer> awaitResult = List.of(0);
        //Act
        result = fib.getFibSeries();
        //Assert
        Assertions.assertNotEquals(0, result.size());
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
        System.out.println(result);
        Assertions.assertTrue(result.contains(3));
        Assertions.assertEquals(range, result.size());
        Assertions.assertFalse(result.contains(4));
        Assertions.assertEquals(awaitResult, result);
        Assertions.assertEquals(awaitResult.stream().sorted().toList(), result);
    }
}