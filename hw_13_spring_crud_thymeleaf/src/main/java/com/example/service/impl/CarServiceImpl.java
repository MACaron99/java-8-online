package com.example.service.impl;

import com.example.dto.request.PageRequestDto;
import com.example.entity.Car;
import com.example.entity.Park;
import com.example.repository.CarRepository;
import com.example.service.CarService;
import jakarta.persistence.criteria.Join;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

@Service
@Transactional
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public void create(Car car) {
        carRepository.save(car);
    }

    @Override
    public void update(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Car> findAll(PageRequestDto pageRequestDto) {
        Specification<Car> specification = null;
        Map<String, Object> map = pageRequestDto.getParamMap();
        if (MapUtils.isNotEmpty(map)) {
            Long parkId = (Long) map.get("parkId");
            specification = (root, query, cb) -> {
                Join<Park, Car> parkCarJoin = root.join("parks");
                return cb.equal(parkCarJoin.get("id"), parkId);
            };
        }
        PageRequest pageRequest;
        if (pageRequestDto.getSortType().equals("desc")) {
            pageRequest = PageRequest.of(
                    pageRequestDto.getPage() - 1,
                    pageRequestDto.getSize(),
                    Sort.by(pageRequestDto.getSortBy()).descending());
        } else {
            pageRequest = PageRequest.of(
                    pageRequestDto.getPage() - 1,
                    pageRequestDto.getSize(),
                    Sort.by(pageRequestDto.getSortBy()).ascending());
        }
        if (specification != null) {
            return carRepository.findAll(specification, pageRequest);
        }
        return carRepository.findAll(pageRequest);
    }

    @Override
    public Collection<Car> findAll() {
        return carRepository.findAll();
    }
}
