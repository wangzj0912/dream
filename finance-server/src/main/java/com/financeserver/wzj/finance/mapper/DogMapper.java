package com.financeserver.wzj.finance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.financeserver.wzj.finance.model.Dog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wangzhaojian
 * @Date 2019/11/19 16:42
 */
@Repository
@Mapper
public interface DogMapper extends BaseMapper<Dog> {

    /**
     * 3.x 的 page 可以进行取值
     * 如果入参是有多个,需要加注解@Param指定参数名才能在xml中取值
     * 自定义 page 类必须放在入参第一位
     * 返回值可以用 IPage<T> 接收 也可以使用入参的 MyPage<T> 接收
     *
     * @param  page
     * @return 分页数据
     */
    IPage<Dog> selectListAll(Page page, @Param("ea") Dog dog);

    List<Dog> selectListAll (@Param("ea") Dog dog);

}
