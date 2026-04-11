package com.edutech.progressive.entity;

public class Product {
    private int productld;
    private int warehouseld;
    private String productName;
    private String productDescription;
    private int quantity;
    private Long price;
    //Default Constructor
    public Product() {}
    //Parameterized Constructor
    public Product(int productld, int warehouseld, String productName, String productDescription, int quantity,
            Long price) {
        this.productld = productld;
        this.warehouseld = warehouseld;
        this.productName = productName;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
    }
    //Getters and setters
    public int getProductld() {
        return productld;
    }
    public void setProductld(int productld) {
        this.productld = productld;
    }
    public int getWarehouseld() {
        return warehouseld;
    }
    public void setWarehouseld(int warehouseld) {
        this.warehouseld = warehouseld;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    
}