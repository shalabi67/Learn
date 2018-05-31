package com.learn.annotations.count_me_in;

@CountMeIn
public class Test1 {

    @CountMeIn
    public String var1;

    @CountMeIn
    private String var2;

    @CountMeIn
    protected String var3;

    @CountMeIn
    public void method1() {

    }
    @CountMeIn
    private void method2() {

    }

    @CountMeIn
    protected void method3() {

    }
}
