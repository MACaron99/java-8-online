package com.example.facade;

import com.example.dto.request.BaseRequestDto;
import com.example.dto.response.BaseResponseDto;

public interface BaseFacade<REQUEST extends BaseRequestDto, RESPONSE extends BaseResponseDto> {

    void create(REQUEST request);
    void update(REQUEST request, Long id);
    void delete(Long id);
    RESPONSE findById(Long id);
}
