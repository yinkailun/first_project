package com.ik.service.callrobot.annotation;

/**
 * @author yinkailun
 * @description:
 * @date 2018-09-11 下午5:52
 */
@DBTable(name = "TABLE_CREATE_CLASS")
public class DBTableCreateClass {

    @SqlString(name = "ID",constraints = @Constraints(isPrimaryKey = true))
    private String id;

    @SqlInteger(name = "AGE" ,length = 10)
    private int age;

    @SqlString(name = "NAME" ,constraints = @Constraints(allowNull = true))
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
