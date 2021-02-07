package com.spring.ioc.java.beans;

/**
 * POJO类
 * <p>
 *     Setter / Getter 方法
 *     可写方法（Writable）/ 可读方法（Readable）
 * </p>
 * 反射包含的三大信息：属性、方法、构造器
 * @author lipan
 * @date 2021-02-02
 */
public class Person {
    String name; // Property

    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
