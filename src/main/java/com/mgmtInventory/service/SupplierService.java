package com.mgmtInventory.service;

import com.mgmtInventory.model.Supplier;

import java.util.List;

public interface SupplierService {
    /**
     * Obtiene la lista completa de proveedores registrados.
     *
     * @return Lista de proveedores.
     */
    List<Supplier> getAll();

    /**
     * Crea un nuevo proveedor.
     *
     * @param supplier Objeto proveedor a guardar.
     * @return El proveedor guardado con ID generado.
     */
    Supplier createSupplier(Supplier supplier);

    /**
     * Actualiza un proveedor existente.
     *
     * @param id       ID del proveedor a actualizar.
     * @param supplier Datos nuevos.
     * @return El proveedor actualizado.
     */
    Supplier updateSupplier(Long id, Supplier supplier);

    /**
     * Elimina un proveedor por su ID.
     *
     * @param id ID del proveedor a eliminar.
     */
    void deleteSupplier(Long id);
}
