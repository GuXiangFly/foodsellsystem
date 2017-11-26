package cn.guxiangfly.foodsellsystem.VO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * ResultVO
 *
 * @author guxiang
 * @date 2017/11/5
 */
@Data
//@Builder
public class ResultVO <T> implements Serializable{

    private static final long serialVersionUID = -9079831011077362658L;
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
