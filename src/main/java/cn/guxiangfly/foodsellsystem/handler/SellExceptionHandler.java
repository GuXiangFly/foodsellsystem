package cn.guxiangfly.foodsellsystem.handler;

import cn.guxiangfly.foodsellsystem.VO.ResultVO;
import cn.guxiangfly.foodsellsystem.exception.SellException;
import cn.guxiangfly.foodsellsystem.exception.SellerAuthorizeException;
import cn.guxiangfly.foodsellsystem.utils.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * SellExceptionHandler
 *
 * @author guxiang
 * @date 2017/11/5
 */
@ControllerAdvice
public class SellExceptionHandler {
    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerSellerAuthorizeException(Exception e){
        e.printStackTrace();
        return new ModelAndView("redirect:/seller/loginPage");
    }

    @ExceptionHandler
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}