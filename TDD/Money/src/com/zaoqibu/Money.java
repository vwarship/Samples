package com.zaoqibu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by vwarship on 2015/2/16.
 */
public class Money {
    protected int amount;

    @Override
    public boolean equals(Object obj) {
        Money money = (Money)obj;
        return amount == money.amount && (getClass().equals(money.getClass()));
    }

}
