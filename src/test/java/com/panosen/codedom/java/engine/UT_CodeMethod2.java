package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeMethod;
import com.panosen.codedom.java.CodeParameter;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;

public class UT_CodeMethod2 {

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
                " *" + System.lineSeparator() +
                " * @param name name" + System.lineSeparator() +
                " * @param age age" + System.lineSeparator() +
                " * @return int" + System.lineSeparator() +
                " */" + System.lineSeparator() +
                "public int TestMethod(String name, int age) {" + System.lineSeparator() +
                "    return 0;" + System.lineSeparator() +
                "}" + System.lineSeparator();
    }

    protected Code PrepareCode() {
        CodeMethod codeMethod = new CodeMethod();
        codeMethod.setAccessModifiers(AccessModifiers.Public);
        codeMethod.setName("TestMethod");
        codeMethod.setReturnType("int");

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

        codeMethod.stepStatement("return 0;");

        return codeMethod;
    }
}
