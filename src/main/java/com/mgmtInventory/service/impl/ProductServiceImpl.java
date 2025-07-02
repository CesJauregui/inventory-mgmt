package com.mgmtInventory.service.impl;

import com.mgmtInventory.model.Product;
import com.mgmtInventory.repository.ProductRepository;
import com.mgmtInventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .price(product.getPrice())
                .stock(product.getStock())
                .category(product.getCategory())
                .image(product.getImage())
                .build();

        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));

        Product updated = existing.toBuilder()
                .name(product.getName())
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
}
