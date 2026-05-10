package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.service.SupplierService;

@Service
public class SupplierServiceImplJpa implements SupplierService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public int addSupplier(Supplier supplier) {

        if (supplierRepository.findByUsername(supplier.getUsername()) != null) {
            throw new SupplierAlreadyExistsException("Username already exists");
        }

        if (supplierRepository.findByEmail(supplier.getEmail()) != null) {
            throw new SupplierAlreadyExistsException("Email already exists");
        }

        Supplier saved = supplierRepository.save(supplier);
        return saved.getSupplierId();
    }

    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> list = supplierRepository.findAll();
        Collections.sort(list);
        return list;
    }

    public void updateSupplier(int supplierId, Supplier supplier) {

        Supplier existing = supplierRepository.findBySupplierId(supplierId);

        if (existing == null) {
            throw new SupplierDoesNotExistException("Supplier not found");
        }

        Supplier userByUsername = supplierRepository.findByUsername(supplier.getUsername());
        if (userByUsername != null && userByUsername.getSupplierId() != supplierId) {
            throw new SupplierAlreadyExistsException("Username already exists");
        }

        Supplier userByEmail = supplierRepository.findByEmail(supplier.getEmail());
        if (userByEmail != null && userByEmail.getSupplierId() != supplierId) {
            throw new SupplierAlreadyExistsException("Email already exists");
        }

        existing.setSupplierName(supplier.getSupplierName());
        existing.setEmail(supplier.getEmail());
        existing.setPhone(supplier.getPhone());
        existing.setAddress(supplier.getAddress());
        existing.setUsername(supplier.getUsername());
        existing.setRole(supplier.getRole());

        if (supplier.getPassword() != null && !supplier.getPassword().isEmpty()) {

            if (!supplier.getPassword().startsWith("$2a")) {
                existing.setPassword(passwordEncoder.encode(supplier.getPassword()));
            }
        }
        supplierRepository.save(existing);

    }

    public void deleteSupplier(int supplierId) {
        if (!supplierRepository.existsById(supplierId)) {
            throw new SupplierDoesNotExistException("Supplier not found");
        }
        supplierRepository.deleteById(supplierId);
    }

    public Supplier getSupplierById(int supplierId) {
        if (!supplierRepository.existsById(supplierId)) {
            throw new SupplierDoesNotExistException("Supplier not found");
        }
        return supplierRepository.findBySupplierId(supplierId);
    }
}