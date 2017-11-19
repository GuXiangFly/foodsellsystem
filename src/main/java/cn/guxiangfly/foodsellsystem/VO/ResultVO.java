package cn.guxiangfly.foodsellsystem.VO;

import lombok.Builder;
import lombok.Data;

/**
 * ResultVO
 *
 * @author guxiang
 * @date 2017/11/5
 */
@Data
//@Builder
public class ResultVO <T>{
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
