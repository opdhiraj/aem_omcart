package com.omcart.core.apractice;

import java.util.ArrayList;
import java.util.List;

public class ProductService {


    List<Product> products=new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);

    }


    public List<Product> getAllProducts(){
        return products;
    }
}
