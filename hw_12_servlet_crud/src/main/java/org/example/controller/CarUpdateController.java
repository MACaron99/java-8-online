package org.example.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.MapUtils;
import org.example.entity.Car;
import org.example.service.CarService;
import org.example.service.impl.CarServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;

public class CarUpdateController extends HttpServlet {

    private final CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Car> optionalCar = carService.findById(Long.parseLong(req.getParameter("carId")));
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            resp.setStatus(200);
            try(PrintWriter printWriter = resp.getWriter()) {
                printWriter.write("<!DOCTYPE html>");
                printWriter.write("<html lang='en'>");
                printWriter.write("<body>");
                printWriter.write("<h1>");
                printWriter.write("Update car");
                printWriter.write("</h1>");
                printWriter.write("<form method='post' action='/hw_12_servlet_crud/cars-update'>");
                printWriter.write("<label for='brand'>Car brand:</label><br>");
                printWriter.write("<input type='text' id='brand' name='carBrand' value='" + car.getCarBrand() + "'/><br><br>");
                printWriter.write("<label for='model'>Car model:</label><br>");
                printWriter.write("<input type='text' id='model' name='carModel' value='" + car.getCarModel() + "'/><br><br>");
                printWriter.write("<label for='year'>Car year:</label><br>");
                printWriter.write("<input type='text' id='year' name='carYear' value='" + car.getCarYear() + "'/><br><br>");
                printWriter.write("<input type='hidden' id='id' name='carId' value='" + car.getId() + "'/>");
                printWriter.write("<input type='submit' value='Update'/>");
                printWriter.write("</form>");
                printWriter.write("</body>");
                printWriter.write("</html>");
            } catch (Exception e) {
                System.out.println("e = " + e.getMessage());
            }
        } else {
            resp.sendRedirect("cars");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            Car car = new Car();
            parameterMap.forEach((k, v) -> {
                switch (k) {
                    case "carId" -> car.setId(Long.parseLong(v[0]));
                    case "carBrand" -> car.setCarBrand(v[0]);
                    case "carModel" -> car.setCarModel(v[0]);
                    case "carYear" -> car.setCarYear(Integer.parseInt(v[0]));
                }
            });
            carService.update(car);
        }
        resp.sendRedirect("cars");
    }
}