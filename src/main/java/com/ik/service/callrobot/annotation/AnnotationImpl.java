package com.ik.service.callrobot.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yinkailun
 * @description:
 * @date 2018-09-11 下午5:57
 */
public class AnnotationImpl {

    public String createTable(Class<?> clazz){

        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        if(dbTable == null){
            System.out.println("Class "+clazz.getName()+"has no DBTable Annotation");
            return null;
        }
        String tableNmae = dbTable.name().toUpperCase();
        tableNmae = tableNmae.length() < 1 ? clazz.getName().toUpperCase() : tableNmae;

        List<String> columnDef = new ArrayList<>();
        Field[] fileds = clazz.getDeclaredFields();
        for(Field field : fileds){
            Annotation[] annotation = field.getDeclaredAnnotations();

            if(annotation[0] instanceof SqlString){
                SqlString sqlString = (SqlString) annotation[0];
                columnDef.add(sqlString.name()+getConstraints(sqlString.constraints()));
            }
            if(annotation[0] instanceof SqlInteger){
                SqlInteger sqlInteger = (SqlInteger) annotation[0];
                columnDef.add(sqlInteger.name()+" int("+sqlInteger.length()+")"+getConstraints(sqlInteger.constraints()));
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE ")
                .append(tableNmae)
                .append("(\n");
        for(String column : columnDef){
            sb.append(column +",\n");
        }
        return sb.substring(0,sb.length()-1)+");";

    }

    private String getConstraints(Constraints constraints) {
        String constraintStr = "";
        if(!constraints.allowNull()){
            constraintStr += " NOT NULL ";
        }
        if(constraints.isPrimaryKey()){
            constraintStr += " PRIMARY KEY ";
        }
        if(constraints.unique()){
            constraintStr += " UNIQUE ";
        }
        return constraintStr;
    }

    public static void main(String[] args) {
        System.out.println(new AnnotationImpl().createTable(DBTableCreateClass.class));
    }
}
