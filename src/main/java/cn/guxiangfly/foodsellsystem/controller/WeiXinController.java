package cn.guxiangfly.foodsellsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * WeiXinController
 *
 * @author guxiang
 * @date 2017/11/7
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    private final String APPID= "wx514922bffbab142f";

    private final String APPSecret="4cf6bb876c84dd8e51e4838e17f28131";

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){

        log.info("code={}",code);
        log.info("进入auth方法。。");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+APPSecret+"&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String object = restTemplate.getForObject(url, String.class);
        log.info("object={}",object);
    }
}
