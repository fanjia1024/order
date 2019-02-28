package com.imooc.order.controller;

import com.imooc.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ClientController {
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private ProductClient productClient;


    @GetMapping("getProductMsg")
    public String getProductMsg(){
        //1.第一种方式RestTemplate url写死
//        RestTemplate restTemplate=new RestTemplate();
//        String response=restTemplate.getForObject("http://localhost:8082/msg",String.class);
        //2.第二种方式应用loadBalancerClient通过应用名和端口在进行restTemplate
//        ServiceInstance serviceInstance =loadBalancerClient.choose("PRODUCT");
//
//        String url=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
//        RestTemplate restTemplate=new RestTemplate();
//        String response=restTemplate.getForObject(url,String.class);
        //3.利用@LoadBalanced注解的方式进行调用服务接口，可以在restTemplate里的url进行使用应用系统名称的方式进行调用
//        String response=restTemplate.getForObject("http://PRODUCT/msg",String.class);
        String response=productClient.productMsg();
        log.info(response);
        return response;
    }
}
