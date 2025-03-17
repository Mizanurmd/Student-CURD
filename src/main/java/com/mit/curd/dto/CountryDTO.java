package com.mit.curd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    private long cId;
    private String cCode;
    private String country_name;
    private String currency_name;
    private String language;
    private String nationality;


}
