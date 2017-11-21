package cn.guxiangfly.foodsellsystem.service;

import javafx.geometry.VPos;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * RedisLock
 *
 * @author guxiang
 * @date 2017/11/21
 */
@Service
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁snd2
     * @param key
     * @param value
     * @return
     */
    public boolean lock(String key,String value){
        if (redisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        // 如果锁过期了
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue)<System.currentTimeMillis()){
            //获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue)&& oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁，就是删除KEY
     * @param key
     * @param value
     */
    public void  unlock(String key,String value){

        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("[redis分布式锁] 解锁出现异常{}",e);
        }

    }}
