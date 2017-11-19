package cn.guxiangfly.foodsellsystem.service;

import cn.guxiangfly.foodsellsystem.domain.SellerInfo;

public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

    /**
     * 通过用户名密码查询
     */
    SellerInfo findSellerInfoByUsernameAndPassword(String username,String password);
}
