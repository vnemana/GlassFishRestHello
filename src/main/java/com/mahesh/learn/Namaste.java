package com.mahesh.learn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mahesh on 5/11/17.
 */

@Path("/namaste")
public class Namaste extends HttpServlet {
    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "NAMASTE!!";
    }

    @GET
    @Produces ("text/html")
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
}
