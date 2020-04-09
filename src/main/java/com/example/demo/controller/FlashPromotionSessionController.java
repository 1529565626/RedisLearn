package com.example.demo.controller;


import com.example.demo.service.IFlashPromotionSessionService;
import com.example.demo.util.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 限时购场次表 前端控制器
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-23
 */
@RestController
@RequestMapping(value = "/jowim/flashPromotionSession", produces = AbstractUrl.PRODUCES)
public class FlashPromotionSessionController {

    @Resource
    IFlashPromotionSessionService flashPromotionSessionService;

    /**
     * 新增场次
     * @param json
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add_scene",method = RequestMethod.POST)
    public ResponseMessage<Object> addScene(@RequestBody String json) {
        return flashPromotionSessionService.addProduct(json);
    }

    /**
     * 修改场次
     * @param json
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/edit_scene",method = RequestMethod.POST)
    public ResponseMessage<Object> editScene(@RequestBody String json) {
        return flashPromotionSessionService.editScene(json);
    }

    /**
     * 修改启用状态
     * @param json
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update_status",method = RequestMethod.POST)
    public ResponseMessage<Object> updateStatus(@RequestBody String json, HttpServletRequest request) {
        return flashPromotionSessionService.updateStatus(json);
    }

    /**
     * 删除场次
     * @param json
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "del_scene",method = RequestMethod.POST)
    public ResponseMessage<Object> delScene(@RequestBody String json, HttpServletRequest request) {
        return flashPromotionSessionService.delScene(json);
    }

    /**
     * 获取场次信息
     * @param json
     * @return
     */
    @RequestMapping(value = "get_scene",method = RequestMethod.POST)
    public ResponseMessage<Object> getScene(@RequestBody String json) {
        return flashPromotionSessionService.getScene(json);
    }

    /**
     * 获取场次信息 列表
     * @param json
     * @return
     */
    @RequestMapping(value = "get_scene_list",method = RequestMethod.POST)
    public ResponseMessage<Object> getSceneList(@RequestBody String json) {
        return flashPromotionSessionService.getSceneList(json);
    }

    /**
     * 获取场次信息 可用列表
     * @param json
     * @return
     */
    @RequestMapping(value = "get_scene_select_list",method = RequestMethod.POST)
    public ResponseMessage<Object> getSceneSelectList(@RequestBody String json) {
        return flashPromotionSessionService.getSceneSelectList(json);
    }

}

