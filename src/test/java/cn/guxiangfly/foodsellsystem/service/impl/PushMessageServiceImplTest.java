package cn.guxiangfly.foodsellsystem.service.impl;

import cn.guxiangfly.foodsellsystem.dto.OrderDTO;
import cn.guxiangfly.foodsellsystem.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * PushMessageServiceImplTest
 *
 * @author guxiang
 * @date 2017/11/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {


    @Autowired
    private OrderService orderService;
    @Autowired
    private PushMessageServiceImpl pushMessageService;


    @Test
    public void orderStatus() throws Exception {
        OrderDTO one = orderService.findOne("150988782620326543");
        pushMessageService.orderStatus(one);
    }

}