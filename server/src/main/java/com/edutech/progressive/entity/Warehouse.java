package com.edutech.progressive.entity;

public class Warehouse implements Comparable<Warehouse>{
    private int warehouseld;
    private int supplierld;
    private String warehouseName;
    private String location;
    private int capacity;

    // Default Constructor
    public Warehouse() {
    }

    // Parameterized Constructor
    public Warehouse(int warehouseld, int supplierld, String warehouseName, String location, int capacity) {
        this.warehouseld = warehouseld;
        this.supplierld = supplierld;
        this.warehouseName = warehouseName;
        this.location = location;
        this.capacity = capacity;
    }

    // Getters and setters
    public int getWarehouseld() {
        return warehouseld;
    }

    public void setWarehouseld(int warehouseld) {
        this.warehouseld = warehouseld;
    }

    public int getSupplierld() {
        return supplierld;
    }

    public void setSupplierld(int supplierld) {
        this.supplierld = supplierld;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Warehouse o) {
        // TODO Auto-generated method stub
        return Integer.compare(o.getCapacity(), this.getCapacity());
    }

}