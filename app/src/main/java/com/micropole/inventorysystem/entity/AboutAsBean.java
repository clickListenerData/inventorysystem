package com.micropole.inventorysystem.entity;

/**
 * author: xiaoguagnfei
 * date: 2018/12/7
 * describe:
 */
public class AboutAsBean {

    /**
     * id : 1
     * title : 关于我们
     * content : <p style="text-align: left;">①可以自己在APP上上传头像<br/></p><p>②在首页工人以及工人列表页，排名靠前</p><p><br/></p><p><br/></p><p><br/></p>
     */

    private int id;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
