package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class BMICalculatorTest {

    @Test
   void should_ReturnTrue_When_DietRecommended(){

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
    void should_ReturnFalse_When_DietRecommended(){

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


}