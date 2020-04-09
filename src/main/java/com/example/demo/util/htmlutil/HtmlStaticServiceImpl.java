package com.example.demo.util.htmlutil;

/**
 * 不能测试的一个类
 * <p>
 * 示范impl
 */
@Deprecated
public class HtmlStaticServiceImpl {

//    @Autowired
//    private com.glxcn.module.o7xz.tagLabel.service.tagLabelService tagLabelService;
//
//    @Autowired
//    private INewCategoryService newCategoryService;
//
//    @Autowired
//    private com.glxcn.module.o7xz.topic.service.topicService topicService;
//
//    @Autowired
//    private SeoService seoService;
//
//    @Autowired
//    private BeetlHtmlUtil beetlHtmlUtil;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    @Autowired
//    private AppManagerService appManagerService;
//    @Autowired
//    private TO7xzAppcategoryMapper tO7xzAppcategoryMapper;
//
//    @Autowired
//    private AdvertService advertService;
//
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private NewsService newService;
//
//    @Autowired
//    private Linkservice linkservice;
//    @Value("${ctxPath}")
//    private String ctxPath;
//
//    @Autowired
//    private SeoService seoservice;
//
//    /**
//     * 生成首页
//     *
//     * @param siteId
//     */
//    @Override
//    public void index(Integer siteId) {
//       /* TCmsSite site = siteService.findById(siteId);
//        Map attr = Maps.newHashMap();
//        attr.put("title",site.getTitle());
//        attr.put("keyword",site.getKeyword());
//        attr.put("description",site.getDescription());
//        attr.put("site",site);
//        beetlHtmlUtil.create(siteId,"index",attr,(StrUtil.isBlank(site.getTemplate())?"default":site.getTemplate()),CmsConst.INDEX_TPL);
//      */
//    }
//
//
//    /**
//     * 生成App详情静态页面
//     *
//     * @param id
//     */
//    @Override
//    public void appInfo(long categoryId, String id) {
//        Map attr = Maps.newHashMap();
//
//
//        //软件详情
//        AppInfoVo appInfoVo = appManagerService.selectAppInfoVo(id);
//        attr.put("appInfo", appInfoVo);
//        //获取app类别
//        String remark = appInfoVo.getApp().getRemark();
//        //服务器路径
//        attr.put("ctxPath", ctxPath);
//        //推荐下载
//        List<TO7xzApp> recommendList = appManagerService.findListByRecommend();
//        attr.put("recommendList", recommendList);
//        //软件资讯
//        List<TO7xzNews> list = newService.selectTen();
//        attr.put("newsList", list);
//        //首页幻灯片
//        attr.put("advlist", advertService.findAllIndex());
//        //首页横幅广告
//        attr.put("advlist1", advertService.findAllSide());
//        //footer页面数据
//        List<FriendVo> lists = new ArrayList<FriendVo>();
//        List<TModLink> list2 = new ArrayList<TModLink>();
//        List<TModLink> list1 = linkservice.softselByproperty();
//        for (TModLink friend : list1) {
//            FriendVo vo = new FriendVo();
//            String property = friend.getProperty();
//            vo.setFriendClass(property);
//            //电影下面的详情
//            vo.setFriendInfo(linkservice.selAllByproperty(property, "软件链接"));
//            lists.add(vo);
//        }
//        attr.put("lists", lists);
//        attr.put("list3", advertService.findDetailside());
//        //软件详情幻灯片
//        attr.put("list4", advertService.findSoftDetail());
//        attr.put("solist1", advertService.findAllsoftIndex());
//        attr.put("solist2", advertService.findAllsoftside());
//
//
//        //游戏侧边
//        attr.put("gmlist2", advertService.findAllGameside());
//
//        //游戏幻灯片
//        attr.put("gmlist", advertService.findAllGameIndex());
//        //游戏攻略通过名字模糊查询
//        List<TO7xzNews> gameStrategieByName = newService.findGameStrategieByName(appInfoVo.getApp().getAppName());
//        attr.put("gameStrategieByName", gameStrategieByName);
//        //返回标签
//        List<TO7xzTaglabel> tagLabelNameList = tagLabelService.findTagLabelName();
//        attr.put("tagLabelNameList", tagLabelNameList);
//        //查询六条最新tag标签
//        List<TO7xzTaglabel> tagLabelNameListSix = tagLabelService.findTagLabelNameSix();
//        attr.put("tagLabelNameListSix", tagLabelNameListSix);
//        String ids = String.valueOf(id);
//        //截取ids
//        //String ids2=ids.substring(ids.length()-6,ids.length());
//        if (categoryId == 186L) {
//            //beetlHtmlUtil.create( remark + File.separator + id, attr, "o7xza", "softwareInfo");
//            beetlHtmlUtil.create("soft" + File.separator + id, attr, "o7xza", "softwareInfo");
//        } else {
//            //beetlHtmlUtil.create( remark + File.separator + id, attr, "o7xza", "softwareInfo");
//            beetlHtmlUtil.create("game" + File.separator + id, attr, "o7xza", "softwareInfo");
//        }
//    }
}
