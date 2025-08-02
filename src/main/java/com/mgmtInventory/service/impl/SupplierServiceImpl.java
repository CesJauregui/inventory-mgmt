package com.mgmtInventory.service.impl;

import com.mgmtInventory.model.Supplier;
import com.mgmtInventory.repository.SupplierRepository;
import com.mgmtInventory.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        Supplier newSupplier = Supplier.builder()
                .name(supplier.getName())
                .RUC(supplier.getRUC())
                .contact(supplier.getContact())
                .phone(supplier.getPhone())
                .email(supplier.getEmail())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .country(supplier.getCountry())
                .paymentTerms(supplier.getPaymentTerms())
                .note(supplier.getNote())
                .active(true)
                .build();

        return supplierRepository.save(newSupplier);
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existing = supplierRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Supplier not found."));

        Supplier updated = existing.toBuilder()
                .name(supplier.getName())
                .RUC(supplier.getRUC())
                .contact(supplier.getContact())
                .phone(supplier.getPhone())
                .email(supplier.getEmail())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .country(supplier.getCountry())
                .paymentTerms(supplier.getPaymentTerms())
                .note(supplier.getNote())
                .active(supplier.getActive())
                .build();

        return supplierRepository.save(updated);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.findById(id)
                .ifPresent(supplier -> supplierRepository.deleteById(id));
    }
}
