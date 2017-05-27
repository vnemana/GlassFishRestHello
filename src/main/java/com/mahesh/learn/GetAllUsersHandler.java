package com.mahesh.learn;

import src.mahesh.database.SQLFactory;
import src.mahesh.database.UserDao;
import src.mahesh.database.dbobjects.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by mahesh on 5/18/17.
 */
@Path("/getallusershandler")
public class GetAllUsersHandler extends HttpServlet {
    @GET
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        Connection dbConn = null;
        System.out.println ("Calling GetAllUsers....");
        try {
            dbConn = SQLFactory.getConnectionForGlassFish();
            ArrayList<User> users = userDao.getAllUsers(dbConn);
            req.setAttribute("userList", users);
            System.out.println("Num Users: " + users.size());
            RequestDispatcher rd = req.getRequestDispatcher("createUser.jsp");
            rd.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}