package com.example.facade;

import com.example.dto.response.BaseResponseDto;
import com.example.dto.response.PageResponseDto;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public interface DataTableFacade<RESPONSE extends BaseResponseDto> {

    PageResponseDto<RESPONSE> findAll(WebRequest webRequest, Map<String, Object> paramMap);
}
