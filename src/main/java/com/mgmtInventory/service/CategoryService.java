package com.mgmtInventory.service;

import com.mgmtInventory.dto.ResponseCategoryDTO;
import com.mgmtInventory.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    /**
     * Obtiene la lista completa de categorías registradas.
     * @return Lista de categorías.
     */
    List<ResponseCategoryDTO> getAll();

    /**
     * Busca una categoría por su ID único.
     * @param id ID de la categoría a buscar.
     * @return La categoría encontrada.
     */
    Optional<Category> getCategoryById(Long id);

    /**
     * Crea una nueva categoría.
     * @param category Objeto categoría a guardar.
     * @return La categoría guardada con ID generado.
     */
    Category createCategory(Category category);

    /**
     * Actualiza una categoría existente.
     * @param id ID de la categoría a actualizar.
     * @param category Datos nuevos.
     * @return La categoría actualizada.
     */
    Category updateCategory(Long id, Category category);

    /**
     * Elimina una categoría por su ID.
     * @param id ID de la categoría a eliminar.
     */
    void deleteCategory(Long id);
}
