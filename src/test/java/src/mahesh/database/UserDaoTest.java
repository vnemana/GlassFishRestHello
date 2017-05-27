package src.mahesh.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by mahesh on 5/13/17.
 */
public class UserDaoTest {
    @Test
    public void testInsertUser() {
        try {
            Connection dbConn = SQLFactory.getConnectionForUnitTests();
            UserDao userDao = new UserDao();
            userDao.insertUser(dbConn, "FirstName", "LastName", "M", "username");
            Assert.assertTrue(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test (expected=IllegalArgumentException.class)
    public void testInsertWithNullUsername() {
        try {
            Connection dbConn = SQLFactory.getConnectionForUnitTests();
            UserDao userDao = new UserDao();
            userDao.insertUser(dbConn, "FirstName", "LastName", "M", null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test (expected=IllegalArgumentException.class)
    public void testInsertWithBlankUsername() {
        try {
            Connection dbConn = SQLFactory.getConnectionForUnitTests();
            UserDao userDao = new UserDao();
            userDao.insertUser(dbConn, "FirstName", "LastName", "M", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test (expected=IllegalArgumentException.class)
    public void testInsertWithNullFirstName() {
        try {
            Connection dbConn = SQLFactory.getConnectionForUnitTests();
            UserDao userDao = new UserDao();
            userDao.insertUser(dbConn, null, "LastName", "M", "username");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test (expected=IllegalArgumentException.class)
    public void testInsertWithBlankFirstName() {
        try {
            Connection dbConn = SQLFactory.getConnectionForUnitTests();
            UserDao userDao = new UserDao();
            userDao.insertUser(dbConn, "", "LastName", "M", "username");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test (expected=IllegalArgumentException.class)
    public void testInsertWithNullLastName() {
        try {
            Connection dbConn = SQLFactory.getConnectionForUnitTests();
            UserDao userDao = new UserDao();
            userDao.insertUser(dbConn, "FirstName", null, "M", "username");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test (expected=IllegalArgumentException.class)
    public void testInsertWithBlankLastName() {
        try {
            Connection dbConn = SQLFactory.getConnectionForUnitTests();
            UserDao userDao = new UserDao();
            userDao.insertUser(dbConn, "FirstName", "", "M", "username");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}