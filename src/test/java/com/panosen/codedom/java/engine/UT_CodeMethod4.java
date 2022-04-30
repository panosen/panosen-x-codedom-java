package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeMethod;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;

public class UT_CodeMethod4 {

    @Test
    public void Test() {

        Code option = PrepareCode();

        StringWriter stringWriter = new StringWriter();

        GenerateOptions options = new GenerateOptions();
        options.setUseJavaCoc(true);

        new JavaCodeEngine().generate(option, stringWriter, options);

        String actual = stringWriter.toString();

        String expeced = PrepareExpected();

        Assert.assertEquals(expeced, actual);
    }

    protected String PrepareExpected() {
        return "/**" + System.lineSeparator() +
                " * TestMethod" + System.lineSeparator() +
                " */" + System.lineSeparator() +
                "public void TestMethod() {" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "}" + System.lineSeparator();
    }

    protected Code PrepareCode() {
        CodeMethod codeMethod = new CodeMethod();
        codeMethod.setAccessModifiers(AccessModifiers.Public);
        codeMethod.setName("TestMethod");

        codeMethod.stepEmpty();

        return codeMethod;
    }
}
