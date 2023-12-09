package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.Car;
import org.example.entity.Park;
import org.example.service.CarService;
import org.example.service.impl.CarServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CarParksReviewController extends HttpServlet {

    private final CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang=\"en\">");
            printWriter.write("<head>");
            printWriter.write("<meta charset=\"UTF-8\">");
            printWriter.write("</head>");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Car parks");
            printWriter.write("</h1>");
            printWriter.write("<table>");
            printWriter.write("<tr>");
            printWriter.write("<th>Id</th>");
            printWriter.write("<th>Name</th>");
            printWriter.write("</tr>");
            Optional<Car> optionalCar = carService.findById(Long.valueOf(req.getParameter("carId")));
            if (optionalCar.isPresent()) {
                Car car = optionalCar.get();
                for (Park park : car.getParks()) {
                    printWriter.write("<tr>");
                    printWriter.write("<td>");
                    printWriter.write(String.valueOf(park.getId()));
                    printWriter.write("</td>");
                    printWriter.write("<td>");
                    printWriter.write(park.getName());
                    printWriter.write("</td>");
                    printWriter.write("</tr>");
                }
            }
            printWriter.write("</table>");
            printWriter.write("</body>");
            printWriter.write("</html>");
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}