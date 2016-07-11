package ro.teamnet.zth.api.em;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lorena on 7/8/2016.
 */
public interface EntityManager {
    <T> T findById(Class<T> entityClass, Long id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException;
    Long getNextIdVal(String tableName, String columnIdName) throws SQLException, ClassNotFoundException;
    <T> Object insert(T entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException;
    <T> List<T> findAll(Class<T> entityClass) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException;

}
