package com.visa.prj.util;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

import java.lang.reflect.Method;

public class SqlUtil {
    StringBuffer buffer; // Thread Safety
    public static String createSQL(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();
        Table table = clazz.getAnnotation(Table.class);
        if(table != null) {
            builder.append("create table ");
            builder.append(table.name()); // getter
            builder.append("(");
            Method[] methods = clazz.getMethods();
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    Column col = m.getAnnotation(Column.class);
                    if(col != null) {
                        builder.append(col.name());
                        builder.append(" ");
                        builder.append(col.type());
                        builder.append(", "); // create table books book_id NUMERIC(12,2),
                    }
                }
            }
            builder.setCharAt(builder.lastIndexOf(","), ')');
        }
        return  builder.toString();
    }

    public static String insertSQL(Object obj) {
        // Task
        return null;
    }
}
