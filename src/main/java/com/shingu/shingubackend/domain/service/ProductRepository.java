package com.shingu.shingubackend.domain.service;

import com.shingu.shingubackend.domain.model.Product;

import java.util.List;

public interface ProductRepository {

  List<Product> findAll();

  List<String> findDistinctCategories();

  List<Product> findByCategory(String category);

  Product findById(Long id);

  void save(Product product);
}
