package com.mgmtInventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBrandDTO {
    private Long id;
    private String name;
    private Long total;
}
