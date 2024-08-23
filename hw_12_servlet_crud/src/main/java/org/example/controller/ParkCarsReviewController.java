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
import java.io.PrintWriter;
import java.util.Optional;

public class ParkCarsReviewController extends HttpServlet {

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
            printWriter.write("Park cars");
            printWriter.write("</h1>");
            printWriter.write("<table>");
            printWriter.write("<tr>");
            printWriter.write("<th>Id</th>");
            printWriter.write("<th>Brand</th>");
            printWriter.write("<th>Model</th>");
            printWriter.write("<th>Year</th>");
            printWriter.write("<th></th>");

            Optional<Park> optionalPark = parkService.findById(Long.valueOf(req.getParameter("parkId")));

            if (optionalPark.isPresent()) {
                Park park = optionalPark.get();

                printWriter.write("<td>");
                printWriter.write("<a href=\"/hw_12_servlet_crud/car-park-add?parkId=" + park.getId()
                        + "\">Add car</a>");
                printWriter.write("</td>");
                printWriter.write("</tr>");

                for (Car car : park.getCars()) {
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
                    printWriter.write("<a href=\"/hw_12_servlet_crud/car-park-delete?carId=" + car.getId()
                            + "&parkId=" + park.getId() + "\">retire</a>");
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
