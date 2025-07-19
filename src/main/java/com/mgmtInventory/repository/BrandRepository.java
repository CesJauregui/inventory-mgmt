package com.mgmtInventory.repository;

import com.mgmtInventory.dto.ResponseBrandDTO;
import com.mgmtInventory.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT new com.mgmtInventory.dto.ResponseBrandDTO(b.id, b.name, COUNT(p)) " +
            "FROM Brand b LEFT JOIN Product p ON p.brand = b GROUP BY b.id, b.name")
    List<ResponseBrandDTO> getTotalBrandByProducts();
}
