package com.demo.web;


import com.demo.service.impl.OrderServiceImpl;
import com.demo.util.ResponseMessage;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-04-09
 */
@RestController
@RequestMapping("/demo/order")
@Log
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping(value = "/seckill", method = RequestMethod.POST)
    public ResponseMessage<Object> seckill(@RequestBody String productId){
        try {
            orderService.seckill(productId);
        }catch (Exception e){
            log.info("订单创建失败,"+e);
            return ResponseMessage.error("创建订单失败:"+e.getMessage());
        }
        return ResponseMessage.ok("订单创建成功");
    }

}

