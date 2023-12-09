package org.example.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.example.entity.Car;
import org.example.entity.Park;
import org.example.service.CarService;
import org.example.service.ParkService;
import org.example.service.impl.CarServiceImpl;
import org.example.service.impl.ParkServiceImpl;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

public class CarDeleteController extends HttpServlet {

    CarService carService = new CarServiceImpl();
    ParkService parkService = new ParkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Car> optionalCar = carService.findById(Long.parseLong(req.getParameter("carId")));
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            Long id = car.getId();
            Set<Park> parks = car.getParks();
            if (CollectionUtils.isNotEmpty(parks)) {
                for (Park park : parks) {
                    Set<Car> cars1 = park.getCars();
                    if (CollectionUtils.isNotEmpty(cars1)) {
                        cars1.removeIf(car1 -> car1.getId().equals(id));
                        parkService.update(park);
                    }
                }
            }
            carService.delete(id);
        }
        resp.sendRedirect("cars");
    }
}