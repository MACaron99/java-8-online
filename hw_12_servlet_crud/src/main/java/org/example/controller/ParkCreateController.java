package org.example.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.MapUtils;
import org.example.entity.Park;
import org.example.service.ParkService;
import org.example.service.impl.ParkServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ParkCreateController extends HttpServlet {

    private final ParkService parkService = new ParkServiceImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(200);

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang='en'>");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Create new park");
            printWriter.write("</h1>");
            printWriter.write("<form method='post' action='/hw_12_servlet_crud/parks-new'>");
            printWriter.write("<label for='name'>Park name:</label><br>");
            printWriter.write("<input type='text' id='name' name='parkName'/><br><br>");
            printWriter.write("<input type='submit' value='Create'/>");
            printWriter.write("</form>");
            printWriter.write("</body>");
            printWriter.write("</html>");
        } catch (Exception e) {
            System.out.println("e" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(201);

        Map<String, String[]> parameterMap = req.getParameterMap();

        if (MapUtils.isNotEmpty(parameterMap)) {
            Park park = new Park();

            parameterMap.forEach((k, v) -> {
                if (k.equals("parkName")) {
                    park.setName(v[0]);
                }
            });

            parkService.create(park);
        }
        resp.sendRedirect("parks");
    }
}
