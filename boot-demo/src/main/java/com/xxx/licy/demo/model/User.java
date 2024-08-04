package com.xxx.licy.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lichenyang
 * @since 2022/9/14 17:24
 */
@Data
@NoArgsConstructor
public class User {

    /**
     * 用户ID
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", sex='" + sex + '\'' + ", age=" + age + '}';
    }
}
