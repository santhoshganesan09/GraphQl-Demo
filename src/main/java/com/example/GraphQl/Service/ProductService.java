package com.example.GraphQl.Service;

import com.example.GraphQl.Entity.Product;
import com.example.GraphQl.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;


    public List<Product> getProducts() {
        return productRepo.findAll();
    }


    public List<Product> getProductByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }


    public Product updateStock(int id, int stock) {
        Product existingProduct=productRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found with id"+ id));
        existingProduct.setStock(stock);
        return productRepo.save(existingProduct);
    }

    public Product receiveNewShipment(int id, int quantity) {
        Product existingProduct=productRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found with id"+id));
        existingProduct.setStock(existingProduct.getStock()+quantity);
        return productRepo.save(existingProduct);
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
}
