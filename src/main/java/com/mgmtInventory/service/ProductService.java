package com.mgmtInventory.service;

import com.mgmtInventory.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    /**
     * Obtiene la lista completa de productos registrados.
     * @return Lista de productos.
     */
    List<Product> getAll();

    /**
     * Busca un producto por su ID único.
     * @param id ID del producto a buscar.
     * @return El producto encontrado.
     */
    Optional<Product> getProductById(Long id);

    /**
     * Crea un nuevo producto.
     * @param product Objeto producto a guardar.
     * @return El producto guardado con ID generado.
     */
    Product createProduct(Product product);

    /**
     * Actualiza un producto existente.
     * @param id ID del producto a actualizar.
     * @param product Datos nuevos.
     * @return El producto actualizado.
     */
    Product updateProduct(Long id, Product product);

    /**
     * Elimina un producto por su ID.
     * @param id ID del producto a eliminar.
     */
    void deleteProduct(Long id);

    /**
     * Genera el código SKU al crear un producto
     * @param name
     * @param category
     * @param brand
     * @param id
     * @return El código SKU único por producto
     */
    String generateCodeSKU(String name, String category, String brand, Long id);

}
