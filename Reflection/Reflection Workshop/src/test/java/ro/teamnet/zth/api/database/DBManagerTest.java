package ro.teamnet.zth.api.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lorena on 7/8/2016.
 */
public class DBManagerTest {

    @Test
    public void testGetConnection() throws SQLException, ClassNotFoundException {

        Connection conn = DBManager.getConnection();
        assertEquals(conn != null,true);
    }

    @Test
    public void testCheckConnection() {
        try {
            int value = DBManager.checkConnection(DBManager.getConnection());
            Assert.assertEquals("Value should be 1!", value, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
