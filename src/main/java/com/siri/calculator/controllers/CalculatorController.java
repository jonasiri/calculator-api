package com.siri.calculator.controllers;

import com.siri.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jonathan Siri
 */
@ConfigurationProperties
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;


	@ResponseBody
	@GetMapping("/calculate")
	public Object calculateString(@RequestParam(value="calculation", defaultValue="") String calculation) throws Exception {
		try {
			double response = calculatorService.calculateFromString(calculation);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (IllegalArgumentException illegalArgumentException) {
			return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		} catch (ArithmeticException arithmeticException) {
			return new ResponseEntity<>(arithmeticException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
