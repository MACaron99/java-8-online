package org.example.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.Car;
import org.example.service.CarService;
import org.example.service.impl.CarServiceImpl;

import java.io.PrintWriter;

public class CarReviewController extends HttpServlet {

    private final CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(200);

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang=\"en\">");
            printWriter.write("<head>");
            printWriter.write("<meta charset=\"UTF-8\">");
            printWriter.write("<title>Review all cars</title>");
            printWriter.write("</head>");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Cars");
            printWriter.write("</h1>");
            printWriter.write("<table>");
            printWriter.write("<tr>");
            printWriter.write("<th>Id</th>");
            printWriter.write("<th>Brand</th>");
            printWriter.write("<th>Model</th>");
            printWriter.write("<th>Year</th>");
            printWriter.write("<th>Parks</th>");
            printWriter.write("<th></th>");
            printWriter.write("<th></th>");
            printWriter.write("<td>");
            printWriter.write("<a href=\"/hw_12_servlet_crud/cars-new\">New car</a>");
            printWriter.write("</td>");
            printWriter.write("</tr>");

            for (Car car : carService.findAll()) {
                printWriter.write("<tr>");
                printWriter.write("<td>");
                printWriter.write(String.valueOf(car.getId()));
                printWriter.write("</td>");
                printWriter.write("<td>");
                printWriter.write(car.getCarBrand());
                printWriter.write("</td>");
                printWriter.write("<td>");
                printWriter.write(car.getCarModel());
                printWriter.write("</td>");
                printWriter.write("<td>");
                printWriter.write(Integer.toString(car.getCarYear()));
                printWriter.write("</td>");
                printWriter.write("<td>");
                printWriter.write("<a href=\"/hw_12_servlet_crud/car-parks?carId=" + car.getId() + "\">" + car.getParks().size() + "</a>");
                printWriter.write("</td>");
                printWriter.write("<td>");
                printWriter.write("<a href=\"/hw_12_servlet_crud/cars-delete?carId=" + car.getId() + "\">delete</a>");
                printWriter.write("</td>");
                printWriter.write("<td>");
                printWriter.write("<a href=\"/hw_12_servlet_crud/cars-update?carId=" + car.getId() + "\">update</a>");
                printWriter.write("</td>");
                printWriter.write("</tr>");
            }
            printWriter.write("</table>");
            printWriter.write("</body>");
            printWriter.write("</html>");
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
