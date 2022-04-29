package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeMethod;
import com.panosen.codedom.java.CodeParameter;
import org.junit.Assert;
import org.junit.Test;

public class UT_CodeMethod3 {

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
                " * @param name name\r\n" +
                " * @param age age\r\n" +
                " */\r\n" +
                "public void TestMethod(String name, int age) {\r\n" +
                "\r\n" +
                "}\r\n";
    }

    protected Code PrepareCode() {
        CodeMethod codeMethod = new CodeMethod();
        codeMethod.setAccessModifiers(AccessModifiers.Public);
        codeMethod.setName("TestMethod");

        codeMethod.setParameters(Lists.newArrayList());
        {
            CodeParameter codeParameter = new CodeParameter();
            codeParameter.setName("name");
            codeParameter.setType("String");
            codeMethod.getParameters().add(codeParameter);
        }
        {
            CodeParameter codeParameter = new CodeParameter();
            codeParameter.setName("age");
            codeParameter.setType("int");
            codeMethod.getParameters().add(codeParameter);
        }

        codeMethod.stepEmpty();

        return codeMethod;
    }
}
