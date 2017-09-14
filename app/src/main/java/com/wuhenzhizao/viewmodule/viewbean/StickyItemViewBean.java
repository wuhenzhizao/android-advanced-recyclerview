package com.wuhenzhizao.viewmodule.viewbean;

import com.wuhenzhizao.viewbean.StickyViewBean;

/**
 * Created by liufei on 2017/9/14.
 */

public class StickyItemViewBean extends StickyViewBean {
    private String title;
    private String name;
    private int stickyTheme;
    private boolean collect;

    public StickyItemViewBean(boolean isSticky) {
        super(isSticky);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStickyTheme() {
        return stickyTheme;
    }

    public void setStickyTheme(int stickyTheme) {
        this.stickyTheme = stickyTheme;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    @Override
    public String toString() {
        return "StickyItemViewBean{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", stickyTheme=" + stickyTheme +
                ", collect=" + collect +
                '}';
    }
}