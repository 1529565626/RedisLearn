package com.example.demo.util.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 生成业务唯一进制码
 * </p>
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年1月18日 上午11:01:47
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
public abstract class GuidGeneratorUtil {

    /**
     * UUID 进制数
     *
     * @return
     */
    public static String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 6位随机数加上当前时间毫秒值
     *
     * @return String类型
     */
    public static String randomTime() {
        // 获取6为随机数
        int randomInt = (int) ((Math.random() * 9 + 1) * 100000);
        String randomStr = String.valueOf(randomInt);
        // 获取当前时间毫秒值
        Long millis = System.currentTimeMillis();
        randomStr = randomStr + millis.toString();
        return randomStr;
    }

    /**
     * 6位随机数加上当前时间毫秒值
     *
     * @return int类型
     */
    public static int randomSole() {
        // 获取6为随机数
        int randomint = (int) ((Math.random() * 9 + 1) * 100000);
        // 获取当前时间毫秒
        Calendar msel = Calendar.getInstance();
        int msec = msel.get(Calendar.MILLISECOND);
        // 6位随机数*1000+毫秒
        int randomInt = randomint * 1000;
        int randomsole = randomInt + msec;
        return randomsole;
    }

    /**
     * 获取6位随机数
     */
    public static int randomInt() {
        return (int) ((Math.random() * 9 + 1) * 100000);
    }

    /**
     * 生成指13位
     *
     * @param length 生成的位数
     * @return
     */
    public static String randomTimeLong() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String randomsole = machineId + String.format("%012d", hashCodeV);
        return randomsole;
    }

    public static String generateNumber(){
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        int machineId = 1;
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        String randomsole = machineId + String.format("%07d", hashCodeV);
        return randomsole;
    }


    /**
     * 获取当前月份
     */
    public static String monthTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }

    public static String random() {
        String word = "abcdefghijklmnopqrstuvwxyz";
        String tmp = "";
        for (int i = 0; i < 5; i++) {
            int rand = (int) (Math.random() * word.length());
            char c = word.charAt(rand);
            if (!tmp.contains(c + "")) {
                tmp += c;
            } else {
                i--;
            }
        }
        return tmp;
    }

}