package com.shingu.shingubackend.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shingu.shingubackend.domain.model.Product;
import java.util.List;

import com.shingu.shingubackend.domain.service.ProductRepository;

@Service
@CrossOrigin
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

}

// // 商品を保存するメソッド
// public void saveProduct(Product product) {
// productRepository.save(product);
// }

// // 一意の商品カテゴリを取得するメソッド
// public List<String> getDistinctCategories() {
// return productRepository.findDistinctCategories();
// }

// // カテゴリに基づいて商品を取得するメソッド
// public List<Product> getProductsByCategory(String category) {
// return productRepository.findByCategory(category);
// }

// // IDに基づいて商品を取得するメソッド
// public Product getProductById(Long id) {
// return productRepository.findById(id);
// }
