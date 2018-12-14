package com.micropole.inventorysystem.entity;

/**
 * @ClassName LogisticsBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/12/14 16:51
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class LogisticsBean {


    /**
     * time : 2018-12-14 01:29:35
     * ftime : 2018-12-14 01:29:35
     * context : 【绍兴市】 快件到达 【绍兴中转部】
     * location :
     */

    private String time;
    private String ftime;
    private String context;
    private String location;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
