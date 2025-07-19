package com.mgmtInventory.service;

import com.mgmtInventory.dto.ResponseBrandDTO;
import com.mgmtInventory.model.Brand;

import java.util.List;

public interface BrandService {
    /**
     * Obtiene la lista completa de las marcas registradas.
     * @return Lista de marcas.
     */
    List<ResponseBrandDTO> getAll();

    /**
     * Crea una nueva marca.
     * @param brand Objeto marca a guardar.
     * @return La marca guardada con el ID generado.
     */
    Brand createBrand(Brand brand);

    /**
     * Actualiza una marca registrada.
     * @param id ID de la marca a actualizar.
     * @param brand Datos nuevos.
     * @return La marca actualizada.
     */
    Brand updateBrand(Long id, Brand brand);

    /**
     * Elimina una marca por su ID.
     * @param id ID de la marca a eliminar.
     */
    void deleteBrand(Long id);
}
