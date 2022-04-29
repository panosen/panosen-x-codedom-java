package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.Code;
import org.junit.Assert;
import org.junit.Test;

public abstract class UTBase {

    @Test
    public void Test() {

        Code option = PrepareCode();

        StringBuilder builder = new StringBuilder();

        new JavaCodeEngine().generate(option, builder);

        String actual = builder.toString();

        String expeced = PrepareExpected();

        Assert.assertEquals(expeced, actual);
    }

    protected abstract String PrepareExpected();

    protected abstract Code PrepareCode();
}