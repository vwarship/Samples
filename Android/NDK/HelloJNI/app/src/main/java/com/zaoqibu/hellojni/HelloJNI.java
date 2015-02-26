package com.zaoqibu.hellojni;

/**
 * Created by vwarship on 2015/2/27.
 */
public class HelloJNI {
    public native String  stringFromJNI();

    static {
        System.loadLibrary("hello-jni");
    }
}
