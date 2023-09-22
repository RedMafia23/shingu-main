package com.shingu.shingubackend.domain.model;

import lombok.Data;

@Data
public class Product {

  private int id;
  private String name;
  private String description;
  private String image;
  private String category;
  private int price;

  // public Product(String string, String string2, String string3, String string4,
  // int i) {
  // }

}
