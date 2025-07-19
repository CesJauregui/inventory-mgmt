package com.mgmtInventory.service.impl;

import com.mgmtInventory.dto.ResponseBrandDTO;
import com.mgmtInventory.model.Brand;
import com.mgmtInventory.repository.BrandRepository;
import com.mgmtInventory.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<ResponseBrandDTO> getAll() {
        return brandRepository.getTotalBrandByProducts();
    }

    @Override
    public Brand createBrand(Brand brand) {
        Brand created = Brand.builder()
                .name(brand.getName())
                .build();

        return brandRepository.save(created);
    }

    @Override
    public Brand updateBrand(Long id, Brand brand) {
        Brand existing = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found."));

        Brand updated = existing.toBuilder()
                .name(brand.getName())
                .build();

        return brandRepository.save(updated);
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.findById(id).
                ifPresent(brand -> brandRepository.deleteById(id));
    }
}
