package com.mgmtInventory.controller;

import com.mgmtInventory.model.Supplier;
import com.mgmtInventory.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> getSuppliers() {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.getAll());
    }

    @PostMapping
    public ResponseEntity<Supplier> postSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.createSupplier(supplier));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> putSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.updateSupplier(id, supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
