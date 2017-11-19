package cn.guxiangfly.foodsellsystem.utils;

import cn.guxiangfly.foodsellsystem.enums.CodeEnum;
import org.aopalliance.reflect.Code;

/**
 * EnumUtil
 *
 * @author guxiang
 * @date 2017/11/9
 */
public class EnumUtil {
    private EnumUtil(){
        
    }
    
    public static <T extends CodeEnum>T getByCode(Integer code,Class<T> enumClass){
        for (T each: enumClass.getEnumConstants() ) {
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
