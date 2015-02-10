package com.zaoqibu.createservice;

/**
 * Created by vwarship on 2015/2/11.
 */
public class RunningAppProgress {
    private String name;
    private int icon;

    public RunningAppProgress(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

}
