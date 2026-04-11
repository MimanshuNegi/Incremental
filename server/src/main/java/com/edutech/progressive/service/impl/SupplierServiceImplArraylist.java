package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

public class SupplierServiceImplArraylist implements SupplierService{
    private final List<Supplier> suppliers = new ArrayList<>();

    @Override
    public List<Supplier> getAllSuppliers() {
        return new ArrayList<>(suppliers);
    }

    @Override
    public int addSupplier(Supplier supplier) {
        suppliers.add(supplier);
        return 1;
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> sortedList = new ArrayList<>(suppliers);
        sortedList.sort(Comparator.comparing(Supplier::getSupplierName));
        return sortedList;
    }

    @Override
    public void emptyArrayList() {
        suppliers.clear();
    }

    
}