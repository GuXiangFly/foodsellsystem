package cn.guxiangfly.foodsellsystem.utils;

import java.util.Random;

/**
 * KeyUtil
 *
 * @author guxiang
 * @date 2017/11/5
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 时间+6位随机数 + synchronized
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        System.currentTimeMillis();

        Integer number = random.nextInt(90000) + 10000;

        return System.currentTimeMillis()+String.valueOf(number);
    }

}
