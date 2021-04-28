package com.softnovo.repository;

import com.softnovo.domain.Order;
import com.softnovo.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void getOne() {
        Order order = orderMapper.getOne(1L);
        System.out.println("====== " + order);
    }
    @Test
    public void template() {
        Object obj = sqlSessionTemplate.selectOne("OrderMapper.getOne", 1L);
        System.out.println("======== " + obj);
    }

}
