package com.xxx.licy.demo.util;


import com.xxx.licy.demo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author lichenyang
 * @since 2022/9/14 17:27
 */
public class DemoUtils {

    /**
     * 创建用户列表
     *
     * @param num 学生数量
     * @return 学生列表
     */
    public static List<User> createUsers(int num) {
        List<User> userList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 获取随机姓氏
            String familyName = RandInfoUtils.getFamilyName();
            // 获取随机性别
            String sex = RandInfoUtils.getSex();
            // 获取随机名称，拼接成姓名
            String name = familyName + RandInfoUtils.getNameBySex(sex);
            // new 一个用户
            User user = new User(name, sex, RandInfoUtils.getAge());
            user.setId(UUID.randomUUID().toString());
            userList.add(user);
        }
        return userList;
    }
}
