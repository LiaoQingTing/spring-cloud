package com.liaoqingting.hystrix.payment.service;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午4:11
 */
public interface PaymentService {

    String paymentInfoOK(int id);

    String paymentInfoTimeOut(int id);
}
