package com.example.demo.controller;

import com.example.demo.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author sasaki
 * @date 2020/5/4 0004 10:13
 */
@RestController
@RequestMapping(value = "/aaa", produces = "application/json;charset=UTF-8")
public class QuartzController {

    @Autowired
    private QuartzService quartzService;

//    @PostConstruct
//    public void init(){
//        String orderNoHead = "20200427";
//        String msg = "订单过期未付款，进行关闭订单";
//        for (int i = 1;i<100;i++){
//            System.out.println("第"+i+"次开始");
//            String orderNo = "";
//            if (i<10){
//                orderNo = orderNoHead+"00"+i;
//            }else if ( i<100&&i>10){
//                orderNo = orderNoHead+"0"+i;
//            }else {
//                orderNo = orderNoHead+i;
//            }
//            quartzService.orderClose(""+i,orderNo,msg,1);
//            System.out.println("第"+i+"次结束");
//        }
//    }

    @GetMapping("/bbb")
    public void testQuartz(){
        String orderNoHead = "20200427";
        String msg = "订单过期未付款，进行关闭订单";
        for (int i = 1;i<100;i++){
            System.out.println("第"+i+"次开始");
            String orderNo = "";
            if (i<10){
                orderNo = orderNoHead+"00"+i;
            }else if ( i<100&&i>10){
                orderNo = orderNoHead+"0"+i;
            }else {
                orderNo = orderNoHead+i;
            }
            quartzService.orderClose(""+i,orderNo,msg,1);
            System.out.println("第"+i+"次结束");
        }
    }

}
