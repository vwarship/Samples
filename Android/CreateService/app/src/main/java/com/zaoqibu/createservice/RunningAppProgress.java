package com.zaoqibu.createservice;

import android.graphics.drawable.Drawable;

/**
 * Created by vwarship on 2015/2/11.
 */
public class RunningAppProgress {
    private String name;
    private Drawable icon;

    public RunningAppProgress(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }

}
