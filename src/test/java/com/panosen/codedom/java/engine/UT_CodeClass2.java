package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.java.*;
import org.junit.Assert;
import org.junit.Test;

public class UT_CodeClass2 {

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
        return "/**" + System.lineSeparator() +
                " * 学生" + System.lineSeparator() +
                " */" + System.lineSeparator() +
                "public class Student {" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 属性 0" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    private int property0;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * TheConstructor" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public TheConstructor() {" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * [getter] 属性 0" + System.lineSeparator() +
                "     *" + System.lineSeparator() +
                "     * @return int" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public int getProperty0() {" + System.lineSeparator() +
                "        return property0;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * [setter] 属性 0" + System.lineSeparator() +
                "     *" + System.lineSeparator() +
                "     * @param property0 property0" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public void setProperty0(int property0) {" + System.lineSeparator() +
                "        this.property0 = property0;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 方法 0" + System.lineSeparator() +
                "     *" + System.lineSeparator() +
                "     * @param p1 p1" + System.lineSeparator() +
                "     * @param p2 okok" + System.lineSeparator() +
                "     * @param p3 p3" + System.lineSeparator() +
                "     * @return int" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public int Method0(int p1, int p2, int p3) {" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "}" + System.lineSeparator();
    }

    protected Code PrepareCode() {
        CodeClass codeClass = new CodeClass();
        codeClass.setName("Student");
        codeClass.setSummary("学生");
        codeClass.setAccessModifiers(AccessModifiers.Public);

        {
            codeClass.addProperty("int", "Property0", "属性 0");
        }

        {
            CodeMethod codeMethod = codeClass.addMethod("Method0", "方法 0");
            codeMethod.setReturnType("int");
            codeMethod.setAccessModifiers(AccessModifiers.Public);

            for (int j = 0; j < 3; j++) {
                CodeParameter codeParam = codeMethod.addParameter("int", "p" + (j + 1));
                if (j == 1) {
                    codeParam.setSummary("okok");
                }
            }

            codeMethod.setStepBuilders(Lists.newArrayList());
        }

        {
            CodeMethod codeMethod = new CodeMethod();
            codeMethod.setName("TheConstructor");
            codeMethod.setAccessModifiers(AccessModifiers.Public);
            codeMethod.setStepBuilders(Lists.newArrayList());
            codeClass.addConstructor(codeMethod);
        }

        return codeClass;
    }
}
