package com.zaoqibu;

/**
 * Created by vwarship on 2015/2/15.
 */
public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }
    
    public Dollar times(int multiplier) {
        return new Dollar(amount*multiplier);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        Dollar dollar = (Dollar)obj;
        return amount == dollar.amount;
    }
}
