package com.zaoqibu;

/**
 * Created by vwarship on 2015/2/15.
 */
public class Dollar {
    private int n;
    private int amount;

    public Dollar(int n) {
        this.n = n;
    }
    
    public void times(int x) {
        amount = n * x;
    }

    public int getAmount() {
        return amount;
    }
}
