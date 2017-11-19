package cn.guxiangfly.foodsellsystem.service.impl;

import cn.guxiangfly.foodsellsystem.domain.SellerInfo;
import cn.guxiangfly.foodsellsystem.repository.SellerInfoRepository;
import cn.guxiangfly.foodsellsystem.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guxiang
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerInfoByUsernameAndPassword(String username, String password) {


        return repository.findByUsernameAndPassword(username,password);
    }

}