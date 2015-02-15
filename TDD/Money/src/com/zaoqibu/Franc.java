package com.zaoqibu;

/**
 * Created by vwarship on 2015/2/16.
 */
public class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(amount*multiplier);
    }
}
