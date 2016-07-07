package ro.teamnet.zth.api.em;

import javafx.scene.control.Tab;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Lorena on 7/7/2016.
 */
public class EntityUtils {

    private EntityUtils() {
        throw new UnsupportedOperationException();

    }

    public static String getTableName(Class entity) {

        Table annotation = (Table) entity.getAnnotation(Table.class);
        if (annotation != null) {
            return annotation.name();
        } else {
            return entity.getSimpleName();
        }
    }

    public static List<ColumnInfo> getColumns(Class entity) {

        Column column = (Column) entity.getAnnotation(Column.class);
        Field[] fields = entity.getDeclaredFields();
        List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();


        ColumnInfo columnInfo = new ColumnInfo();


        for (Field field : fields) {
            if (field.getAnnotation(Id.class) != null) {
                columnInfo.setId(true);

                columnInfos.add(columnInfo);

            } else if (field.getAnnotation(Column.class) != null) {

                columnInfo.setId(false);
                columnInfo.setColumnName(field.getName());
                columnInfo.setDbName(field.getName());
                columnInfo.setGetColumnType(field.getType());
                columnInfo.setValue(field.getName());


                columnInfos.add(columnInfo);
            }
        }
        return columnInfos;
    }

    public static Object castFromSqlType(Object value, Class wantedType) {

        if (value.getClass().equals(BigDecimal.class) && wantedType.equals(Integer.class)) {
            return (Integer)value;
        }

        if (value.getClass().equals(BigDecimal.class) && wantedType.equals(Long.class)) {
            return (Long)value;
        }
        if (value.getClass().equals(BigDecimal.class) && wantedType.equals(Float.class)) {
            return (Float)value;
        }

        if (value.getClass().equals(BigDecimal.class) && wantedType.equals(Double.class)) {
            return (Double)value;
        }

        return value;

    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation){

        Field[] fields = clazz.getDeclaredFields();
        List<Field> fieldss = new ArrayList<Field>();

        for( Field field : fields){
            if(field.getAnnotation(annotation) != null){
                fieldss.add(field);
            }

        }

        return fieldss;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if(object == null){return null;}

        if (object.getClass().getAnnotation(Table.class) != null){
            List<Field> fields = getFieldsByAnnotations(object.getClass(),Id.class);
                Field id = fields.get(0);
                id.setAccessible(true);
                return id.get(object);
            }else {

            return object;
        }
    }

}