package com.example.facade;

import com.example.dto.request.CarRequestDto;
import com.example.dto.response.CarResponseDto;

public interface CarFacade extends
        BaseFacade<CarRequestDto, CarResponseDto>,
        DataTableFacade<CarResponseDto> { }
