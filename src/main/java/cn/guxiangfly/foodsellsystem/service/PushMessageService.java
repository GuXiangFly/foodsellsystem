package cn.guxiangfly.foodsellsystem.service;

import cn.guxiangfly.foodsellsystem.dto.OrderDTO;

/**
 * PushMessageService
 *
 * @author guxiang
 * @date 2017/11/18
 */
public interface PushMessageService {
    void orderStatus(OrderDTO orderDTO);
}
