package com.siri.calculator.services;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public double calculateFromString(String calculation) {

		if (calculation == null || calculation.equals("")) {
			throw new IllegalArgumentException("Please enter an equation to calculate");
		}


			Expression e = new ExpressionBuilder(calculation)
					.variable(calculation)
					.build();

			return e.evaluate();

	}
}
