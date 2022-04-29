package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeMethod;
import org.junit.Assert;
import org.junit.Test;

public class UT_CodeMethod5 {

    @Test
    public void Test() {

        Code option = PrepareCode();

        StringBuilder builder = new StringBuilder();

        GenerateOptions options = new GenerateOptions();
        options.setUseJavaCoc(true);

        new JavaCodeEngine().generate(option, builder, options);

        String actual = builder.toString();

        String expeced = PrepareExpected();

        Assert.assertEquals(expeced, actual);
    }

    protected String PrepareExpected() {
        return "/**\r\n" +
                " * TestMethod\r\n" +
                " *\r\n" +
                " * @return int\r\n" +
                " */\r\n" +
                "public int TestMethod() {\r\n" +
                "\r\n" +
                "}\r\n";
    }

    protected Code PrepareCode() {
        CodeMethod codeMethod = new CodeMethod();
        codeMethod.setAccessModifiers(AccessModifiers.Public);
        codeMethod.setName("TestMethod");
        codeMethod.setReturnType("int");

        codeMethod.stepEmpty();

        return codeMethod;
    }
}
