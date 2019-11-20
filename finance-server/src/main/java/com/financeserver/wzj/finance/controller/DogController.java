package com.financeserver.wzj.finance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.financeserver.wzj.finance.mapper.DogMapper;
import com.financeserver.wzj.finance.model.Dog;
import com.financeserver.wzj.finance.model.PageRequest;
import com.financeserver.wzj.finance.model.PageResponse;
import com.financeserver.wzj.finance.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wangzhaojian
 * @Date 2019/11/19 16:47
 */
@RestController
@RequestMapping("/dog")
@Slf4j
public class DogController {

    @Autowired
    private DogMapper dogMapper;

    @PostMapping(value = "/add")
    public void add(@RequestBody Dog dog) {
//        Integer integer = dogMapper.insert(dog);
//        log.info("2222222222" + integer);

        Dog dog2 = dogMapper.selectById(1);
        System.out.println("2222222222222" + dog2.getName());

        QueryWrapper<Dog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "旺财");
        List<Dog> dogs = dogMapper.selectList(queryWrapper);
        System.out.println("3333333333333" + dogs.get(0).getName());

        dog2.setDescription("修改");
        Integer integer = dogMapper.updateById(dog2);
        System.out.println(integer);

        Dog dog1 = new Dog();
        dog1.setDescription("修改");
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "旺财2");
        integer = dogMapper.update(dog1, queryWrapper);
        System.out.println(integer);

    }

    @PostMapping(value = "/list-page")
    public void selectListByPage() {
        QueryWrapper<Dog> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("id", 1);
        // 第几页
        Integer current = 1;
        // 每页条数
        Integer size = 1;
        Page page = new Page<>(current, size);
        IPage<Dog> iPage = dogMapper.selectPage(page, queryWrapper);
        List<Dog> list = iPage.getRecords();
        System.out.println("list.size " + list.size());
        System.out.println("Current " + iPage.getCurrent());// 当前页
        System.out.println("Page " + iPage.getPages());// 总页数
        System.out.println("Size " + iPage.getSize());// 每一页个数
        System.out.println("Total " + iPage.getTotal());// 总条数
    }

    @PostMapping(value = "/list-page-user")
    public PageResponse selectListByPage(@RequestBody PageRequest<Dog> request) {
        Dog dog = request.getContent();
        QueryWrapper<Dog> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("id", 1);
        Page page = new Page<>(request.getCurrent(), request.getSize());
        IPage<Dog> iPage = dogMapper.selectPage(page, queryWrapper);
        PageResponse response = new PageResponse<User>();
        response.setData(page.getRecords());
        response.setCurrent((int) iPage.getCurrent());
        response.setSize((int) iPage.getSize());
        response.setPages((int) iPage.getPages());
        response.setTotal((int) iPage.getTotal());
        return response;
    }

    @PostMapping(value = "/list-page-user-sql")
    public PageResponse selectListByPageBySql(@RequestBody PageRequest<Dog> request) {
        Dog dog = request.getContent();
        Page page = new Page<>(request.getCurrent(), request.getSize());
//        IPage<Dog> iPage = dogMapper.selectListAll(page, dog);
        List<Dog> list = dogMapper.selectListAll(dog);
        PageResponse response = new PageResponse<User>();
//        response.setData(page.getRecords());
//        response.setCurrent((int) iPage.getCurrent());
//        response.setSize((int) iPage.getSize());
//        response.setPages((int) iPage.getPages());
//        response.setTotal((int) iPage.getTotal());
        return response;
    }
}
