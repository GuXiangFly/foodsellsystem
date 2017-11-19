package cn.guxiangfly.foodsellsystem.service.impl;

import cn.guxiangfly.foodsellsystem.dto.OrderDTO;
import cn.guxiangfly.foodsellsystem.service.OrderService;
import cn.guxiangfly.foodsellsystem.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * PayServiceImplTest
 *
 * @author guxiang
 * @date 2017/11/8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PayServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("150990417633921398");

        payService.create(orderDTO);
    }

   // @Test
   // public void notify() {
   // }

    @Test
    public void refund() throws Exception {
    }

}