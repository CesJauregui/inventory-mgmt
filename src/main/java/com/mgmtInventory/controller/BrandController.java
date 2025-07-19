package com.mgmtInventory.controller;

import com.mgmtInventory.dto.ResponseBrandDTO;
import com.mgmtInventory.model.Brand;
import com.mgmtInventory.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandController {
    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<ResponseBrandDTO>> getBrands() {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getAll());
    }

    @PostMapping
    public ResponseEntity<Brand> postBrand(@RequestBody Brand brand) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.createBrand(brand));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.updateBrand(id,brand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
 }
