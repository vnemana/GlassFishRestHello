package src.mahesh.database;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by mahesh on 5/13/17.
 */
public class SQLFactory {
    private static String username = "mahesh";
    private static String passwd = "100Koct'05";

    public static Connection getConnectionForGlassFish()
            throws ClassNotFoundException {
        Connection connection = null;

        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
            connection = ds.getConnection();
            return ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NamingException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnectionForUnitTests()
        throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/workoutdb";
            connection = DriverManager.getConnection(url, username, passwd);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
