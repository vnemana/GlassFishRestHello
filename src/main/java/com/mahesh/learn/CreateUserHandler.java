package com.mahesh.learn;

import src.mahesh.database.SQLFactory;
import src.mahesh.database.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by mahesh on 5/13/17.
 */
@Path("/createuserhandler")
public class CreateUserHandler extends HttpServlet {

    @POST
    @Produces("text/html;charset=UTF-8")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html;charset=UTF-8");

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String mname = request.getParameter("mname");
        String username = request.getParameter("username");
        // Actual logic goes here.
        UserDao userDao = new UserDao();
        Connection dbConn = null;
        try {
            dbConn = SQLFactory.getConnectionForGlassFish();
            userDao.insertUser(dbConn, fname, lname, mname, username);
            RequestDispatcher rd = request.getRequestDispatcher("createUser.jsp");
            String message = username + " created";
            request.setAttribute("message", message);
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @GET
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("createUser.jsp");
    }
}