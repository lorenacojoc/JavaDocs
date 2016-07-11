package ro.teamnet.zth.api.em;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lorena on 7/8/2016.
 */
public class EntityManagerImpl implements EntityManager {


    @Override
    public <T> T findById(Class<T> entityClass, Long id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();

        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        List<Field> fieldsByAnnotations = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);
        Condition cond = new Condition(fieldsByAnnotations.get(0).getAnnotation(Id.class).name(), id);

        QueryBuilder query = new QueryBuilder();
        query.setTableName(tableName);
        query.addQueryColumns(columns);
        query.setQueryType(QueryType.SELECT);
        query.addCondition(cond);

        String sqlQuery = query.createQuery();
        ResultSet rs = stmt.executeQuery(sqlQuery);

        T instance = null;

        if (rs.next()) {

            instance = entityClass.newInstance();
            for (ColumnInfo c : columns) {
                c.setValue(rs.getObject(c.getDbName()));
                Field field = null;
                field = instance.getClass().getDeclaredField(c.getColumnName());
                field.setAccessible(true);
                field.set(instance, EntityUtils.castFromSqlType(c.getValue(), c.getColumnType()));

            }
            return instance;
        }
        return null;

    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) throws SQLException, ClassNotFoundException {
        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();
        String SQL = "SELECT MAX(columnIdName) AS VALUE FROM tableName";
        ResultSet res = stmt.executeQuery(SQL);
        Long value = null;
        while (res.next()) {
            value = res.getLong("VALUE");
            System.out.println(value + "\t");
        }

        return value+1;
    }


    @Override
    public <T> Object insert(T entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {

        Connection connection = DBManager.getConnection();
        Statement statement = connection.createStatement();
        String tableName = null;
        tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> listColum = new LinkedList<ColumnInfo>();
        listColum = EntityUtils.getColumns(entity.getClass());

        for (ColumnInfo columnInfo : listColum) {
            if (columnInfo.isId()) {
                columnInfo.setValue(getNextIdVal(tableName, columnInfo.getColumnName()));
            } else {
                Field field = entity.getClass().getDeclaredField(columnInfo.getColumnName());
                field.setAccessible(true);
                columnInfo.setValue(field.get(entity));
            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setQueryType(QueryType.INSERT);
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(listColum);

        String query = queryBuilder.createQuery();
        Statement stmtObj = connection.createStatement();
        stmtObj.executeUpdate(query);


        T instance = null;
        String query2 = "select LAST_INSERT_ID()";
        ResultSet rs = stmtObj.executeQuery(query2);
        rs.next();
        Integer lastId = rs.getInt(1);
        rs.close();
        return (T) findById(entity.getClass(), lastId.longValue());

    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();

        List<T> rows = new ArrayList<>();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        QueryBuilder query = new QueryBuilder();
        query.setTableName(tableName);
        query.addQueryColumns(columns);
        query.setQueryType(QueryType.SELECT);

        String sqlQuery = query.createQuery();
        ResultSet rs = stmt.executeQuery(sqlQuery);

        T instance = entityClass.newInstance();

        while (rs.next()) {
            for (ColumnInfo c : columns) {
                c.setValue(rs.getObject(c.getDbName()));
                Field field = instance.getClass().getDeclaredField(c.getColumnName());
                field.setAccessible(true);
                field.set(instance, EntityUtils.castFromSqlType(c.getValue(), c.getColumnType()));
            }
            rows.add(instance);
        }
        return rows;
    }



}