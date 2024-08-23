package org.example.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.Park;
import org.example.service.ParkService;
import org.example.service.impl.ParkServiceImpl;

import java.io.PrintWriter;

public class ParkReviewController extends HttpServlet {

    private final ParkService parkService = new ParkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(200);
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang=\"en\">");
            printWriter.write("<head>");
            printWriter.write("<meta charset=\"UTF-8\">");
            printWriter.write("<title>Review all parks</title>");
            printWriter.write("<meta http-equiv=\"Cache-Control\" content=\"no-cache, no-store, " +
                    "must-revalidate\" />\n");
            printWriter.write("<meta http-equiv=\"Pragma\" content=\"no-cache\" />\n");
            printWriter.write("<meta http-equiv=\"Expires\" content=\"0\" />\n");
            printWriter.write("</head>");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Parks");
            printWriter.write("</h1>");
            printWriter.write("<table>");
            printWriter.write("<tr>");
            printWriter.write("<th>Id</th>");
            printWriter.write("<th>Name</th>");
            printWriter.write("<th>Cars</th>");
            printWriter.write("<th></th>");
            printWriter.write("<th></th>");
            printWriter.write("<td>");
            printWriter.write("<a href=\"/hw_12_servlet_crud/parks-new\">New park</a>");
            printWriter.write("</td>");
            printWriter.write("</tr>");

            for (Park park : parkService.findAll()) {
                printWriter.write("<tr>");

                printWriter.write("<td>");
                printWriter.write(String.valueOf(park.getId()));
                printWriter.write("</td>");

                printWriter.write("<td>");
                printWriter.write(park.getName());
                printWriter.write("</td>");

                printWriter.write("<td>");
                printWriter.write("<a href=\"/hw_12_servlet_crud/park-cars?parkId=" + park.getId() + "\">" + park.getCars().size() + "</a>");
                printWriter.write("</td>");

                printWriter.write("<td>");
                printWriter.write("<a href=\"/hw_12_servlet_crud/parks-delete?parkId=" + park.getId() + "\">delete</a>");
                printWriter.write("</td>");

                printWriter.write("<td>");
                printWriter.write("<a href=\"/hw_12_servlet_crud/parks-update?parkId=" + park.getId() + "\">update</a>");
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
