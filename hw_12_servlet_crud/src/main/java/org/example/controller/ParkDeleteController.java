package org.example.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.ParkService;
import org.example.service.impl.ParkServiceImpl;

import java.io.IOException;

public class ParkDeleteController extends HttpServlet {

    private final ParkService parkService = new ParkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        parkService.delete(Long.parseLong(req.getParameter("parkId")));

        resp.sendRedirect("parks");
    }
}
