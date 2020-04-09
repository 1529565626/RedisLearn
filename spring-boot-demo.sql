/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 127.0.0.1:3306
 Source Schema         : spring-boot-demo

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 09/04/2020 18:41:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buy_order
-- ----------------------------
DROP TABLE IF EXISTS `buy_order`;
CREATE TABLE `buy_order`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `amount` decimal(20, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buy_order
-- ----------------------------
INSERT INTO `buy_order` VALUES ('10b3511229aa48a99f4a937813bdbb76', '995261ca986d4bc9b3f68f9070b183b4', 1000.00);
INSERT INTO `buy_order` VALUES ('45da798578504e2a81bc63bc46680a', '995261ca986d4bc9b3f68f9070b183b4', 1000.00);
INSERT INTO `buy_order` VALUES ('49cfba1b18e34a7c9bb2411fb4bfbada', '995261ca986d4bc9b3f68f9070b183b4', 1000.00);
INSERT INTO `buy_order` VALUES ('5fe6e5c63b7d4dc88b422047d3a4742c', '995261ca986d4bc9b3f68f9070b183b4', 1000.00);
INSERT INTO `buy_order` VALUES ('5feb01322e344fbb80cff8948bbadd26', '995261ca986d4bc9b3f68f9070b183b4', 1000.00);
INSERT INTO `buy_order` VALUES ('b127fd2061b9484c86001f7e047b6738', '995261ca986d4bc9b3f68f9070b183b4', 1000.00);
INSERT INTO `buy_order` VALUES ('c7eea1fbdfac441380b90bf6fb113f', 'c7eea1fbdfac441380b90bf6fb113f', 100.00);
INSERT INTO `buy_order` VALUES ('f2dacd96ad9b492583eab6ee61c0d918', '995261ca986d4bc9b3f68f9070b183b4', 1000.00);

-- ----------------------------
-- Table structure for flash_promotion_session
-- ----------------------------
DROP TABLE IF EXISTS `flash_promotion_session`;
CREATE TABLE `flash_promotion_session`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '场次名称',
  `start_time` time(0) NULL DEFAULT NULL COMMENT '每日开始时间',
  `end_time` time(0) NULL DEFAULT NULL COMMENT '每日结束时间',
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '启用状态：0->启用；1->不启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `delete_flag` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '\'0\'未删除;\'1\'删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '限时购场次表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `product_shop_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品绑定店铺',
  `product_type_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品绑定类型',
  `product_cover` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品缩略图(主图)',
  `product_images` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品展示图片 最多5张',
  `product_label` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品标签',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `product_keyword` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品关键字 最多60字符',
  `product_coding` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品编码',
  `product_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品描述',
  `product_range_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品价格区间',
  `product_old_price` decimal(20, 2) NULL DEFAULT 0.00 COMMENT '产品原价',
  `product_now_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '产品现价',
  `product_vip_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '产品会员价',
  `product_nuan_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否使用暖心币兑换 0是 1否',
  `product_nuan_price` bigint(20) NULL DEFAULT NULL COMMENT '产品暖心币兑换值',
  `product_sales_number` bigint(20) NULL DEFAULT 0 COMMENT '产品销售量',
  `product_inventory` bigint(20) NULL DEFAULT NULL COMMENT '产品总库存',
  `product_use_attr` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否使用规格 0使用 1不使用',
  `product_attr` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品规格',
  `product_price_stocks` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品价格+库存',
  `product_standard_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有提现标准 0有 1没有',
  `product_standard_num` int(9) NULL DEFAULT 0 COMMENT '达到多少数量才可提现',
  `product_details` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品详情页',
  `product_putaway_time` bigint(20) NULL DEFAULT NULL COMMENT '产品上架时间',
  `product_create_time` bigint(20) NULL DEFAULT NULL COMMENT '产品创建时间',
  `product_evaluate_number` bigint(20) NULL DEFAULT 0 COMMENT '产品评价数量',
  `product_push` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '首页推送  0推送 1不推送',
  `product_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '产品状态 0上架 1下架(入库)  2送礼仓',
  `product_delete_flag` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '产品删除状态 0正常 1删除',
  `product_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('0777917f29914b1eb57b51884de24345', '产品绑定店铺', '1003040104', '产品缩略图', '产品展示图片', '产品标签', '产品名称', '产品关键字', 'M-J01', '产品描述', '1000', 1000.00, 1000.00, 999.00, '1', NULL, 0, 100, '0', '产品规格', '产品价格+库存', '1', 0, '产品详情页', 1584758147827, 1584758147827, 0, '1', '0', '0', NULL);
INSERT INTO `product` VALUES ('995261ca986d4bc9b3f68f9070b183b4', '产品绑定店铺修改版', '1003040104', '产品缩略图修改版', '产品展示图片修改版', '产品标签修改版', '产品名称修改版', '产品关键字修改版', 'M-J01', '产品描述修改版', '1000', 1000.00, 1000.00, 999.00, '1', NULL, 0, 98, '0', '产品规格修改版', '产品价格+库存修改版', '1', 0, '产品详情页修改版', 1584780439384, 1584762288590, 0, '1', '0', '0', NULL);

-- ----------------------------
-- Table structure for product_attribute
-- ----------------------------
DROP TABLE IF EXISTS `product_attribute`;
CREATE TABLE `product_attribute`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_attribute_category_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品属性类型id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名',
  `select_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性选择类型：0->唯一；1->单选；2->多选',
  `input_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
  `input_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可选值列表，以逗号隔开',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序字段：最高的可以单独上传图片',
  `filter_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类筛选样式：1->普通；1->颜色',
  `search_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
  `related_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相同属性产品是否关联；0->不关联；1->关联',
  `hand_add_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否支持手动新增；0->不支持；1->支持',
  `type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性的类型；0->规格；1->参数',
  `attribute_delete_flag` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '属性的删除状态；0->未删除；1->删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_attribute
-- ----------------------------
INSERT INTO `product_attribute` VALUES ('114538706ff9489b8530d0cbecca6f61', '86828a6970d64cd1a2c15b16ba782092', '颜色', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '0', '0');
INSERT INTO `product_attribute` VALUES ('3a582da4f19d4678a95c50e8eb3b4c5f', '86828a6970d64cd1a2c15b16ba782092', '删除颜色测试1', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '0', '1');
INSERT INTO `product_attribute` VALUES ('4bb46503fad8403ea2e3aa4055d52b70', '86828a6970d64cd1a2c15b16ba782092', '颜色', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '0', '0');
INSERT INTO `product_attribute` VALUES ('4c91613fd79c4b6d8897049e83b206d2', '76b47f94d54a41fbac5f2103f306b70e', '尺寸', '2', ' 1', 'M,X,XL,2XL,3XL,4XL', 100, ' 0', '0', '0', '0', '0', '0');
INSERT INTO `product_attribute` VALUES ('4f7fb2042988448687487683cbc19e8b', '86828a6970d64cd1a2c15b16ba782092', '删除颜色测试2', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '0', '1');
INSERT INTO `product_attribute` VALUES ('53b609543275418f945cb002c3a3a70c', '86828a6970d64cd1a2c15b16ba782092', '删除颜色测试single', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '0', '1');
INSERT INTO `product_attribute` VALUES ('7a52fe5541464ecbb56846ae4f8ff06a', '86828a6970d64cd1a2c15b16ba782092', '删除颜色测试single', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '1', '0');
INSERT INTO `product_attribute` VALUES ('834b54240cb6412796e72746420c5884', '86828a6970d64cd1a2c15b16ba782092', '删除颜色测试3', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '0', '1');
INSERT INTO `product_attribute` VALUES ('c27d7426503f448da491a57e9fd235d8', '86828a6970d64cd1a2c15b16ba782092', '色彩颜色', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '0', '1');
INSERT INTO `product_attribute` VALUES ('cb1253e3c3854a28a391025b73abdd60', '86828a6970d64cd1a2c15b16ba782092', '奢侈颜色', '2', ' 1', '黑色,红色,白色,粉色', 100, ' 0', '0', '0', '1', '0', '1');

-- ----------------------------
-- Table structure for product_attribute_category
-- ----------------------------
DROP TABLE IF EXISTS `product_attribute_category`;
CREATE TABLE `product_attribute_category`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attribute_count` int(11) NULL DEFAULT 0 COMMENT '属性数量',
  `param_count` int(11) NULL DEFAULT 0 COMMENT '参数数量',
  `category_delete_flag` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '类型删除状态 0正常 1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品属性分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_attribute_category
-- ----------------------------
INSERT INTO `product_attribute_category` VALUES ('76b47f94d54a41fbac5f2103f306b70e', '服装-牛仔裤', 1, 0, '0');
INSERT INTO `product_attribute_category` VALUES ('86828a6970d64cd1a2c15b16ba782092', '服装-T恤', 2, 1, '0');
INSERT INTO `product_attribute_category` VALUES ('dbf5432efeae41f09d394e0e3656540f', '服装-夹克衫', 0, 0, '1');

-- ----------------------------
-- Table structure for product_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `product_attribute_value`;
CREATE TABLE `product_attribute_value`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_attribute_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '存储产品参数信息的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_attribute_value
-- ----------------------------
INSERT INTO `product_attribute_value` VALUES ('2423067602ec4dc48a2962d33e33d543', '995261ca986d4bc9b3f68f9070b183b4', '114538706ff9489b8530d0cbecca6f61', '删除修改版');
INSERT INTO `product_attribute_value` VALUES ('b4c5d8bc9d664bbe9f219c2359ddf69d', '995261ca986d4bc9b3f68f9070b183b4', '114538706ff9489b8530d0cbecca6f61', '五彩斑斓的黑修改版,死亡芭比粉');
INSERT INTO `product_attribute_value` VALUES ('c202f67f5cf647d68ba0df2f6ad96152', '995261ca986d4bc9b3f68f9070b183b4', '4bb46503fad8403ea2e3aa4055d52b70', 'HLZJBX修改版');
INSERT INTO `product_attribute_value` VALUES ('d1f3de221db148e981f1972fb42e8de7', '995261ca986d4bc9b3f68f9070b183b4', '4c91613fd79c4b6d8897049e83b206d2', '夏季修改版');

-- ----------------------------
-- Table structure for sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `sku_stock`;
CREATE TABLE `sku_stock`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sku_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku编码',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `stock` int(11) NULL DEFAULT 0 COMMENT '库存',
  `low_stock` int(11) NULL DEFAULT NULL COMMENT '预警库存',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示图片',
  `sale` int(11) NULL DEFAULT NULL COMMENT '销量',
  `promotion_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单品促销价格',
  `lock_stock` int(11) NULL DEFAULT 0 COMMENT '锁定库存',
  `sp_data` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性，json格式',
  `creat_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'sku的库存' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_stock
-- ----------------------------
INSERT INTO `sku_stock` VALUES ('13d5b00b1dbd42429e401f8a48e0cd63', '995261ca986d4bc9b3f68f9070b183b4', '1584780439384008', 99.00, 10, NULL, NULL, NULL, NULL, 0, '[{\"value\":\"五彩斑斓的黑修改版\",\"key\":\"颜色修改版\"},{\"value\":\"L\",\"key\":\"尺寸\"}]', '2020-03-21 16:47:19');
INSERT INTO `sku_stock` VALUES ('3ac0b3ead2c5497a98a7d490e71670b0', '995261ca986d4bc9b3f68f9070b183b4', '1584780439384006', 99.00, 10, NULL, NULL, NULL, NULL, 0, '[{\"value\":\"死亡芭比粉修改版\",\"key\":\"颜色修改版\"},{\"value\":\"M\",\"key\":\"尺寸\"}]', '2020-03-21 16:47:19');
INSERT INTO `sku_stock` VALUES ('43aed700a55f422fb1bb50ae4eca1145', '995261ca986d4bc9b3f68f9070b183b4', '1584780439384007', 99.00, 10, NULL, NULL, NULL, NULL, 0, '[{\"value\":\"死亡芭比粉修改版\",\"key\":\"颜色修改版\"},{\"value\":\"X\",\"key\":\"尺寸\"}]', '2020-03-21 16:47:19');
INSERT INTO `sku_stock` VALUES ('518d6b1fb78d4aa090a28fbd7eb2c4c5', '995261ca986d4bc9b3f68f9070b183b4', '1584780439384003', 99.00, 10, NULL, NULL, NULL, NULL, 0, '[{\"value\":\"死亡芭比粉修改版\",\"key\":\"颜色修改版\"},{\"value\":\"L\",\"key\":\"尺寸\"}]', '2020-03-21 16:47:19');
INSERT INTO `sku_stock` VALUES ('8bedae6f45df4f32838248a9ed115563', '995261ca986d4bc9b3f68f9070b183b4', '1584780439384005', 99.00, 10, NULL, NULL, NULL, NULL, 0, '[{\"value\":\"五彩斑斓的黑修改版\",\"key\":\"颜色修改版\"},{\"value\":\"2XL\",\"key\":\"尺寸\"}]', '2020-03-21 16:47:19');
INSERT INTO `sku_stock` VALUES ('a8ef6e9cec2a4e2c8b0f54e6481e8bdd', '995261ca986d4bc9b3f68f9070b183b4', '1584780439384002', 99.00, 10, NULL, NULL, NULL, NULL, 0, '[{\"value\":\"五彩斑斓的黑修改版\",\"key\":\"颜色修改版\"},{\"value\":\"X\",\"key\":\"尺寸\"}]', '2020-03-21 16:47:19');
INSERT INTO `sku_stock` VALUES ('c3159db3fb9c4f21b0afea21bfbeb3ae', '995261ca986d4bc9b3f68f9070b183b4', '1584780439384004', 99.00, 10, NULL, NULL, NULL, NULL, 0, '[{\"value\":\"死亡芭比粉修改版\",\"key\":\"颜色修改版\"},{\"value\":\"2XL\",\"key\":\"尺寸\"}]', '2020-03-21 16:47:19');
INSERT INTO `sku_stock` VALUES ('f9d5cafaeef5442bb484888d5303bc5f', '995261ca986d4bc9b3f68f9070b183b4', '1584780439384001', 99.00, 10, NULL, NULL, NULL, NULL, 0, '[{\"value\":\"五彩斑斓的黑修改版\",\"key\":\"颜色修改版\"},{\"value\":\"M\",\"key\":\"尺寸\"}]', '2020-03-21 16:47:19');

SET FOREIGN_KEY_CHECKS = 1;
