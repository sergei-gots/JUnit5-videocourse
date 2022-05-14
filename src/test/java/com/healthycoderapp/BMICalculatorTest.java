package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//NOT THIS: import java.lang.reflect.Executable; BUT!:
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;


class BMICalculatorTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all BMICalculatorTest unit tests.");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all  BMICalculatorTest unit tests.");
    }

    @Test
   void should_ReturnTrue_when_DietRecommended(){

        /* assertTrue(BMICalculator.isDietRecommended(89.0, 1.72)); */

        //Arrange - Act - Assert:

        //given
        double weight = 89.0;
        double height = 1.72;

        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(recommended);

    }

    @Test
    void should_ReturnFalse_when_DietNotRecommended(){

        /* assertTrue(BMICalculator.isDietRecommended(89.0, 1.72)); */

        //Arrange - Act - Assert:

        //given
        double weight = 50.0;
        double height = 1.92;

        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertFalse(recommended);

    }

    @Test
    void should_ThrowArithmeticException_when_HeightZero(){

        //Arrange - Act - Assert:

        //given
        double weight = 50.0;
        double height = 0.0;

        //when
        Executable executable    = ()-> BMICalculator.isDietRecommended(weight, height);

        //then
        assertThrows(ArithmeticException.class, executable);


    }

    @Test
    void should_ReturnCoderWithWorstBMI_when_CoderListIsNotEmpty(){

        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertAll(
                ()->assertEquals(1.82, coderWorstBMI.getHeight()),
                ()->assertEquals(98.0, coderWorstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnCoderWithWorstBMI_when_CoderListIsEmpty(){

        //given
        List<Coder> coders = new ArrayList<>();

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertNull(coderWorstBMI);
    }
    @Test
    void should_ReturnCorrectBMIScoreArray_when_CoderListIsNotEmpty(){

        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        //double[] expected = {18.52, 29.59, 19.53};
        double[] expected = {18.52, 29.59, 19.53};

        //when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        //then
        assertArrayEquals(expected, bmiScores);

    }
}