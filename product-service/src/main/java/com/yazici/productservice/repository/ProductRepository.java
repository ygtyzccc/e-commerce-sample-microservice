package com.yazici.productservice.repository;

import com.yazici.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, String> {

}
