package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang=\"en\">");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Program SERVLET CRUD");
            printWriter.write("</h1>");
            printWriter.write("<h2>");
            printWriter.write("<a href=\"/hw_12_servlet_crud/cars\">Cars</a>");
            printWriter.write("</h2>");
            printWriter.write("<h2>");
            printWriter.write("<a href=\"/hw_12_servlet_crud/parks\">Parks</a>");
            printWriter.write("</h2>");
            printWriter.write("</body>");
            printWriter.write("</html>");
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}