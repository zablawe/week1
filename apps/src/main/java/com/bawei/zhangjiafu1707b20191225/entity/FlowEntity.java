package com.bawei.zhangjiafu1707b20191225.entity;

import java.util.List;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class FlowEntity {

    /**
     * msg : 响应成功
     * code : 200
     * tags : ["手机壁纸","手机app","手机cpu天梯图","手机号码测吉凶","手机新浪网","手机号码测吉凶(超准)","手机电影","手机在线","手机排名","小米手机"]
     */

    private String msg;
    private int code;
    private List<String> tags;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
