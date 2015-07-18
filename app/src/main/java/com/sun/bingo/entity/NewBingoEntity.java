package com.sun.bingo.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by sunfusheng on 15/7/18.
 */
public class NewBingoEntity extends BmobObject {

    private String title;
    private String content;

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
