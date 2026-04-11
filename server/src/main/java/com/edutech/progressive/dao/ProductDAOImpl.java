package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Product;

public class ProductDAOImpl implements ProductDAO{

    @Override
    public int addProduct(Product product) {
        return -1;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        
    }

    @Override
    public void deleteProduct(int productId) {
        
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

}
