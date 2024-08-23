package com.example.dto.response;

import com.example.entity.Car;
import com.example.entity.Park;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;

@Getter
@Setter
public class ParkResponseDto extends BaseResponseDto {

    private String parkName;
    private int countOfCars;

    public ParkResponseDto(Park park) {
        setId(park.getId());
        setParkName(park.getName());

        Set<Car> cars = park.getCars();

        if (CollectionUtils.isNotEmpty(cars)) {
            setCountOfCars(cars.size());
        }
    }

}
