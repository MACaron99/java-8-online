package com.example.facade;

import com.example.dto.request.ParkRequestDto;
import com.example.dto.response.ParkResponseDto;

public interface ParkFacade extends
        BaseFacade<ParkRequestDto, ParkResponseDto>,
        DataTableFacade<ParkResponseDto> { }
