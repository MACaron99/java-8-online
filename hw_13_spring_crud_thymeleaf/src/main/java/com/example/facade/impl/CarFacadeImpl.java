package com.example.facade.impl;

import com.example.dto.request.CarRequestDto;
import com.example.dto.request.PageRequestDto;
import com.example.dto.response.CarResponseDto;
import com.example.dto.response.PageResponseDto;
import com.example.entity.Car;
import com.example.facade.CarFacade;
import com.example.service.CarService;
import com.example.util.WebRequestUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CarFacadeImpl implements CarFacade {

    private final CarService carService;

    @Override
    public void create(CarRequestDto carRequestDto) {
        Car car = new Car();
        car.setCarBrand(carRequestDto.getCarBrand());
        car.setCarModel(carRequestDto.getCarModel());
        car.setCarYear(carRequestDto.getCarYear());
        carService.create(car);
    }

    @Override
    public void update(CarRequestDto carRequestDto, Long id) {
        Car car = carService.findById(id);
        car.setCarBrand(carRequestDto.getCarBrand());
        car.setCarModel(carRequestDto.getCarModel());
        car.setCarYear(carRequestDto.getCarYear());
        carService.update(car);
    }

    @Override
    public void delete(Long id) {
        carService.delete(id);
    }

    @Override
    public CarResponseDto findById(Long id) {
        return new CarResponseDto(carService.findById(id));
    }

    @Override
    public PageResponseDto<CarResponseDto> findAll(WebRequest webRequest, Map<String, Object> paramMap) {
        PageResponseDto<CarResponseDto> pageResponseDto = new PageResponseDto<>();
        PageRequestDto pageRequestDto = WebRequestUtil.generatePageRequestDto(webRequest);
        pageRequestDto.setParamMap(paramMap);
        Page<Car> page = carService.findAll(pageRequestDto);
        pageResponseDto.setCurrentPage(pageRequestDto.getPage());
        pageResponseDto.setPageSize(page.getSize());
        pageResponseDto.setTotalPages(page.getTotalPages());
        pageResponseDto.setTotalElements(page.getTotalElements());
        pageResponseDto.setHasNext(page.hasNext());
        pageResponseDto.setFirst(page.isFirst());
        pageResponseDto.setLast(page.isLast());
        pageResponseDto.setHasPrevious(page.hasPrevious());
        pageResponseDto.setSortBy(pageRequestDto.getSortBy());
        pageResponseDto.setSortType(pageRequestDto.getSortType());
        Collection<CarResponseDto> items = Collections.emptyList();
        List<Car> cars = page.getContent();
        if (CollectionUtils.isNotEmpty(cars)) {
            items = cars.stream().map(CarResponseDto::new).toList();
        }
        pageResponseDto.setItems(items);
        return pageResponseDto;
    }
}
