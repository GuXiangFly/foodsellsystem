package cn.guxiangfly.foodsellsystem.aspect;

import cn.guxiangfly.foodsellsystem.constant.CookieConstant;
import cn.guxiangfly.foodsellsystem.constant.RedisConstant;
import cn.guxiangfly.foodsellsystem.exception.SellerAuthorizeException;
import cn.guxiangfly.foodsellsystem.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * SellerAuthorizeAspect
 *
 * @author guxiang
 * @date 2017/11/15
 */
@Component
@Aspect
@Slf4j
public class SellerAuthorizeAspect {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * cn.guxiangfly.foodsellsystem.controller.Seller*.*(..))"
            +"&& !execution(public * cn.guxiangfly.foodsellsystem.controller.SellerUserController.*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie==null){
            log.warn("[登录校验]Cookie中找不到token");
            throw new SellerAuthorizeException();
        }
        //redis中查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));

        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }
    }
}
