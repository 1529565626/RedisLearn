package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.constant.ResultConstants;
import com.example.demo.entity.FlashPromotionSession;
import com.example.demo.mapper.FlashPromotionSessionMapper;
import com.example.demo.service.IFlashPromotionSessionService;
import com.example.demo.util.FavoritesHelper;
import com.example.demo.util.PageUtil;
import com.example.demo.util.ResponseMessage;
import com.example.demo.util.util.DateUtils;
import com.example.demo.util.util.GuidGeneratorUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 限时购场次表 服务实现类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-23
 */
@Service
public class FlashPromotionSessionServiceImpl extends ServiceImpl<FlashPromotionSessionMapper, FlashPromotionSession> implements IFlashPromotionSessionService {


    private boolean checkNull(FlashPromotionSession scene, String token){
        return FavoritesHelper.isNull(scene.getId()) || FavoritesHelper.isNull(scene.getName() )|| FavoritesHelper.isNull(scene.getStatus())
                || scene.getStartTime() == null || scene.getEndTime() == null ;
    }


    /**
     * 秒杀场次 新增
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> addProduct(String json) {
        //获取token
        String token = JSON.parseObject(json).getString("token");
        FlashPromotionSession scene = JSON.parseObject(json,FlashPromotionSession.class);
        String uuid = GuidGeneratorUtil.generate();
        scene.setId(uuid);
        //判断必填
        if (checkNull(scene,token)){
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }

//        String shopId = null;
//        //获取redis里的当前管理员信息
//        try {
//            shopId = iRedisCache.get(token + Constants.TOKEN);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (FavoritesHelper.isNull(shopId)) {
//            return ResponseMessage.error("请重新登录");
//        }

        scene.setCreateTime(DateUtils.now());
        scene.setDeleteFlag("0");
        if (baseMapper.insert(scene) != 1){
            return ResponseMessage.error("添加失败");
        }

        return ResponseMessage.ok(uuid);
    }

    /**
     * 秒杀场次 修改
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> editScene(String json) {
        //获取token
        String token = JSON.parseObject(json).getString("token");
        FlashPromotionSession scene = JSON.parseObject(json,FlashPromotionSession.class);
        //判断必填
        if (checkNull(scene,token)){
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }

//        String shopId = null;
//        //获取redis里的当前管理员信息
//        try {
//            shopId = iRedisCache.get(token + Constants.TOKEN);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (FavoritesHelper.isNull(shopId)) {
//            return ResponseMessage.error("请重新登录");
//        }

        if (baseMapper.updateById(scene) != 1) {
            return ResponseMessage.error("修改失败");
        }
        return ResponseMessage.ok(2,"修改成功");
    }

    /**
     * 秒杀场次 获取可选列表及其数量
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> getSceneSelectList(String json) {
        String token = JSON.parseObject(json).getString("token");
        //获取页码 页大小
        int page = JSON.parseObject(json).getIntValue("page");
        int pageSize = JSON.parseObject(json).getIntValue("pageSize");

//        String shopId = null;
//        //获取redis里的当前管理员信息
//        try {
//            shopId = iRedisCache.get(token + Constants.TOKEN);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (FavoritesHelper.isNull(shopId)) {
//            return ResponseMessage.error("请重新登录");
//        }

        //定义条件
        if (page == 0 || page == 1) {
            page = 1;
//            date = 0;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }
        PageUtil<FlashPromotionSession> pageInfo = new PageUtil<>(page,pageSize);
        List<FlashPromotionSession> sceneList = baseMapper.selectList(new EntityWrapper<FlashPromotionSession>().eq("delete_flag","0").eq("status","0"));
        //todo 需要查询相关联的商品设置如 同时可能需要新建DTO

        pageInfo.setRecords(sceneList);
        return ResponseMessage.ok(pageInfo);
    }

    /**
     * 秒杀场次 获取列表
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> getSceneList(String json) {
        String token = JSON.parseObject(json).getString("token");
        //获取页码 页大小
        int page = JSON.parseObject(json).getIntValue("page");
        int pageSize = JSON.parseObject(json).getIntValue("pageSize");

//        String shopId = null;
//        //获取redis里的当前管理员信息
//        try {
//            shopId = iRedisCache.get(token + Constants.TOKEN);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (FavoritesHelper.isNull(shopId)) {
//            return ResponseMessage.error("请重新登录");
//        }

        //定义条件
        if (page == 0 || page == 1) {
            page = 1;
//            date = 0;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }
        PageUtil<FlashPromotionSession> pageInfo = new PageUtil<>(page,pageSize);
        List<FlashPromotionSession> sceneList = baseMapper.selectList(new EntityWrapper<FlashPromotionSession>().eq("delete_flag","0"));
        pageInfo.setRecords(sceneList);
        return ResponseMessage.ok(pageInfo);
    }

    /**
     * 秒杀场次 更新场次启用状态
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> updateStatus(String json) {
        //获取token
        String token = JSON.parseObject(json).getString("token");
        String sceneId = JSON.parseObject(json).getString("sceneId");
        String status = JSON.parseObject(json).getString("status");
        //判断必填
        if (FavoritesHelper.isNull(sceneId) || FavoritesHelper.isNull(status) || FavoritesHelper.isNull(token)){
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }

//        String shopId = null;
//        //获取redis里的当前管理员信息
//        try {
//            shopId = iRedisCache.get(token + Constants.TOKEN);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (FavoritesHelper.isNull(shopId)) {
//            return ResponseMessage.error("请重新登录");
//        }

        FlashPromotionSession scene = baseMapper.selectById(new EntityWrapper<FlashPromotionSession>().eq("id",sceneId).eq("delete_flag","0"));
        if (scene.getStatus() == status) {
            return ResponseMessage.error("修改状态异常");
        }

        FlashPromotionSession newScene = new FlashPromotionSession();
        newScene.setId(sceneId);
        newScene.setStatus(status);
        if (baseMapper.updateById(newScene) != 1) {
            return ResponseMessage.error("修改失败");
        }
        return ResponseMessage.ok(2,"修改成功");
    }

    /**
     * 秒杀场次 删除场次
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> delScene(String json) {
        //获取token
        String token = JSON.parseObject(json).getString("token");
        String sceneId = JSON.parseObject(json).getString("sceneId");
        //判断必填
        if (FavoritesHelper.isNull(sceneId) || FavoritesHelper.isNull(token)){
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }

//        String shopId = null;
//        //获取redis里的当前管理员信息
//        try {
//            shopId = iRedisCache.get(token + Constants.TOKEN);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (FavoritesHelper.isNull(shopId)) {
//            return ResponseMessage.error("请重新登录");
//        }

        FlashPromotionSession scene = baseMapper.selectById(new EntityWrapper<FlashPromotionSession>().eq("id",sceneId).eq("delete_flag","0"));
        if (scene == null) {
            return ResponseMessage.error("删除异常,场次不存在");
        }

        FlashPromotionSession newScene = new FlashPromotionSession();
        newScene.setId(sceneId);
        newScene.setDeleteFlag("1");
        if (baseMapper.updateById(newScene) != 1) {
            return ResponseMessage.error("删除失败");
        }
        return ResponseMessage.ok(2,"删除成功");
    }

    /**
     * 秒杀场次 获取场次
     *
     * @param json
     * @return
     */
    @Override
    public ResponseMessage<Object> getScene(String json) {
        //获取token
        String token = JSON.parseObject(json).getString("token");
        String sceneId = JSON.parseObject(json).getString("sceneId");
        //判断必填
        if (FavoritesHelper.isNull(sceneId) || FavoritesHelper.isNull(token)){
            return ResponseMessage.error(ResultConstants.RESULT_NULL);
        }

//        String shopId = null;
//        //获取redis里的当前管理员信息
//        try {
//            shopId = iRedisCache.get(token + Constants.TOKEN);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (FavoritesHelper.isNull(shopId)) {
//            return ResponseMessage.error("请重新登录");
//        }

        FlashPromotionSession scene = baseMapper.selectById(new EntityWrapper<FlashPromotionSession>().eq("id",sceneId).eq("delete_flag","0"));
        if (scene == null) {
            return ResponseMessage.error("场次不存在");
        }
        return ResponseMessage.ok(scene);
    }
}
