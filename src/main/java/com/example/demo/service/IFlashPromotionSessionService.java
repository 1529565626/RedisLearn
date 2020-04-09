package com.example.demo.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.FlashPromotionSession;
import com.example.demo.util.ResponseMessage;

/**
 * <p>
 * 限时购场次表 服务类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-23
 */
public interface IFlashPromotionSessionService extends IService<FlashPromotionSession> {

    /**
     * 秒杀场次 新增
     * @param json
     * @return
     */
    ResponseMessage<Object> addProduct(String json);

    /**
     * 秒杀场次 修改
     * @param json
     * @return
     */
    ResponseMessage<Object> editScene(String json);

    /**
     * 秒杀场次 获取可选列表及其数量
     * @param json
     * @return
     */
    ResponseMessage<Object> getSceneSelectList(String json);

    /**
     * 秒杀场次 获取列表
     * @param json
     * @return
     */
    ResponseMessage<Object> getSceneList(String json);

    /**
     * 秒杀场次 更新场次启用状态
     * @param json
     * @return
     */
    ResponseMessage<Object> updateStatus(String json);

    /**
     * 秒杀场次 删除场次
     * @param json
     * @return
     */
    ResponseMessage<Object> delScene(String json);

    /**
     * 秒杀场次 获取场次
     * @param json
     * @return
     */
    ResponseMessage<Object> getScene(String json);
}
