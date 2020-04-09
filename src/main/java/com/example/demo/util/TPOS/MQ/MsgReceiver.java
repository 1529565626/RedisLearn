package com.example.demo.util.TPOS.MQ;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;


/**
 * <p>
 * 消息接收（根据项目功能需求自行更改）
 * </p>
 * ***********************************************
 * BECAUSE OF CHOICE, STICK TO IT.               *
 * ***********************************************
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年08月22日 11:48
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
@Component
public class MsgReceiver {

    /**
     * @param 日志打印
     */
    protected final Logger logger = LogManager.getLogger(MsgReceiver.class);

//    @JmsListener(destination = "index")
//    public void list(String token) {
//        logger.debug("接收到：" + token);
//    }


}
