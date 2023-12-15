package com.example.controller;

import com.example.dto.request.ParkRequestDto;
import com.example.dto.response.PageResponseDto;
import com.example.dto.response.ParkResponseDto;
import com.example.facade.CarFacade;
import com.example.facade.ParkFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/parks")
@AllArgsConstructor
public class ParkController {

    CarFacade carFacade;
    ParkFacade parkFacade;

    @GetMapping
    public String findAll(Model model, WebRequest request) {
        PageResponseDto<ParkResponseDto> page = parkFacade.findAll(request, new HashMap<>());
        model.addAttribute("pageData", page);
        return "/pages/parks/park_all";
    }

    @PostMapping
    public ModelAndView searchParks(WebRequest request, ModelMap modelMap) {
        Map<String, String[]> map = request.getParameterMap();
        map.forEach(modelMap::addAttribute);
        return new ModelAndView("redirect:/parks", modelMap);
    }

    @GetMapping("/new")
    public String redirectToNewPark(Model model) {
        model.addAttribute("park", new ParkRequestDto());
        return "pages/parks/park_new";
    }

    @PostMapping("/new")
    public String newPark(@ModelAttribute ParkRequestDto park) {
        parkFacade.create(park);
        return "redirect:/parks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        parkFacade.delete(id);
        return "redirect:/parks";
    }

    @GetMapping("/update/{id}")
    public String redirectToUpdatePark(@PathVariable Long id, Model model) {
        ParkResponseDto park = parkFacade.findById(id);
        model.addAttribute("park", park);
        return "/pages/parks/park_update";
    }

    @PostMapping("update/{id}")
    public String updatePark(@PathVariable Long id, @ModelAttribute ParkRequestDto park) {
        parkFacade.update(park, id);
        return "redirect:/parks";
    }
}
