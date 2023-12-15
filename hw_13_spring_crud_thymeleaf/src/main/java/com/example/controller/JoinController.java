package com.example.controller;

import com.example.entity.Car;
import com.example.facade.JoinFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/join")
public class JoinController {

    JoinFacade joinFacade;

    @GetMapping("/add/{id}")
    public String redirectToAddCar(@PathVariable Long id, Model model) {
        List<Car> availableCars = joinFacade.findAvailableCars(id);
        model.addAttribute("parkId", id);
        model.addAttribute("availableCars", availableCars);
        return "/pages/join/join_add";
    }

    @PostMapping("/add/{id}")
    public String addCarToPark(@RequestParam Long carId, @PathVariable Long id) {
        joinFacade.add(id, carId);
        return "redirect:/cars?parkId=" + id;
    }

    @GetMapping("/remove")
    public String removeCarFromPark(@RequestParam("parkId") Long parkId, @RequestParam("carId") Long carId) {
        joinFacade.remove(parkId, carId);
        return "redirect:/cars?parkId=" + parkId;
    }
}
