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

public class CarCreateController extends HttpServlet {

    private final CarService carService = new CarServiceImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(200);
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang='en'>");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Create new car");
            printWriter.write("</h1>");
            printWriter.write("<form method='post' action='/hw_12_servlet_crud/cars-new'>");
            printWriter.write("<label for='brand'>Car brand:</label><br>");
            printWriter.write("<input type='text' id='brand' name='carBrand'/><br><br>");
            printWriter.write("<label for='model'>Car model:</label><br>");
            printWriter.write("<input type='text' id='model' name='carModel'/><br><br>");
            printWriter.write("<label for='year'>Car year:</label><br>");
            printWriter.write("<input type='text' id='year' name='carYear'/><br><br>");
            printWriter.write("<input type='submit' value='Create'/>");
            printWriter.write("</form>");
            printWriter.write("</body>");
            printWriter.write("</html>");
        } catch (Exception e) {
            System.out.println("e" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setStatus(201);
        Map<String, String[]> parameterMap = req.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            Car car = new Car();
            parameterMap.forEach((k, v) -> {
                switch (k) {
                    case "carBrand" -> car.setCarBrand(v[0]);
                    case "carModel" -> car.setCarModel(v[0]);
                    case "carYear" -> car.setCarYear(Integer.parseInt(v[0]));
                }
            });
            carService.create(car);
        }
        resp.sendRedirect("cars");
    }
}