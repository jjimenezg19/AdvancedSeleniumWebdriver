package com.herokuapp.theinternet.base;

public class TestUtilities extends BaseTest {

    //Static Sleep
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
