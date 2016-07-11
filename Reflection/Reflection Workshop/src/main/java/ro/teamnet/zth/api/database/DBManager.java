package ro.teamnet.zth.api.database;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;

/**
 * Created by Lorena on 7/8/2016.
 */
public class DBManager {

    public static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT;

    private DBManager(){
        throw new UnsupportedOperationException();
    }

    private static void  registerDriver() throws ClassNotFoundException {

         Class.forName(DBProperties.DRIVER_CLASS);

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        registerDriver();
        String URL = CONNECTION_STRING;
        String USER = DBProperties.USER;
        String PASS = DBProperties.PASS;
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        return connection;
    }

    public static int checkConnection(Connection connection) throws SQLException {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = null;
            String SQL = "SELECT 1 FROM DUAL";
            if(resultSet.next()) {
                resultSet = stmt.executeQuery(SQL);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            stmt.close();
        }
        return 0;
    }

}
