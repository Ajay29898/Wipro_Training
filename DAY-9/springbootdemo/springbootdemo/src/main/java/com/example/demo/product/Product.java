package com.example.demo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product 
{
	private Integer id;
    private String name;
    private String price;
    private String description;
    private String category;
    
    public Product(Integer id, String name, String price, String description, String category) 
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    
    @Override
    public String toString() 
    {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", category=" + category + "]";
    }
}

