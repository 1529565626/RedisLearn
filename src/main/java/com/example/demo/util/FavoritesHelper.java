package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 常用类型转换与判断（判空）
 * </p>
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年1月16日 上午11:10:15
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
public class FavoritesHelper {
    protected  final static Logger LOG = LogManager.getLogger(FavoritesHelper.class);

    /**
     * 布尔类型判断
     *
     * @param ret 1：true，0：false
     * @return
     */
    public static boolean intChangeBoolean(int ret) {
        boolean b = false;
        if (ret >= 1) {
            b = true;
        }
        return b;
    }

    /**
     * 布尔类型判断
     *
     * @param ret
     * @return
     */
    public static boolean intChangeBoolean(int[] ret) {
        boolean b = true;
        for (int i = 0; i < ret.length; i++) {
            if (0 == ret[i]) {
                b = false;
                break;
            }
        }
        return b;
    }

    /**
     * 功能：判断字符串是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean isNull(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static String nullChangeString(String str) {
        String ret = "";
        if (null == str || "".equals(str) || "null".equals(str)) {
            str = "";
        }
        ret = str;
        return ret;
    }

    /**
     * 获取json的String结果
     *
     * @param json       json对象集合
     * @param paramsName 参数名称
     * @return
     */
    public static Object getJsonResuleByString(JSONObject json, String paramsName) {
        if (json.isEmpty()) {
            // json对象集合为空，则直接返回结果
            return "";
        }
        if (!isNotNull(paramsName)) {
            // 参数名称为空，则直接返回结果
            return "";
        }
        Object value = json.containsKey(paramsName) ? json.get(paramsName) : null;
        return value;
    }

    /**
     * 将空值转换为空格
     *
     * @param str
     * @return
     */
    public static String nullChangeSpace(String str) {
        String ret = "";
        if (null == str || "".equals(str) || "null".equals(str)) {
            str = "&nbsp;";
        }
        ret = str;
        return ret;
    }

    /**
     * 过滤字符串中的空格
     *
     * @param str
     * @return
     */
    public static String filterSpace(String str) {
        if (isNotNull(str)) {
            str.trim();
        }
        return str;
    }

    /**
     * 过滤过长字符
     *
     * @param str    需要被过滤的值
     * @param length 保留长度
     * @return
     */
    public static String fillterString(String str, int length) {
        String s = "";
        if (isNotNull(str)) {
            if (str.length() > length) {
                s = str.substring(0, length) + "...";
            } else {
                s = str;
            }
        }
        return s;
    }

    /**
     * 过滤过长字符
     *
     * @param str    需要被过滤的值
     * @param length 保留长度
     * @return
     */
    public static String fillterString2(String str, int length) {
        String s = "";
        if (isNotNull(str)) {
            if (str.length() > length) {
                s = str.substring(0, length) + "";
            } else {
                s = str;
            }
        }
        return s;
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotNull(String str) {
        boolean b = false;
        if (null != str && !"".equals(str) && !"null".equals(str)) {
            b = true;
        }
        return b;
    }


    /**
     * 判断字符串是否为空,也不为&nbsp;
     *
     * @param str
     * @return
     */
    public static boolean isNotNullNbsp(String str) {
        boolean b = false;
        if (null != str && !"".equals(str) && !"null".equals(str) && !"&nbsp;".equals(str)) {
            b = true;
        }
        return b;
    }

    /**
     * 判断是否为中文
     *
     * @param str
     * @return
     */
    public static boolean isCN(String str) {
        char[] chars = str.toCharArray();
        boolean isGB2312 = false;
        for (int i = 0; i < chars.length; i++) {
            byte[] bytes = ("" + chars[i]).getBytes();
            if (bytes.length == 2) {
                int[] ints = new int[2];
                ints[0] = bytes[0] & 0xff;
                ints[1] = bytes[1] & 0xff;
                if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40 && ints[1] <= 0xFE) {
                    isGB2312 = true;
                    break;
                }
            }
        }
        return isGB2312;
    }

    /**
     * sql语句查询条件中的特殊符号过滤
     *
     * @param validate_sql
     * @return
     */
    public static String changeValidateSQL(String validate_sql) {
        if (isNotNull(validate_sql)) {
            validate_sql = validate_sql.replace("$$and", " and ");
            validate_sql = validate_sql.replace("$$or", " or ");
            validate_sql = validate_sql.replace("$$notequal", " != ");
            validate_sql = validate_sql.replace("$$bigequal", " >= ");
            validate_sql = validate_sql.replace("$$smallequal", " <= ");
            validate_sql = validate_sql.replace("$$big", " > ");
            validate_sql = validate_sql.replace("$$small", " < ");
            validate_sql = validate_sql.replace("$$equal", " = ");
            validate_sql = validate_sql.replace("$$like", " like ");
            validate_sql = validate_sql.replace("$$wlike", " like ");
            validate_sql = validate_sql.replace("$$rlike", " like ");
            validate_sql = validate_sql.replace("$$nlike", " not like ");
            validate_sql = validate_sql.replace("$$notnull", " is not null ");
            validate_sql = validate_sql.replace("$$null", " is null ");
            validate_sql = validate_sql.replace("!@$and!@$", " and ");
            validate_sql = validate_sql.replace("!@$or!@$", " or ");
            validate_sql = validate_sql.replace("!!!", "'");
            validate_sql = validate_sql.replace("||", "%");
        } else {
            validate_sql = "";
        }
        return validate_sql;
    }

    /**
     * 将Blob转成String
     *
     * @param blob
     * @return
     */
    public static String getStringByBlob(Blob blob) {
        if (null == blob) {
            return "";
        }
        String str = "";
        try {
            InputStream ins = blob.getBinaryStream();
            int contentLength = (int) blob.length();
            byte[] ba = new byte[contentLength];
            ins.read(ba);
            str = new String(ba);
        } catch (IOException io) {
//            LOG.error(io.getMessage(), io);
        } catch (SQLException e) {
//            LOG.error(e.getMessage(), e);
        }
        return str;
    }

    /**
     * 将Clob转成String
     *
     * @param clob
     * @return
     */
    public static String getStringByBlob(Clob clob) {
        if (clob == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer(65535);// 64K
        Reader clobStream = null;
        try {
            clobStream = clob.getCharacterStream();
            char[] b = new char[60000];// 每次获取60K
            int i = 0;
            while ((i = clobStream.read(b)) != -1) {
                sb.append(b, 0, i);
            }
        } catch (Exception ex) {
            sb = null;
        } finally {
            try {
                if (clobStream != null)
                    clobStream.close();
            } catch (Exception e) {
            }
        }
        if (sb == null)
            return null;
        else
            return sb.toString();
    }

    /**
     * 大写转为小写
     *
     * @param str
     * @return
     */
    public static String changeDaToXiao(String str) {
        String txt = "";
        for (int i = 0; i < str.toCharArray().length; i++) {
            int ascii = str.charAt(i);
            if (ascii >= 65 && ascii <= 90) {
                txt += (char) (ascii + 32);
            } else {
                txt += str.toCharArray()[i];
            }
        }
        return txt;
    }

    /**
     * 小写转为大写
     *
     * @param str
     * @return
     */
    public static String changeXiaoToDa(String str) {
        if (!isNotNull(str)) {
            return "";
        }
        String txt = "";
        for (int i = 0; i < str.toCharArray().length; i++) {
            int ascii = str.charAt(i);
            if (ascii >= 97 && ascii <= 122) {
                txt += (char) (ascii - 32);
            } else {
                txt += str.toCharArray()[i];
            }
        }
        return txt;
    }

    /**
     * 字符型转为整型
     *
     * @param str
     * @return
     */
    public static int stringToint(String str) {
        int count = 0;
        if (isNotNull(str)) {
            str = str.trim();
            count = Integer.parseInt(str);
        }
        return count;
    }

    public static long stringTolong(String str) {
        long count = 0;
        if (isNotNull(str)) {
            str = str.trim();
            count = Long.parseLong(str);
        }
        return count;
    }

    /**
     * 将字符串（0,1）转为false，true
     *
     * @param str
     * @return
     */
    public static boolean stringToboolean(String str) {
        if ("1".equals(nullChangeString(str))) {
            return true;
        }
        return false;
    }

    public static String stringToNegativeString(String str) {
        if (isNotNull(str)) {
            if (Integer.parseInt(str) > 0) {
                str = "-" + str;
            }
        }
        return str;
    }

    /**
     * 字符型转为负整型
     *
     * @param str
     * @return
     */
    public static int intToNegativeInt(int count) {
        if (count > 0) {
            count = -count;
        }
        return count;
    }

    /**
     * 判断是否数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (isNotNull(str)) {
            for (int i = str.length(); --i >= 0; ) {
                int chr = str.charAt(i);
                if (chr < 48 || chr > 57)
                    return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 将数组转化成sql 的in查询 如：1,2,3,4,5 转化为 '1','2','3','4','5'
     *
     * @param str
     * @return
     */
    public static String getSQLInByStr(String[] str) {
        String params = "";
        if (null != str) {
            for (int i = 0; i < str.length; i++) {
                params += ",'" + str[i] + "'";
            }
        }

        if (!"".equals(params)) {
            params = params.substring(1);
        } else {
            params = "''";
        }
        return params;
    }

    /**
     * 将由“,”分割的字符串转化为in查询条件
     *
     * @param str
     * @return
     */
    public static String getSQLInByStrDouHao(String str) {
        String params = "";
        if (isNotNull(str)) {
            String[] strs = str.split(",");
            for (int i = 0; i < strs.length; i++) {
                params += ",'" + strs[i] + "'";
            }
            if (params.length() > 0) {
                params = params.substring(1);
            }
        } else {
            params = "''";
        }
        return params;
    }

    /**
     * 将字符串数组转为由“,”分隔的字符串 如 '123','345'
     *
     * @param str 字符串数组
     * @return 返回字符串拼凑值
     */
    public static String changeByStrDouHao(String[] str) {
        String params = "";
        if (null != str) {
            for (int i = 0; i < str.length; i++) {
                params += ",'" + str[i] + "'";
            }
            params = params.substring(1);
        }
        return params;
    }

    /**
     * 将整型数组转为字符串并用逗号分隔
     *
     * @param ret
     * @return
     */
    public static String changeIntsToString(int[] ret) {
        String value = "";
        if (null != ret) {
            for (int i = 0; i < ret.length; i++) {
                value += "," + ret[i];
            }
            value = value.substring(1);
        }
        return value;
    }

    /**
     * 将布尔类型转为0或1
     *
     * @param b
     * @return
     */
    public static String booleanToString(boolean b) {
        if (b) {
            return "1";
        }
        return "0";
    }

    /**
     * 获取具体操作类型的序列号
     *
     * @param actionTypes 操作类型集合
     * @param doType      操作类型
     * @return int index
     */
    public static int getActionTypeIndex(String[] actionTypes, String doType) {
        int index = -1;
        if (null == actionTypes) {
            return index;
        }
        doType = nullChangeString(doType);
        for (int i = 0; i < actionTypes.length; i++) {
            if (doType.equals(actionTypes[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 获取当前时间加上给定秒数的时间点 如 现在12:00:00 传入 1800 得到时间12:30:00
     *
     * @param second
     * @return 返回当前时间 和给出秒数后的时间
     */
    public static String[] getTimeBySecond(int second) {
        String[] timeAry = new String[2];
        Calendar cal = Calendar.getInstance();
        timeAry[0] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());// 获取到完整的时间
        cal.set(Calendar.MILLISECOND, second * 1000); // 把时间设置为当前时间给定秒数的时差
        timeAry[1] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());// 获取到完整的时间
        return timeAry;
    }

    /**
     * 比较当前时间与传入的时间字符串
     *
     * @param compareTime 比较时间字符串
     * @return 返回结果 true-当前时间早 | false-比较时间早
     * @throws ParseException
     */
    public static boolean compareNowTime(String compareTime) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = Calendar.getInstance().getTime(); // 当前时间
        Date compareDate = sdf.parse(compareTime); // 比较时间

        int result = nowDate.compareTo(compareDate);
        if (result < 0) { // 当前时间在比较时间前
            return true;
        } else if (result == 0) {
            return true;
        } else {
            return false;// 当前时间在比较时间后
        }
    }

    /**
     * 比较两个时间字符串哪个更后（第二个时间是否比第一个时间后）
     *
     * @param tagetTime 目标时间字符串
     * @param desTime   指定的时间字符串
     * @return boolean 返回结果 true-指定的时间比目标时间前 | false-指定的时间比目标时间后
     * @throws ParseException
     */
    public static boolean compareLaterTime(String tagetTime, String desTime) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date tagetDate = sdf.parse(tagetTime); // 目标时间
        Date desDate = sdf.parse(tagetTime); // 指定的时间
        int result = tagetDate.compareTo(desDate);
        if (result < 0) { // 指定的时间在目标时间后
            return true;
        } else if (result == 0) {
            return true;
        } else {
            return false;// 指定的时间在目标时间前
        }
    }

    /**
     * 判断对象为空
     *
     * @param obj 对象名
     * @return 是否为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)) {
            return ((String) obj).trim().equals("");
        }
        return false;
    }

    /**
     * 判断对象不为空
     *
     * @param obj 对象名
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}