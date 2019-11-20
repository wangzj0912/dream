package com.financeserver.wzj.finance.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author wangzhaojian
 * @Date 2019/11/20 9:48
 */
@Setter
@Getter
public class PageResponse<T> {

    /**
     * 数据集合
     */
    private List<T> data;

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 每一页个数
     */
    private Integer size;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 总条数
     */
    private Integer total;
}
