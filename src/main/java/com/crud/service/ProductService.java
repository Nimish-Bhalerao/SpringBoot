package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.crud.entity.Product;
import com.crud.repository.ProductRepo;

@Service
public class ProductService {
  @Autowired
  private ProductRepo repository;

  public Product saveProduct(Product product) {
    return repository.save(product);
  }

  public List<Product> saveProducts(List<Product> products) {
    return repository.saveAll(products);

  }

  public List<Product> getProducts() {
    return repository.findAll();
  }

  public Product getProductById(int id) {
    return repository.findById(id).orElse(null);
  }

  public Product geProductByName(String name) {
    return repository.findByName(name);
  }

  public String deleteById(int id) {
    repository.deleteById(id);
    return "DELETED SUCESSFULLY :" + id + " !! ";
  }

  public Product updateProduct(Product product) {
    Product existingProduct = repository.findById(product.getId()).orElse(null);
    existingProduct.setName(product.getName());
    existingProduct.setPrice(product.getPrice());
    existingProduct.setQuantity(product.getQuantity());
    return repository.save(existingProduct);
  }
}
