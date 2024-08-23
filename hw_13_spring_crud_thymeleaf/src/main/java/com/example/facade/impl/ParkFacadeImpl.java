package com.example.facade.impl;

import com.example.dto.request.PageRequestDto;
import com.example.dto.request.ParkRequestDto;
import com.example.dto.response.PageResponseDto;
import com.example.dto.response.ParkResponseDto;
import com.example.entity.Park;
import com.example.facade.ParkFacade;
import com.example.service.ParkService;
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
public class ParkFacadeImpl implements ParkFacade {

    ParkService parkService;

    @Override
    public void create(ParkRequestDto parkRequestDto) {
        Park park = new Park();

        park.setName(parkRequestDto.getParkName());

        parkService.create(park);
    }

    @Override
    public void update(ParkRequestDto parkRequestDto, Long id) {
        Park park = parkService.findById(id);

        park.setName(parkRequestDto.getParkName());

        parkService.update(park);
    }

    @Override
    public void delete(Long id) {
        parkService.delete(id);
    }

    @Override
    public ParkResponseDto findById(Long id) {
        return new ParkResponseDto(parkService.findById(id));
    }

    @Override
    public PageResponseDto<ParkResponseDto> findAll(WebRequest webRequest, Map<String, Object> paramMap) {
        PageResponseDto<ParkResponseDto> pageResponseDto = new PageResponseDto<>();
        PageRequestDto pageRequestDto = WebRequestUtil.generatePageRequestDto(webRequest);

        Page<Park> page = parkService.findAll(pageRequestDto);

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

        Collection<ParkResponseDto> items = Collections.emptyList();

        List<Park> parks = page.getContent();

        if (CollectionUtils.isNotEmpty(parks)) {
            items = parks.stream().map(ParkResponseDto::new).toList();
        }

        pageResponseDto.setItems(items);

        return pageResponseDto;
    }
}
