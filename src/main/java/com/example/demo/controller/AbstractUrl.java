package com.example.demo.controller;

interface AbstractUrl {


    //编码格式
    String PRODUCES = "application/json;charset=UTF-8";


    /**
     * 用户表
     */
    String JOWIM_USER = "/jowim/user";

    /**
     * 发送验证码
     */
    String SEND_SMS = "/send_sms";
    /**
     * 绑定手机
     */
    String BIND_PHONE = "/bind_phone";
    /**
     * 修改会员信息
     */
    String USER_UPDATE = "/user_update";
    /**
     * 查看是否绑定手机号
     */
    String IS_BIND_PHONE = "/is_bind_phone";


    /*=========后台===================*/
    /**
     * 修改会员信息
     */
    String DELETE_USER_ACCOUNT = "/delete_user_account";
    /**
     * 修改一个会员信息
     */
    String UPDATE_USER_ACCOUNT = "/update_user_account";
    /**
     * 查詢會員詳情
     */
    String SELECT_BYID_USER_ACCOUNT = "/select_byId_user_account";
    /**
     * 查询所有会员信息
     */
    String SELECT_PAGE_LIST_USER_ACCOUNT = "/select_page_list_account";

    /**
     * 字典表
     */
    String DICTIONARIES_CONTROLLER = "/jowim/dictionaries";

    //获取全部接口
    String GET_ALL_DICTIONARIES = "/get_all_dictionaries";
    //递归抛出所有接口（包起来)
    String DIS_ALL_DICTIONARIES = "/dis_all_dictionaries";
    //（新）增加一个字典
    String ADD_DICTIONARIES = "/add_dictionaries";
    //(新)修改字典名称
    String UPDATE_DICTIONARIES = "/update_dictionaries";
    //(新)删除字典（只能删没有子节点的）
    String DELE_DICTIONARIES = "/dele_dictionaries";
    //（新）字典详情
    String SEARCH_DICTIONARIES = "/search_dictionaries";

    // 广告表
    String ADVERTISING_CONTROLLER = "/jowim/advertising";
    //发布广告
    String INSERT_ADVERTISING = "/insert_advertising";
    //广告列表
    String SELECT_ADVERTISING = "/select_advertising";
    // 广告详情
    String SELECT_ADVERTISING_BY_ID = "/select_advertising_by_id";
    //修改广告
    String UPDATE_ADVERTISING = "/update_advertising";
    //刪除广告
    String DELETE_ADVERTISING = "/delete_advertising";
    //广告前台
    String DESK_LIST = "/desk_list";
    //广告详情前台
    String DESK_INFO = "/desk_info";

    /**
     * 管理员表
     */
    String ADMIN_CONTROLLER = "/jowim/admin";
    //登录
    String LOGIN_ADMIN = "/login_admin";
    //添加管理员
    String INSERT_ADMIN = "/insert_admin";
    //修改密码
    String UPDATE_PASSWORD = "/update_password";
    //管理员详情
    String SELECT_ADMIN_BY_ID = "/select_admin_by_id";
    //查询管理员集合
    String SELECT_ADMIN = "/select_admin";
    //修改管理员
    String UPDATE_ADMIN = "/update_admin";
    //删除管理员
    String DELETE_ADMIN = "/delete_admin";

    /**
     * 文章表 控制层
     */
    String ARTICLE_CONTROLLER = "/jowim/article";
    //添加文章
    String INSERT_ARTICLE = "/insert_article";
    //删除文章
    String REMOVE_ARTICLED = "/remove_article";
    //查询文章(详情)
    String QUERY_ARTICLE = "/query_article";
    //分页
    String ARTICLE_PAGELIST = "/page_list";
    //文章修改
    String UPDATE_ARTICLE = "/update_article";
    //前台查询文章
    String QT_GET_ARTICLE = "/qt_get_article";
    //前台文章详情
    String ARTICLE_DESK_INFO = "/article_desk_info";
    //批量修改排序
    String CHANGE_SORT="/change_sort";

    /**
     * 站点管理
     */
    String JOWIM_SITE = "/jowim/site";
    /**
     * 修改一个站点
     */
    String UPDATE_SITE = "/upate_site";
    /**
     * 所有站点
     */
    String SELECT_LIST_SITE = "/select_List_site";
    /**
     * 详情
     */
    String SELECT_BY_ID_SITE = "/select_by_id";
    /**
     * 新增
     */
    String SITE_ADD = "/site_add";
    /**
     * 删除站点
     */
    String SITE_DEL = "/site_del";


    /**
     * 店铺表
     */
    String SHOP_CONTROLLER = "jowim/shop";
    //后台 用户自定义绑定店铺
    String USER_BIGDING_SHOP = "/user_bigding_shop";
    //后台 店铺审核列表
    String SHOP_AUDIT_LIST = "/list_audit_shop";
    //后台 店铺审核状态处理
    String SHOP_PASS_LIST = "/list_pass_shop";
    //后台 添加店铺
    String ADD_SHOP = "/add_shop";
    //后台 修改店铺
    String EDIT_SHOP = "/edit_shop";
    //后台 删除店铺
    String DEL_SHOP = "/del_shop";
    //后台 店铺列表
    String SHOP_LIST = "/list_shop";
    //后台 店铺详情
    String SHOP_PARTICULARS = "/particulars_shop";

    //代理商 添加店铺
    String AGENT_ADD_SHOP = "/agent_add_shop";
    //代理商 店铺列表
    String AGENT_SHOP_LIST = "/agent_list_shop";
    //代理商 店铺详情
    String AGENT_SHOP_PARTICULARS = "/agent_particulars_shop";
    //店铺 登录
    String SHOP_LOGIN = "/shop_login";
    //后台禁用店铺
    String SHOP_DOWN = "/down_shop";
    //后台启用店铺
    String SHOP_UPWN = "/upwn_shop";
    //店铺送礼给粉丝
    String OUT_USER_PRODUCT = "/out_user_product";
    //店铺送礼记录表
    String SHOP_GIVE_LIST = "/shop_give_list";
    //店铺统计
    String SHOP_COUNT_LIST = "/shop_count_list";
    //会员收礼仓冻结记录表
    String DONG_JIE_LIST = "/dongjie_list";
    //会员仓库产品解冻
    String JIEDONG = "/jiedong";



    /**
     * 代理商表
     */
    String AGENT_CONTROLLER = "jowim/agent";
    //后台 代理商审核列表
    String AGENT_AUDIT_LIST = "/list_audit_agent";
    //后台 代理商审核状态处理
    String AGENT_PASS_LIST = "/list_pass_agent";
    //后台 添加代理商
    String ADD_AGENT = "/add_agent";
    //后台 修改代理商
    String EDIT_AGENT = "/edit_agent";
    //后台 删除代理商
    String DEL_AGENT = "/del_agent";
    //后台 代理商列表
    String AGENT_LIST = "/list_agent";
    //后台 代理商详情
    String AGENT_PARTICULARS = "/particulars_agent";

    //代理商 添加代理商
    String AGENT_ADD_AGENT = "/agent_add_agent";
    //代理商 代理商列表
    String AGENT_AGENT_LIST = "/agent_list_agent";
    //代理商 代理商详情
    String AGENT_AGENT_PARTICULARS = "/agent_particulars_agent";
    //代理商 登录
    String AGENT_LOGIN = "/agent_login";


    /**
     * 产品标签表
     */
    String LABEL_CONTROLLER = "jowim/label";
    //后台 添加产品标签
    String ADD_LABEL = "/add_label";
    //后台 查询产品标签
    String SELECT_LABEL = "/select_label";
    //后台 修改产品标签
    String EDIT_LABEL = "/edit_label";
    //后台 删除产品标签
    String DEL_LABEL = "/del_label";
    //前台查询产品标签
    String GET_LABEL = "/get_label";
    //前台根据标签查询产品
    String GET_PRODUCT_BY_LABEL = "/get_product_by_label";



    /**
     * 产品表
     */
    String PRODUCT_CONTROLLER = "jowim/product";
    //店铺 添加产品
    String ADD_PRODUCT = "/add_product";
    //店铺 修改产品
    String EDIT_PRODUCT = "/edit_product";
    //店铺 删除产品
    String DEL_PRODUCT = "/del_product";
    //总后台 商品列表
    String ADMIN_PRODUCT_LIST = "/admin_product_list";
    //总后台 商品推送
    String PUSH_ADMIN_PRODUCT = "/push_admin_product";
    //店铺 产品列表
    String PRODUCT_LIST = "/list_product";
    //店铺 产品详情
    String PRODUCT_PARTICULARS = "/particulars_product";
    //产品图片转移正式文件夹接口
    String PRODUCT_IMAGE = "/image_product";
    //一键上架
    String UP_PRODUCT = "/up_product";
    //一键下架
    String DOWN_PRODUCT = "/down_product";
    //用户 根据关键字搜索商品
    String USER_SELECT_PRODUCT = "/user_select_product";
    //首页展示产品推送
    String SELECT_PRODUCT = "/select_product";
    //批量上架
    String UP_PRODUCT_BATCH = "/up_product_batch";
    //批量下架
    String DOWN_PRODUCT_BATCH = "/down_product_batch";
    //单件上架
    String UP_ONE_PRODUCT_BATCH = "/up_one_product_batch";
    //单件下架
    String DOWN_ONE_PRODUCT_BATCH = "/down_one_product_batch";
    //批量删除
    String DEL_PRODUCT_BATCH = "/del_product_batch";

    /**
     * 推送分类
     */
    String PUSH_TYPE_CONTROLLER = "jowim/push_type";
    //总后台 新增推送分类
    String ADD_PUSH_TYPE = "/add_push_type";
    //总后台 查询推送分类
    String SELECT_PUSH_TYPE = "/select_push_type";
    //总后台 修改推送分类
    String EDIT_PUSH_TYPE = "/edit_push_type";
    //总后台 删除推送分类
    String DEL_PUSH_TYPE = "/del_push_type";

    /**
     * 推送记录表
     */
    String PRODUCT_PUSH_CONTROLLER = "jowim/product_push";
    //总后台 商品推送记录列表
    String PUSH_ADMIN_PRODUCT_LIST = "/push_admin_product_list";
    //总后台 取消推送
    String OFF_PRODUCT_LIST = "/off_product_list";
    //总后台 修改推送排序
    String SORT_PRODUCT_LIST = "/sort_product_list";

    /**
     * 充值送礼表
     */
    String TOPUP_CONTROLLER = "jowim/top_up";
    //总后台 新增充值送礼
    String ADD_TOPUP = "/add_top_up";
    //总后台 查询充值送礼列表
    String SELECT_TOPUP = "/select_top_up";
    //总后台 修改充值送礼
    String EDIT_TOPUP = "/edit_top_up";
    //总后台 删除充值送礼
    String DEL_TOPUP = "/del_top_up";

    /**
     * 勋章表
     */
    String MEDAL_CONTROLLER = "jowim/medal";
    //总后台 新增勋章规则
    String ADD_MEDAL = "/add_medal";
    //总后台 查询勋章规则列表
    String SELECT_MEDAL = "/select_medal";
    //总后台 修改勋章规则
    String EDIT_MEDAL = "/edit_medal";
    //总后台 删除勋章规则
    String DEL_MEDAL = "/del_medal";

    /**
     * 支付明细表
     */
    String PAYLIST_CONTROLLER = "jowim/paylist";
    // 前台 支付明细
    String PAYLIST_QT = "/paylist_qt";
    // 后台 交易记录表
    String PAYLIST_WARM = "/paylist_warm";

    /**
     * 暖心币收益表
     */
    String WARM_MONEY_CONTROLLER = "jowim/warm_money";
    // 总后台 佣金收入记录表
    String ADMINRECORDWARM = "/admin_record_warm";
    // 代理商后台 代理商佣金收入记录表
    String AGENTRECORDWARM = "/agent_record_warm";
    // 店铺后台 佣金收入记录表
    String SHOPRECORDWARM = "/shop_record_warm";

    /**
     * 用户表
     */
    String USER_CONTROLLER = "jowim/user";
    //小程序登录
    String LOGIN_USER = "/login_user";
    //小程序位置授权
    String AUTHORIZED_ADDRESS = "/authorized_address";
    //完善用户信息
    String EDIT_USER = "/edit_user";
    //用户列表
    String USER_LIST = "/list_user";
    //用户详情
    String USER_PARTICULARS = "/particulars_user";
    //用户勋章详情
    String USER_MEDALS = "/medals_user";
    //会员签到
    String USER_SINGIN = "/user_singin";
    //用户 产品列表
    String USER_PRODUCT_LIST = "user_list_product";
    //用户 产品详情
    String USER_PRODUCT_PARTICULARS = "/user_particulars_product";
    //用户 店铺详情
    String USER_SHOP_PARTICULARS = "/user_particulars_shop";

    /**
     * 收藏表
     */
    String FAVORITE_CONTROLLER = "jowim/favorite";
    //添加收藏
    String FAVORITE_ADD = "/favorite_add";
    //取消收藏
    String FAVORITE_DEL = "/favorite_del";
    //查询此件商品是否被收藏
    String FAVORITE_SELECT = "/favorite_select";
    //收藏列表
    String FAVORITE_LIST = "/favorite_list";

    /**
     * 用户关注店铺
     */
    String CARE_CONTROLLER = "jowim/care";
    //添加关注
    String CARE_ADD = "/care_add";
    //取消关注
    String CARE_DEL = "/care_del";
    //关注列表
    String CARE_LIST = "/care_list";
    //店铺会员列表
    String SHOP_MEMBER_LIST = "/shop_member_list";
    //用户绑定上级店铺id
    String CUSTOM_CARE = "/custom_care";

    /**
     * 地址表
     */
    String ADDRESS_CONTROLLER = "jowim/address";
    //新增收货地址
    String ADD_USERADDRESS = "add_user_address";
    //编辑收货地址
    String EDIT_USERADDRESS = "/edit_user_address";
    //删除收货地址
    String DEL_USERADDRESS = "/del_user_address";
    //收货地址列表
    String LIST_USERADDRESS = "/list_user_address";
    //收货地址详情
    String USERADDRESS_PARTICULARS = "user_address_particulars";

    /**
     * 购买订单表
     */
    String BUYORDERS_CONTROLLER = "jowim/orders";
    //查询此用户是否是店铺会员
    String SELECT_BYORDER_ISVIP = "/select_buyorder_isvip";
    //添加购买订单
    String ADD_BUYORDER = "/add_buy_order";
    //平台订单购买列表
    String ADMINORDER_LIST = "/admin_orderlist";
    //店铺购买订单列表
    String SHOPORDERBUY_LIST = "/shop_orderbuylist";
    //客户购买订单列表
    String ORDER_LIST = "/order_list";
    //用户订单详情
    String ORDER_PARTICULARS = "/order_particulars";
    //暖心币支付 以及 余额支付
    String WARM_PAY_ORDER = "/warm_pay_order";
    //账户余额充值
    String RECHARGE = "/balance_recharge";
    //商品微信支付
    String WX_PAY = "/wx_payorder";
    //充值微信回调
    String SAVE_PAY = "/savepaymessage";
    //商品支付微信回调
    String PRODUCT_PAY = "/productpaymessage";
    //用户充值列表
    String RECHARGE_LIST = "/balance_rechargelist";
    //平台充值列表
    String ADMIN_RECHARGE_LIST = "/admin_balance_rechargelist";

    /**
     * 提现订单表
     */
    String ORDERS_CONTROLLER = "jowim/order";
    //提交兑换
    String ADD_ORDER = "/add_order";
    //提货数量不足时,补差价重新创建订单
    String ADD_BUY_ORDER_NOT = "/add_buy_order_not";
    //平台提现列表
    String ADMIN_ORDER_LIST = "/admin_orderlist";
    //店铺提现订单列表
    String SHOPORDER_LIST = "/shop_orderlist";
    //客户提现列表
    String ORDERS_LIST = "/orders_list";
    //用户提现订单详情
    String ORDERS_PARTICULARS = "/orders_particulars";
    //取消订单
    String CANCE_ORDER = "/cancel_order";
    //店铺后台发货
    String OUT_ORDER = "/out_order";
    //用户确认收货
    String IN_ORDER = "/in_order";
    //申请退款
    String APPLY_REFUND = "/apply_refund";
    //后台确认退款
    String AFF_REFUND = "/aff_refund";

    /**
     * 配置拥金表
     */
    String COMMISSION_CONTROLLER = "jowim/commission";
    //后台 查询抽成信息
    String SELECT_COMMISSION="/select_commission";
    //后台 修改抽成信息
    String EDIT_COMMISSION="/edit_commmission";

    /**
     * 新人送礼表
     */
    String NEWUSER_GIFT_CONTROLLER = "jowim/new_user_gift";
    //新增新人送礼产品
    String INSERT_NEWUSER_GIFT = "/insert_newuser_gift";
    //修改新人送礼产品
    String EDIT_NEWUSER_GIFT = "/edit_newuser_gift";
    //新人送礼产品 列表
    String SELECT_NEWUSER_GIFT = "/select_newuser_gift";
    //新人领取礼品
    String NEWUSER_GET_GIFT = "/newuser_get_gift";
    //平台 领取新人礼品列表
    String ADMIN_NEWUSER_GET_GIFT = "/admin_newuser_get_gift";
    //店铺 领取新人礼品列表
    String SHOP_NEWUSER_GET_GIFT = "/shop_newuser_get_gift";




     /**
     * 动态表
     */
    String JOWIM_DYNAMI = "/jowim/dynami";
    /**
     * 发布动态
     */
    String ISSUE_DYNAMI = "/issue_dynami";
    /**
     * 显示动态
     */
    String INIT_DUNAMI = "/init_dynami";
    /**
     * 初始化送礼仓
     */
    String INIT_GIVE_PRESEND = "/init_give_presend";
    /**
     * 送礼
     */
    String GIVE_PRESEND = "/give_presend";
    /**
     * 初始化社交数据
     */
    String INIT_SOCIAL = "/init_social";
    /**
     * 初始化收礼送礼排行榜
     */
    String INIT_GIFT = "/init_gift";
    /**
     * 评论动态
     */
    String SEND_COMMENT = "/send_comment";
    /**
     * 搜索用户
     */
    String SEARCH_USER = "/search_user";
    /**
     * 关注用户
     */
    String ATTENTION = "/attention";
    /**
     * 对评论进行评论
     */
    String DYNAMIC_FOR_SON = "/dynamic_for_son";
    /**
     * 查询用户的生日
     */
    String CHECK_BRITHDAY = "/check_brithday";
    /**
     * 初始化生日的好友的列表
     */
    String INIT_ALL_FRIENDS_BRITHDAY = "/init_all_friends_brithday";
    /**
     * 显示单条动态详情
     */
    String INIT_ONE_DY = "/init_one_dy";
    /**
     * 初始化收礼送礼记录表
     */
    String INIT_SEND_AND_PUT_GIFTS = "/init_send_and_gifts";
    /**
     * 送礼申请表
     */
    String APPLY_GIFTS = "/apply_gifts";
    /**
     * 初始化送礼申请表
     */
    String INIT_APPLY_GIFTS = "/init_apply_gifts";
    /**
     * 拒绝对方的送礼
     */
    String RETURN_GIFTS = "/return_gifts";
    /**
     * 同意对方送礼（新）
     */
    String GIVE_GIFTS_NEW = "/give_gifts_new";
    /**
     * 一键删除所有收礼记录
     */
    String DELETE_ALL_GIFTS_MSG = "/delete_all_gifts_msg";
    /**
     * 给好友添加备注信息
     */
    String ADD_REMARK_TO_FRIENDS = "/add_remark_to_friends";
    /**
     * 待条件的初始化自己的好友
     */
    String SEARCH_FRIENDS = "/search_frieds";
    /**
     * 待条件的初始化自己的好友
     */
    String SEARCH_ALL_USER = "/search_all_user";
    /**
     * 生成链接生成一个送礼申请表
     */
    String GIVE_GIFTS_AND_NOT_USERID = "/give_gifts_and_not_userid";
    /**
     * 新用户点击链接接收id然后收礼
     */
    String GET_USERID_AND_SHOULI = "/get_userid_and_shouli";
    /**
     * 新用户点击链接接收id然后拒绝收礼
     */
    String GET_USERID_AND_JUJUE = "/get_userid_and_jujue";
    /**
     * 删除一条自己的动态
     */
    String DELETE_DY_FOR_ME = "/delete_dy_for_me";
    /**
     * 取消关注
     */
    String QUXIAOGUANZHU = "/quxiaoguanzhu";
    /**
     * 取消关注
     */
    String DELETE_ONE_COMMENT = "/delete_one_comment";
    /**
     * 互相关注
     */
    String HUXIANGGUANZHU = "/huxiangguanzhu";
    /**
     * 互相关注
     */
    String CHECK_USER_GIFTS = "/check_user_gifts";



    /**
     * 换礼集市
     */
    String JOWIM_MARKET = "/jowim/market";
    /**
     * 初始化收礼送礼仓
     */
    String INIT_ALL_GIFTS = "/init_all_gifts";
    /**
     * 发布换礼物品
     */
    String PUT_GIFTTOMARKET = "/putGiftToMarket";
    /**
     * 初始化换礼集市缩略
     */
    String INIT_MARKET = "/init_market";
    /**
     * 初始化换礼集市详情
     */
    String INIT_DETAIL_MARKET = "/init_detail_market";
    /**
     * 换礼集市交换物品发起申请
     */
    String APPLY_EXCHANGE_GIFT = "/apply_exchange_gift";
    /**
     * 换礼集市交换物品
     */
    String EXCHANGE_GIFT = "/exchange_gift";
    /**
     * 初始化换礼请求表
     */
    String INIT_EXCHANGE = "/init_exchange";
    /**
     * 点开换礼申请表
     */
    String CLICK_APPLY_EXCHANGE = "/click_apply_exchange";
    /**
     * 在换礼集市中对物品进行评论
     */
    String COMMENT_FOR_MARKET = "/comment_for_market";
    /**
     * 根据名字搜索换礼集市的东西
     */
    String SEARCH_MARKET_FOR_NAME = "/search_market_for_name";
    /**
     * 撤销换礼集市的东西
     */
    String REVOCATION_MARKET = "/revocation_market";
    /**
     * 撤销换礼集市换礼的申请
     */
    String REVOCATION_APPLY_MARKET = "/revocation_apply_market";
    /**
     * 初始化用户在换礼集市上收到的一些申请
     */
    String INIT_ALL_APPLY_FROM_MARKET = "/init_all_apply_from_market";
    /**
      初始化换礼记录表
     */
    String INIT_MARKET_RECORD_TABLE = "/init_market_record_table";

    /**
     * 后台前缀
     */
    String MY_MGR = "/jowim/mymgr";
    /**
     * 初始化所有动态含评论
     */
    String INIT_ALL_DY = "/init_all_dy";
    /**
     * 删除一条动态
     */
    String DELETE_ONE_DY = "/delete_one_dy";
    /**
     * 删除一条动态下面的评论
     */
    String DELETE_ONE_DY_COMMENT = "/delete_one_dy_comment";
    /**
     * 审核动态
     */
    String SHENGHEDONGTAI = "/shenhedongtai";
    /**
     * 审核评论
     */
    String SHENGHEPINGLUN = "/shenhepinglun";
    /**
     * 初始化所有换礼集市
     */
    String SUOYOUHUANLIJISHI = "/suoyouhuanlijishi";
    /**
     * 审核所有集市
     */
    String SHENHESUOYOUJISHI = "/shenhesuoyoujishi";


}
