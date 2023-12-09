package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.Car;
import org.example.entity.Park;
import org.example.service.ParkService;
import org.example.service.impl.ParkServiceImpl;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

public class CarParkDeleteController extends HttpServlet {

    private final ParkService parkService = new ParkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Park> optionalPark = parkService.findById(Long.valueOf(req.getParameter("parkId")));
        if (optionalPark.isPresent()) {
            System.out.println(req.getParameter("carId") + " " + req.getParameter("parkId"));
            Park park = optionalPark.get();
            Set<Car> cars = park.getCars();
            cars.removeIf(car -> car.getId().equals(Long.parseLong(req.getParameter("carId"))));
            parkService.update(park);
        }
        resp.sendRedirect("park-cars?parkId=" + req.getParameter("parkId"));
    }
}