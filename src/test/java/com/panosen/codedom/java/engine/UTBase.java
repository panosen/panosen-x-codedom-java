package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.Code;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;

public abstract class UTBase {

    @Test
    public void Test() {

        Code option = PrepareCode();

        StringWriter stringWriter = new StringWriter();

        new JavaCodeEngine().generate(option, stringWriter);

        String actual = stringWriter.toString();

        String expeced = PrepareExpected();

        Assert.assertEquals(expeced, actual);
    }

    protected abstract String PrepareExpected();

    protected abstract Code PrepareCode();
}