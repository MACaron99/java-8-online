package com.example.controller;

import com.example.dto.request.CarRequestDto;
import com.example.dto.response.CarResponseDto;
import com.example.dto.response.PageResponseDto;
import com.example.facade.CarFacade;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/cars")
public class CarController {

    private final CarFacade carFacade;

    @GetMapping
    public String allCars(Model model, WebRequest request) {
        Map<String, Object> map = new HashMap<>();
        String parkIdParameter = request.getParameter("parkId");
        if (StringUtils.isNotBlank(parkIdParameter)) {
            Long parkId = Long.parseLong(parkIdParameter);
            map.put("parkId", parkId);
            model.addAttribute("parkId", parkId);
        }
        PageResponseDto<CarResponseDto> page = carFacade.findAll(request, map);
        model.addAttribute("pageData", page);
        return "pages/cars/car_all";
    }

    @PostMapping
    public ModelAndView searchCars(WebRequest request, ModelMap modelMap) {
        Map<String, String[]> map = request.getParameterMap();
        map.forEach(modelMap::addAttribute);
        return new ModelAndView("redirect:/cars", modelMap);
    }

    @GetMapping("/new")
    public String redirectToNewCar(Model model) {
        model.addAttribute("car", new CarRequestDto());
        return "pages/cars/car_new";
    }

    @PostMapping("/new")
    public String newCar(@ModelAttribute CarRequestDto car) {
        carFacade.create(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        carFacade.delete(id);
        return "redirect:/cars";
    }

    @GetMapping("/update/{id}")
    public String redirectToUpdateCar(@PathVariable Long id, Model model) {
        CarResponseDto car = carFacade.findById(id);
        model.addAttribute("car", car);
        return "pages/cars/car_update";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute CarRequestDto car) {
        carFacade.update(car, id);
        return "redirect:/cars";
    }
}
