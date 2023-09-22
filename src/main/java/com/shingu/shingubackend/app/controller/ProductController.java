package com.shingu.shingubackend.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shingu.shingubackend.app.service.ProductService;
import com.shingu.shingubackend.domain.model.Product;

@RestController
@CrossOrigin
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  public List<Product> findAll() {
    return productService.findAll();
  }
  // @GetMapping("/products")
  // public ResponseEntity<List<Product>> findAll(@RequestParam("page") int page,
  // @RequestParam(name = "size", defaultValue = "5") int size) {
  // // サービスからすべての商品を取得します
  // List<Product> allProducts = productService.findAll(null);

  // // 現在のページのための開始と終了インデックスを計算します
  // int startIndex = (page - 1) * size;
  // int endIndex = Math.min(startIndex + size, allProducts.size());

  // // 現在のページの商品を取得するためにリストをスライスします
  // List<Product> productsForPage = allProducts.subList(startIndex, endIndex);

  // // ページ化されたリストを返します
  // return ResponseEntity.ok(productsForPage);
  // }

  // // カテゴリーで商品を検索するAPI
  // @GetMapping("/products/{category}")
  // public ResponseEntity<List<Product>> findProductsByCategory(@PathVariable
  // String category) {
  // // カテゴリーを指定してProductServiceから商品リストを取得します
  // List<Product> products = productService.getProductsByCategory(category);

  // // 商品リストが空でない場合、200（OK）ステータスとともに商品リストを返します
  // if (!products.isEmpty()) {
  // return ResponseEntity.ok(products);
  // } else {
  // // 商品が見つからない場合、404（Not Found）ステータスを返します
  // return ResponseEntity.notFound().build();
  // }
  // }

  // // 指定したIDで商品を取得するAPI
  // @GetMapping("/products/{id}")
  // public ResponseEntity<Product> getProductById(@PathVariable Long id) {
  // // IDを使ってProductServiceから商品を取得します
  // Product product = productService.getProductById(id);

  // // 商品が存在する場合、200（OK）ステータスとともに商品情報を返します
  // if (product != null) {
  // return ResponseEntity.ok(product);
  // } else {
  // // 商品が見つからない場合、404（Not Found）ステータスを返します
  // return ResponseEntity.notFound().build();
  // }
  // }
}