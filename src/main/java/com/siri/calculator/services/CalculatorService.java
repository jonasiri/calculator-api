package com.siri.calculator.services;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

	public double calculateFromString(String calculation) {

		if (calculation == null || calculation.equals("")) {
			throw new IllegalArgumentException("Please enter an equation to calculate");
		}


			Expression e = new ExpressionBuilder(calculation)
					.variable(calculation)
					.build();

			double res = e.evaluate();
			return res;

	}
}
