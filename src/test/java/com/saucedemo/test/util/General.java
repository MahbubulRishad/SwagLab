package com.saucedemo.test.util;

public class General {
    public static final int PAGE_LOAD = 30;

    public static void domStable() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
