package com.zaoqibu;

/**
 * Created by vwarship on 2015/2/15.
 */
public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
    }
    
    public Dollar times(int multiplier) {
        return new Dollar(amount*multiplier);
    }
}
