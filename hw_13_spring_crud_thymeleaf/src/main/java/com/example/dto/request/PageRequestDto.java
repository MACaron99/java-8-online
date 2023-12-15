package com.example.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class PageRequestDto {

    private int page;
    private int size;
    private String sortBy;
    private String sortType;
    private Map<String, Object> paramMap;
}
