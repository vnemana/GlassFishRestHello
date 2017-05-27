package src.mahesh.database;

import src.mahesh.database.dbobjects.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mahesh on 5/13/17.
 */
public class UserDao {

    public void insertUser(Connection dbConn, String fname, String lname, String mname, String username) {
        try {
            if (username == null || username.equals(""))
                throw new IllegalArgumentException("username is null or empty.");
            if (fname == null || fname.equals(""))
                throw new IllegalArgumentException("First name is null or empty.");
            if (lname == null || lname.equals(""))
                throw new IllegalArgumentException("Last name is null or empty.");

            String insertSQL = "insert into workoutdb.user " +
                    "(first_name, last_name, middle_name, username) values " +
                    "('" + fname + "','" + lname + "','" + mname + "','" + username + "')";
            Statement statement = dbConn.createStatement();
            statement.executeUpdate(insertSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAllUsers(Connection dbConn) {
        ArrayList<User> users = new ArrayList<>();
        try {
            String getSQL = "select first_name, middle_name, last_name, username from workoutdb.user";
            Statement statement = dbConn.createStatement();
            ResultSet rs = statement.executeQuery(getSQL);
            while (rs.next()) {
                User user = new User(rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("middle_name"), rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

