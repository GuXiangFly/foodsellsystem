package cn.guxiangfly.foodsellsystem.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * CookieUtil
 *
 * @author guxiang
 * @date 2017/11/15
 */
public class CookieUtil {

    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }


    public static Cookie get(HttpServletRequest request,String cookieName){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(cookieName)){
            return cookieMap.get(cookieName);
        }
        return null;
    }

    /**
     * 将 Cookie 封装为map
     * @param request
     * @return
     */
    private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<>();

        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return  cookieMap;
    }
}
