package com.example.demo;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * MP 反编译数据库
 * </p>
 * ***********************************************
 * BECAUSE OF CHOICE, STICK TO IT.               *
 * ***********************************************
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年06月05日 15:57
 * @see MpGenerator (c) 2018 泉州卓旻网络科技有限公司
 */
public class MpGenerator {

    //jdbc 连接
//    private static final String URL = "jdbc:mysql://121.204.206.25/";
    private static final String URL = "jdbc:mysql://localhost/";
    //库名
    private static final String DATA_BASE_NAME = "spring-boot-demo";
    //帐号
    private static final String USERNAME = "root";
    //密码
    private static final String PASSWORD = "Aa@111111";
    //路径
    private static final String FINL = "F://";

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(FINL + DATA_BASE_NAME);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("Zhang@Jowim.com");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
//        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
//        dsc.setUrl(URL + DATA_BASE_NAME + "?characterEncoding=utf8");
        dsc.setUrl(URL + DATA_BASE_NAME + "?useUnicode=true&characterEncoding=utf-8&useSSL=FALSE&serverTimezone=UTC");
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
//        strategy.setTablePrefix(new String[] { "jowim_", "_" });// 此处可以修改为您的表前缀
        strategy.setInclude(new String[] { "product_attribute"}); // 需要生成的表
//        strategy.setInclude(new String[] { rb.getString("tableName")}); // 需要生成的表
//        strategy.setExclude(new String[]{"test"}); // 排除生成的表
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com");
        pc.setModuleName("demo");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }
}
