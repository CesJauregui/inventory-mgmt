package com.mgmtInventory.service.impl;

import com.mgmtInventory.model.Category;
import com.mgmtInventory.repository.CategoryRepository;
import com.mgmtInventory.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(Category category) {
        Category newCategory = Category.builder()
                .name(category.getName())
                .build();

        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found."));

        Category updated = existing.toBuilder()
                .name(category.getName())
                .build();

        return categoryRepository.save(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.findById(id)
                .ifPresent(category -> categoryRepository.deleteById(id));
    }
}
