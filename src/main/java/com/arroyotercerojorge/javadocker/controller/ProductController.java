package com.arroyotercerojorge.javadocker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/")
	public String list() {
		logger.info("Entra por raiz");
		logger.info("Cambio en caliente");
		return "products";
	}
}