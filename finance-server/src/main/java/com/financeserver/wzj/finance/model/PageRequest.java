package com.financeserver.wzj.finance.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author wangzhaojian
 * @Date 2019/11/20 9:40
 */
@Setter
@Getter
public class PageRequest<T> implements Serializable {

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 每页条数
     */
    private Integer size;

    /**
     * 表单对象
     */
    private T content;
}
