package com.zaoqibu;

/**
 * Created by vwarship on 2015/2/16.
 */
public class Money {
    protected int amount;

    @Override
    public boolean equals(Object obj) {
        Money money = (Money)obj;
        return amount == money.amount;
    }
}
