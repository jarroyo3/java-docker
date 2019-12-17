package com.arroyotercerojorge.javadocker.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arroyotercerojorge.javadocker.model.Product;

public interface ProductRespository extends JpaRepository<Product, Long> {
}