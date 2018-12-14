package com.micropole.inventorysystem.entity;

import java.util.List;

/**
 * @ClassName EvaluationListBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/14 10:55
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class EvaluationListBean {

    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }
}
