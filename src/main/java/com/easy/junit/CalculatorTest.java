package com.easy.junit;

/**
 * @author cc
 * @date 2023/6/15-0:04
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;


import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass executed.");
        calculator = new Calculator();
    }

    @Before
    public void before() {
        System.out.println("Before executed.");
    }

    @Test
    public void addTest() {
        System.out.println("Add test executed.");
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    public void subtractTest() {
        System.out.println("Subtract test executed.");
        assertEquals(0, calculator.subtract(1, 1));
    }

    @After
    public void after() {
        System.out.println("After executed.");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass executed.");
        calculator = null;
    }
}
