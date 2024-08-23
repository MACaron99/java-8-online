package org.example.controller;

import jakarta.servlet.ServletException;
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
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class CarParkAddController extends HttpServlet {

    private final CarService carService = new CarServiceImpl();
    private final ParkService parkService = new ParkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang='en'>");
            printWriter.write("<head>");
            printWriter.write("<meta charset='UTF-8'>");
            printWriter.write("</head>");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Choose the car");
            printWriter.write("</h1>");
            printWriter.write("<form method='post' action='/hw_12_servlet_crud/car-park-add'>");

            Optional<Park> optionalPark = parkService.findById(Long.parseLong(req.getParameter("parkId")));

            if (optionalPark.isPresent()) {
                Park park = optionalPark.get();

                Collection<Car> cars = carService.findAll();

                if (CollectionUtils.isNotEmpty(cars)) {
                    printWriter.write("<label for='id'>Choose the car:</label>");
                    printWriter.write("<select id='id' name='carId'>");

                    Set<Car> cars1 = park.getCars();

                    if (CollectionUtils.isNotEmpty(cars1)) {
                        for (Car car : cars) {
                            boolean contains = false;

                            for (Car car1 : cars1) {
                                if (Objects.equals(car.getId(), car1.getId())) {
                                    contains = true;
                                    break;
                                }
                            }
                            if (!contains) {
                                printWriter.write("<option value='" + car.getId() + "'>" + car.getCarBrand() + " "
                                        + car.getCarModel() + " " + car.getCarYear() + "</option>");
                            }
                        }
                    } else {
                        for (Car car : cars) {
                            printWriter.write("<option value='" + car.getId() + "'>" + car.getCarBrand() + " "
                                    + car.getCarModel() + " " + car.getCarYear() + "</option>");

                        }
                    }
                    printWriter.write("</select><br><br>");
                }
                printWriter.write("<input type='hidden' id='id' name='parkId' value='" + park.getId() + "'/>");
            }
            printWriter.write("<input type='submit' value='Add'/>");
            printWriter.write("</form");
            printWriter.write("</body>");
            printWriter.write("</html>");
        } catch (Exception e) {
            System.out.println("e" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setStatus(201);

        Optional<Park> optionalPark = parkService.findById(Long.parseLong(req.getParameter("parkId")));

        if (optionalPark.isPresent()) {
            Park park = optionalPark.get();

            Optional<Car> optionalCar = carService.findById(Long.parseLong(req.getParameter("carId")));

            if (optionalCar.isPresent()) {
                Car car = optionalCar.get();
                park.getCars().add(car);

                parkService.update(park);
            }
        }
        resp.sendRedirect("park-cars?parkId=" + req.getParameter("parkId"));
    }
}
