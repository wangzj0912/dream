package com.userserver.userserver.wzj.user.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    /**
     * ID
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 分组id
     */
    private String gropId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

}
