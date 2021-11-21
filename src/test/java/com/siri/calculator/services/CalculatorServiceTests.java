package com.siri.calculator.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CalculatorServiceTests {

	CalculatorService calculatorService = new CalculatorService();

	@Test
	void testSimpleAddition() throws Exception {
		double actual = calculatorService.calculateFromString("1+1");
		double expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	void testSimpleMultiplication() {
		double actual = calculatorService.calculateFromString("4*5");
		double expected = 20;
		assertEquals(expected, actual);
	}

	@Test
	void testSimpleDivision() {
		double actual = calculatorService.calculateFromString("43/5");
		double expected = 8.6;
		assertEquals(expected, actual);
	}

	@Test
	void testBracketEquation() {
		double actual = calculatorService.calculateFromString("(4+3)*(4/2)");
		double expected = 14;
		assertEquals(expected, actual);
	}
	@Test
	void testDivisionByZero() {
		assertThrows(ArithmeticException.class,
				()->{calculatorService.calculateFromString("5/0");
		});
	}

	@Test
	void testWrongEquationParentheses() {
		String exceptionMessage = "Mismatched parentheses detected. Please check the expression";
		Throwable exception = assertThrows(IllegalArgumentException.class,
				()->{calculatorService.calculateFromString("(5+9*3");
				});
		assertTrue(exception.getMessage().equals(exceptionMessage));

	}

	@Test
	void testNoArgumentPassedWithMessage() {
		String exceptionMessage = "Please enter an equation to calculate";
		Throwable exception = assertThrows(IllegalArgumentException.class,
				()->{calculatorService.calculateFromString("");
				});
		assertTrue(exception.getMessage().equals(exceptionMessage));
	}

	@Test
	void testLettersPassedIn() {
		assertThrows(IllegalArgumentException.class,
				()->{calculatorService.calculateFromString("asdf");
				});
	}
}
