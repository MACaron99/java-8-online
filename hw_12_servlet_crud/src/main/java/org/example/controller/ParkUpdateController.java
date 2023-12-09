package org.example.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.Park;
import org.example.service.ParkService;
import org.example.service.impl.ParkServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class ParkUpdateController extends HttpServlet {

    private final ParkService parkService = new ParkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Park> optionalPark = parkService.findById(Long.parseLong(req.getParameter("parkId")));
        if (optionalPark.isPresent()) {
            Park park = optionalPark.get();
            resp.setStatus(200);
            try(PrintWriter printWriter = resp.getWriter()) {
                printWriter.write("<!DOCTYPE html>");
                printWriter.write("<html lang='en'>");
                printWriter.write("<body>");
                printWriter.write("<h1>");
                printWriter.write("Update park");
                printWriter.write("</h1>");
                printWriter.write("<form method='post' action='/hw_12_servlet_crud/parks-update'>");
                printWriter.write("<label for='name'>Park name:</label><br>");
                printWriter.write("<input type='text' id='name' name='parkName' value='" + park.getName() + "'/><br><br>");
                printWriter.write("<input type='hidden' id='id' name='parkId' value='" + park.getId() + "'/>");
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
        Optional<Park> optionalPark = parkService.findById(Long.parseLong(req.getParameter("parkId")));
        if (optionalPark.isPresent()) {
            Park park = optionalPark.get();
            park.setName(req.getParameter("parkName"));
            parkService.update(park);
        }
        resp.sendRedirect("parks");
    }
}