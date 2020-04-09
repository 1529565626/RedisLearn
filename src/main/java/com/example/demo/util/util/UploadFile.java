package com.example.demo.util.util;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 文件上传
 * </p>
 * ***********************************************
 * BECAUSE OF CHOICE, STICK TO IT.               *
 * ***********************************************
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年10月20日 17:09
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
public class UploadFile {

    /**
     * 传入进来，获取原文件的名称路径
     */
    private static final String INPUT_FILE = "inputFile";
    /**
     * 传出去，新的文件的名称（图片可用于直接拼接ip+端口号，已经处理反斜杠）
     */
    private static final String OUTPUT_FILE = "outputFile";
    /**
     * 储存绝对路径
     */
    private static final String FILE = "file";


    /**
     * 文件上传
     *
     * @param picture    流
     * @param request    http
     * @param folderName 文件夹名称
     * @param flag       是否在文件夹里根据日期“yyyyMMdd”分类 20181020
     * @return map ："inputFile"原文件名称  "inputFile"新文件路径（图片可用于直接拼接ip+端口号，已经处理反斜杠）  "inputFile"绝对路径
     */
    public static Map<String, String> uploadSingle(MultipartFile picture, HttpServletRequest request, String folderName, boolean flag) {
        Map<String, String> map = new HashMap<>();
        if (!picture.isEmpty()) {
            try {
                String outputFile = folderName;
                //获取存放路径
                File file = new File(new File(request.getSession().getServletContext().getRealPath("/")).getParent(), folderName);
                // 判断文件夹是否存在
                if (!file.exists()) {
                    // 不存在则创建
                    file.mkdir();
                }
                if (flag) {
                    //获取系统日期
                    String date = DateUtils.getDateFormat();
                    file = new File(file, date);
                    // 判断文件夹是否存在
                    if (!file.exists()) {
                        // 不存在则创建
                        file.mkdir();
                    }
                    outputFile = new File(folderName, date).toString();
                }
                // 生成新的名称
                String newName = GuidGeneratorUtil.generate();
                // 获取原文件的名称
                String oldName = picture.getOriginalFilename();
                // 新名称加上截取的后缀名
                String newFileName = newName + "." + oldName.substring(oldName.lastIndexOf(".") + 1);
                // 保存到路径下的文件夹
                File newFile = new File(file, newFileName);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                    picture.transferTo(newFile);
                    if (newFile.exists()) {
                        System.out.println("" + newFile);
                        map.put(INPUT_FILE, picture.getOriginalFilename());
                        map.put(OUTPUT_FILE, new File(outputFile, newFile.getName()).toString().replaceAll("\\\\", "/"));
                        map.put(FILE, newFile.toString());
                        return map;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return map;
            }
        }
        return map;
    }
}
