package cn.guxiangfly.foodsellsystem.service.impl;

import cn.guxiangfly.foodsellsystem.domain.SellerInfo;
import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * SellerServiceImplTest
 *
 * @author guxiang
 * @date 2017/11/13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerServiceImplTest {
    private static final String openid = "abc";

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo result = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid, result.getOpenid());
    }

    @Test
    public void findSellerInfoByUsernameAndPassword() throws Exception{
        SellerInfo sellerInfo = sellerService.findSellerInfoByUsernameAndPassword("admin","admin");
        Assert.assertEquals("abc",sellerInfo.getOpenid());
    }
}