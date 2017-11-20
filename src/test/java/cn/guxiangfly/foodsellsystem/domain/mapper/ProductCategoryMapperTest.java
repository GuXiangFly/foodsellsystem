package cn.guxiangfly.foodsellsystem.domain.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * ProductCategoryMapperTest
 *
 * @author guxiang
 * @date 2017/11/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("category_name","我的最愛");
        map.put("category_type",111);
        int i = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1,i);
    }

}