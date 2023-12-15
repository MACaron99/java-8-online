package com.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequestDto extends BaseRequestDto {

    private String carBrand;
    private String carModel;
    private Integer carYear;
}
