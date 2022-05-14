package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {

    private DietPlanner dietPlanner;
    @BeforeEach
    void setup(){
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void  afterEach(){
        System.out.println("A DietPlannerTest unit test was finished.");
    }
    @Test
    void should_ReturnCorrectDietPlan_when_CorrectCoder(){

        //given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);

        //when
        DietPlan actual = dietPlanner.calculateDiet(coder);

        //then
        /*that won't work because the objects itself are different
         albeit  have the same values:
                   assertEquals(expected, actual);
          And we should use field-by-field assertions:
         */
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }

}