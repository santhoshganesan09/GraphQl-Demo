package com.example.GraphQl.Controller;

import com.example.GraphQl.Entity.Product;
import com.example.GraphQl.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @QueryMapping
    public List<Product> getProduct() {
        return productService.getProducts();
    }

    @QueryMapping
    public List<Product> getProductByCategory(@Argument String category){
        return productService.getProductByCategory(category);
    }

    @QueryMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock){
        return productService.updateStock(id,stock);
    }

    @MutationMapping
    public Product receiveNewShipment(@Argument int id, @Argument int quantity){
        return productService.receiveNewShipment(id,quantity);
    }

    @MutationMapping
    public Product createProduct(@Argument String name,
                                 @Argument String category,
                                 @Argument Float price,
                                 @Argument Integer stock){
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setStock(stock);

        return productService.createProduct(product);
    }

}

