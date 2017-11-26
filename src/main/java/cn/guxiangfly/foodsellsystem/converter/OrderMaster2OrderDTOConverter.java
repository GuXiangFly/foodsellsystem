package cn.guxiangfly.foodsellsystem.converter;

import cn.guxiangfly.foodsellsystem.domain.OrderMaster;
import cn.guxiangfly.foodsellsystem.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster2OrderDTOConverter
 *
 * @author guxiang
 * @date 2017/11/5
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO>  convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e->convert(e))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2008,2,29,1,1,1);
        LocalDateTime localDateTime1 = localDateTime.plusYears(-3);
        System.out.println(localDateTime1);

    }
}
