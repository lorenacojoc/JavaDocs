package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lorena on 7/7/2016.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }


    @Test
    public void testGetColumnsMathod() {
        List<ColumnInfo> columnInfos = EntityUtils.getColumns(Department.class);
        assertEquals("Three elements",3, columnInfos.size());

    }


    @Test
    public void testCastFromSqlTypeMethod(){
        Object obj = EntityUtils.castFromSqlType(2,Integer.class);
        assert (obj instanceof Integer);
    }

    @Test
    public void testGetFieldsByAnnotations () {
        assertEquals(2, EntityUtils.getFieldsByAnnotations(Department.class, Column.class).size());
    }

//    @Test
//    public void testGetSqlValueTable() throws IllegalAccessException {
//
//        Object obj = EntityUtils.getSqlValue(new Department());
//        assert (obj instanceof Field);
//    }


}
