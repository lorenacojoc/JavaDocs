package ro.teamnet.zth.api.em;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lorena on 7/7/2016.
 */

public class QueryBuilder {

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public String getValueForQuery(Object value) {
        if (value.getClass().equals(String.class)) {
            return "'" + value + "'";
        } else if (value.getClass().equals(Date.class)) {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('" + dateFormat.format((Date) value) + "','mm-dd-YYYY'";

        }else {

            return value.toString();
        }
    }

    public QueryBuilder addCondition(Condition condition) {
        if (this.conditions == null) {
            this.conditions = new ArrayList<>();
        }
        conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName) {

        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {
        if (this.queryColumns == null) {
            this.queryColumns = new ArrayList<>();
        }
//        for(ColumnInfo column : queryColumns){
//            queryColumns.add(column);
//        }
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

    private String createSelectQuery() {
        StringBuilder query = new StringBuilder();
        query.append("select");
        boolean first = true;
        for (ColumnInfo column : queryColumns) {
            if (!first) {
                query.append(",");
            }
            query.append(tableName).append(".").append(column.getDbName());
            first = false;
        }
        query.append("from").append(tableName);

        boolean where_cond = false;
        if (conditions != null && !conditions.isEmpty()) {
            for (Condition condition : conditions) {
//                query.append(where_cond ? " and" : " where ").append(condition.getColumnName()).append("=")
//                        .append(getValueForQuery(condition.getValue()));
                if (where_cond) {
                    query.append("and").append(condition.getColumnName()).append("=").append(getValueForQuery(condition.getValue()));
                } else {
                    query.append("where").append(condition.getColumnName()).append("=").append(getValueForQuery(condition.getValue()));
                }
                where_cond = true;
            }
        }
        return query.toString();
    }


    private String createDeleteQuery() {
        StringBuilder query = new StringBuilder();
        query.append("delete from ").append(tableName);
        boolean whereAdded = false;
        if (conditions != null && !conditions.isEmpty()) {
            for (Condition condition : conditions) {
                query.append(whereAdded ? " and" : " where ").append(condition.getColumnName()).append("=").append(getValueForQuery(condition.getValue()));
                whereAdded = true;
            }
        }
        return query.toString();
    }


    private String createUpdateQuery() {

        StringBuilder query = new StringBuilder();
        query.append("update ").append(tableName).append(" set ");
        boolean first = true;
        for (ColumnInfo column : queryColumns) {
            if (!column.isId()) {
                if (!first) {
                    query.append(",");
                } else {
                    first = false;
                }
                query.append(column.getDbName()).append("=").append(getValueForQuery(column.getValue()));
            }
        }

        boolean where_cond = false;
        if (conditions != null  && !conditions.isEmpty()){
            for (Condition condition : conditions) {
                if (where_cond) {
                    query.append("and").append(condition.getColumnName()).append("=").append(getValueForQuery(condition.getValue()));
                } else {
                    query.append("where").append(condition.getColumnName()).append("=").append(getValueForQuery(condition.getValue()));
                }
                where_cond = true;
            }
        }
        return query.toString();

    }


   private String createInsertQuery(){

       StringBuilder query = new StringBuilder();
       query.append("insert into ").append(tableName).append(" (");
       StringBuilder values = new StringBuilder(" values (");
       boolean first = true;
       for (ColumnInfo columnInfo : queryColumns) {
           if (columnInfo.isId()) {
               continue;
           }
           if (!first) {
               query.append(",");
               values.append(",");
           } else {
               first = false;
           }
           query.append(columnInfo.getDbName());
           values.append(getValueForQuery(columnInfo.getValue()));
       }

       query.append(") ");
       values.append(")");
       query.append(values);

       return query.toString();
   }

    public String createQuery() {
        if (QueryType.SELECT.equals(this.queryType)){
            return createSelectQuery();
        } else if (QueryType.INSERT.equals(this.queryType)) {
            return createInsertQuery();
        } else if (QueryType.UPDATE.equals(this.queryType)) {
            return createUpdateQuery();
        } else if (QueryType.DELETE.equals(this.queryType)) {
            return createDeleteQuery();
        }
        return null;
    }

}
