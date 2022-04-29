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
        return "/**\r\n" +
                " * 学生\r\n" +
                " */\r\n" +
                "public class Student {\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 属性 0\r\n" +
                "     */\r\n" +
                "    private int property0;\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * TheConstructor\r\n" +
                "     */\r\n" +
                "    public TheConstructor() {\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * [getter] 属性 0\r\n" +
                "     *\r\n" +
                "     * @return int\r\n" +
                "     */\r\n" +
                "    public int getProperty0() {\r\n" +
                "        return property0;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * [setter] 属性 0\r\n" +
                "     *\r\n" +
                "     * @param property0 property0\r\n" +
                "     */\r\n" +
                "    public void setProperty0(int property0) {\r\n" +
                "        this.property0 = property0;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 方法 0\r\n" +
                "     *\r\n" +
                "     * @param p1 p1\r\n" +
                "     * @param p2 okok\r\n" +
                "     * @param p3 p3\r\n" +
                "     * @return int\r\n" +
                "     */\r\n" +
                "    public int Method0(int p1, int p2, int p3) {\r\n" +
                "    }\r\n" +
                "}\r\n";
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
