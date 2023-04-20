package com.serverapp.metrodata.models.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String desc;
    private Integer price;
    private Integer qty;
    private Integer categoryId;
}
