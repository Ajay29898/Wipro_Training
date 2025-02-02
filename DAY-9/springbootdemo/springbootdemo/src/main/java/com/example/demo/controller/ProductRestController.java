package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.product.Product;

@RestController
@RequestMapping("/myproduct")
public class ProductRestController {

    // POST method to save a product
    @PostMapping("/product")
    public String saveProduct(@RequestBody Product p) {
        System.out.println(p);
        return "Product is saved";
    }

    // GET method to fetch a specific product by its ID
    @GetMapping("/product/{pid}")
    public Product getProduct(@PathVariable Integer pid) {
        Product p = null;
        if (pid == 100) {
            p = new Product(100, "Cable", "300", "High-quality cable", "Electronics");
        } else if (pid == 101) {
            p = new Product(101, "Mouse", "500", "Wireless Mouse", "Accessories");
        }
        return p;
    }

    // GET method to fetch all products
    @GetMapping("/products")
    public List<Product> getProducts() {
        Product p1 = new Product(100, "Cable", "300", "High-quality cable", "Electronics");
        Product p2 = new Product(101, "Mouse", "500", "Wireless Mouse", "Accessories");
        List<Product> products = Arrays.asList(p1, p2);
        return products;
    }
}
