package cn.guxiangfly.foodsellsystem.repository;

import cn.guxiangfly.foodsellsystem.domain.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);

    SellerInfo findByUsernameAndPassword(String username,String password);
}