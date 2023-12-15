package com.example.service.impl;

import com.example.dto.request.PageRequestDto;
import com.example.entity.Park;
import com.example.repository.ParkRepository;
import com.example.service.ParkService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ParkServiceImpl implements ParkService {

    private final ParkRepository parkRepository;

    @Override
    public void create(Park park) {
        parkRepository.save(park);
    }

    @Override
    public void update(Park park) {
        parkRepository.save(park);
    }

    @Override
    public void delete(Long id) {
        parkRepository.deleteById(id);
    }

    @Override
    public Park findById(Long id) {
        return parkRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Park> findAll(PageRequestDto pageRequestDto) {
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
        return parkRepository.findAll(pageRequest);
    }
}
