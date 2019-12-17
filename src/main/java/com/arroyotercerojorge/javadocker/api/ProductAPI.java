package com.arroyotercerojorge.javadocker.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arroyotercerojorge.javadocker.model.Product;
import com.arroyotercerojorge.javadocker.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductAPI {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(productService.findAll());
	}

	@PostMapping
	public ResponseEntity create(@Valid @RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product> stock = productService.findById(id);
		if (!stock.isPresent()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(stock.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
		if (!productService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(productService.save(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		if (!productService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		productService.deleteById(id);

		return ResponseEntity.ok().build();
	}
}