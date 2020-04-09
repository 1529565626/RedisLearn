package com.example.demo.util.htmlutil;

/**
 * HTML实体
 *
 * @author zhang@jowim.com
 * @version 1.1
 * @date 2019-8-7
 */
public class HtmlObject {
    /**
     * HTML路径
     */
    private String fileUrl;
    /**
     * HTML内容
     */
    private String content;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
