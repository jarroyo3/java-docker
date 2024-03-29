package com.arroyotercerojorge.javadocker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arroyotercerojorge.javadocker.dto.ProductRespository;
import com.arroyotercerojorge.javadocker.model.Product;

@Service
public class ProductService {
	
	@Autowired
    private ProductRespository productRespository;

    public List<Product> findAll() {
        return productRespository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRespository.findById(id);
    }

    public Product save(Product stock) {
        return productRespository.save(stock);
    }

    public void deleteById(Long id) {
        productRespository.deleteById(id);
    }
}