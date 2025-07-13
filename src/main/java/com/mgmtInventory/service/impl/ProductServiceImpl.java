package com.mgmtInventory.service.impl;

import com.mgmtInventory.model.Product;
import com.mgmtInventory.repository.ProductRepository;
import com.mgmtInventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.hibernate.id.IncrementGenerator;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        Product newProduct = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .category(product.getCategory())
                .brand(product.getBrand())
                .image(product.getImage())
                .build();

        Product saved = productRepository.save(newProduct);

        saved.setCodeSKU(generateCodeSKU(saved.getName(), saved.getCategory(),saved.getBrand(), saved.getId()));

        return productRepository.save(saved);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));

        Product updated = existing.toBuilder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .category(product.getCategory())
                .image(product.getImage())
                .build();

        return productRepository.save(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.findById(id).
                ifPresent(product -> productRepository.deleteById(id));
    }

    @Override
    public String generateCodeSKU(String name, String category, String brand, Long id) {
        String nameCode = getAbbreviation(name,3);
        String categoryCode = getAbbreviation(category, 3);
        String brandCode = getAbbreviation(brand, 3);
        String idCode = String.format("%06d", id);

        return nameCode + "-" + categoryCode + "-" + brandCode + "-" + idCode;
    }

    private String getAbbreviation(String value, int length) {
        return value.toUpperCase().replaceAll("[^A-Z0-9]", "").substring(0, Math.min(value.length(), length));
    }
}
