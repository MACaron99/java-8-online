package com.example.util;

import com.example.dto.request.PageRequestDto;
import org.springframework.web.context.request.WebRequest;

public final class WebRequestUtil {

    private static final String PAGE_PARAM = "currentPage";
    private static final String PAGE_SIZE_PARAM = "pageSize";
    private static final String SORT_BY_PARAM = "sortBy";
    private static final String SORT_TYPE_PARAM = "sortType";

    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final String DEFAULT_SORT_BY = "id";
    private static final String DEFAULT_SORT_TYPE = "asc";

    private WebRequestUtil() { }

    public static PageRequestDto generatePageRequestDto(WebRequest webRequest) {
        PageRequestDto dto = new PageRequestDto();
        String pageParameter = webRequest.getParameter(PAGE_PARAM);
        int page = pageParameter == null ? DEFAULT_PAGE : Integer.parseInt(pageParameter);
        String pageSizeParameter = webRequest.getParameter(PAGE_SIZE_PARAM);
        int size = pageSizeParameter == null ? DEFAULT_PAGE_SIZE : Integer.parseInt(pageSizeParameter);
        String sortByParameter = webRequest.getParameter(SORT_BY_PARAM);
        String sortBy = sortByParameter == null ? DEFAULT_SORT_BY : sortByParameter;
        String sortTypeParameter = webRequest.getParameter(SORT_TYPE_PARAM);
        String sortType = sortByParameter == null ? DEFAULT_SORT_TYPE : sortTypeParameter;
        dto.setPage(page);
        dto.setSize(size);
        dto.setSortBy(sortBy);
        dto.setSortType(sortType);
        return dto;
    }
}
