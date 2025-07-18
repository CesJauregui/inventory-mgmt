package com.mgmtInventory.repository;

import com.mgmtInventory.dto.ResponseCategoryDTO;
import com.mgmtInventory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT new com.mgmtInventory.dto.ResponseCategoryDTO(c.id, c.name, COUNT(p)) " +
            "FROM Category c LEFT JOIN Product p ON p.category = c GROUP BY c.id, c.name")
    List<ResponseCategoryDTO> getTotalCategoryByProducts();
}
