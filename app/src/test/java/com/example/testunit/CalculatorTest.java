package com.example.testunit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals("8", calculator.add(5, 3));
        assertEquals("0", calculator.add(0, 0));
        assertEquals("-2", calculator.add(-5, 3));
        assertEquals("0.3", calculator.add(0.1, 0.2));
    }

    @Test
    public void testSubtract() {
        assertEquals("2", calculator.subtract(5, 3));
        assertEquals("0", calculator.subtract(0, 0));
        assertEquals("-8", calculator.subtract(-5, 3));
        assertEquals("-0.1", calculator.subtract(0.1, 0.2));
    }

    @Test
    public void testMultiply() {
        assertEquals("15", calculator.multiply(5, 3));
        assertEquals("0", calculator.multiply(0, 5));
        assertEquals("-15", calculator.multiply(-5, 3));
        assertEquals("0.02", calculator.multiply(0.1, 0.2));
    }

    @Test
    public void testDivide() {
        assertEquals("1.66666667", calculator.divide(5, 3));
        assertEquals("0", calculator.divide(0, 5));
        assertEquals("0", calculator.divide(5, 0)); // Kiểm tra chia cho 0
        assertEquals("-1.66666667", calculator.divide(-5, 3));
        assertEquals("0.5", calculator.divide(0.1, 0.2));
    }

    @Test
    public void testPercentage() {
        assertEquals("0.5", calculator.percentage(50));
        assertEquals("0", calculator.percentage(0));
        assertEquals("1", calculator.percentage(100));
        assertEquals("-0.05", calculator.percentage(-5));
    }

    @Test
    public void testChangeSign() {
        assertEquals("-5", calculator.changeSign(5));
        assertEquals("5", calculator.changeSign(-5));
        assertEquals("0", calculator.changeSign(0));
    }

    @Test
    public void testParseInput() {
        assertEquals(5.0, calculator.parseInput("5"), 0.0001);
        assertEquals(5.5, calculator.parseInput("5,5"), 0.0001);
        assertEquals(5.5, calculator.parseInput("5.5"), 0.0001);
        assertEquals(-5.5, calculator.parseInput("-5,5"), 0.0001);
    }

    @Test
    public void testCalculate() {
        assertEquals("8", calculator.calculate(5, 3, "+"));
        assertEquals("2", calculator.calculate(5, 3, "−"));
        assertEquals("15", calculator.calculate(5, 3, "×"));
        assertEquals("1.66666667", calculator.calculate(5, 3, "÷"));
        assertEquals("0", calculator.calculate(5, 0, "÷")); // Chia cho 0
    }
}