package com.example.dto.response;

import com.example.entity.Car;
import com.example.entity.Park;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CarResponseDto extends BaseResponseDto {

    private String carBrand;
    private String carModel;
    private Integer carYear;
    private List<ParkInfo> parkInfoList;

    public CarResponseDto(Car car) {
        setId(car.getId());
        setCarBrand(car.getCarBrand());
        setCarModel(car.getCarModel());
        setCarYear(car.getCarYear());
        Set<Park> parks = car.getParks();
        if (CollectionUtils.isNotEmpty(parks)) {
            setParkInfoList(parks.stream().map(ParkInfo::new).toList());
        }
    }

    @Getter
    @Setter
    private static class ParkInfo {
        private Long parkId;
        private String parkName;

        ParkInfo(Park park) {
            setParkId(park.getId());
            setParkName(park.getName());
        }
    }
}
