package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: wyx
 * @Date: 2021/5/29
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENT_DOMAIN = "http://CLOUD-PAYMENT-SERVICE";

    /**
     * 模拟用户端，用浏览器访问get方便
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult<?> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_DOMAIN + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<?> getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_DOMAIN + "/payment/get/" + id, CommonResult.class);
    }
}
