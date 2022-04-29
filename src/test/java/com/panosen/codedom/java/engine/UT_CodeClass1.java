package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.java.*;

public class UT_CodeClass1 extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "/**\r\n" +
                " * 学生\r\n" +
                " */\r\n" +
                "public class Student {\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 常量 0\r\n" +
                "     */\r\n" +
                "    const string Constant0 = \"aa\";\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 常量 1\r\n" +
                "     */\r\n" +
                "    const string Constant1 = \"aa\";\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 字段 0\r\n" +
                "     */\r\n" +
                "    private String Field0;\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 字段 1\r\n" +
                "     */\r\n" +
                "    private String Field1;\r\n" +
                "\r\n" +
                "    private String SQL1 = \"plain_field_0\" +\r\n" +
                "        \"plain_field_1\" +\r\n" +
                "        \"plain_field_2\";\r\n" +
                "\r\n" +
                "    private String SQL2 = \"string_field_0\" +\r\n" +
                "        \"string_field_1\" +\r\n" +
                "        \"string_field_2\";\r\n" +
                "\r\n" +
                "    private int property0;\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 属性 1\r\n" +
                "     */\r\n" +
                "    private int property1;\r\n" +
                "\r\n" +
                "    public TheConstructor() {\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    public int getProperty0() {\r\n" +
                "        return property0;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    public void setProperty0(int property0) {\r\n" +
                "        this.property0 = property0;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * [getter] 属性 1\r\n" +
                "     */\r\n" +
                "    public int getProperty1() {\r\n" +
                "        return property1;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * [setter] 属性 1\r\n" +
                "     */\r\n" +
                "    public void setProperty1(int property1) {\r\n" +
                "        this.property1 = property1;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 方法 0\r\n" +
                "     */\r\n" +
                "    public int Method0(int p1, int p2, int p3) {\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 方法 1\r\n" +
                "     */\r\n" +
                "    public int Method1(int p1, int p2, int p3) {\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 方法 2\r\n" +
                "     */\r\n" +
                "    public int Method2(int p1, int p2, int p3) {\r\n" +
                "    }\r\n" +
                "}\r\n";
    }

    @Override
    protected Code PrepareCode() {
        CodeClass codeClass = new CodeClass();
        codeClass.setName("Student");
        codeClass.setSummary("学生");
        codeClass.setAccessModifiers(AccessModifiers.Public);

        for (int i = 0; i < 2; i++) {
            codeClass.addConstant("string", "Constant" + i, "\"aa\"", "常量 " + i);
        }

        for (int i = 0; i < 2; i++) {
            CodeProperty codeParam = codeClass.addProperty("int", "Property" + i);
            if (i == 1) {
                codeParam.setSummary("属性 " + i);
            }
        }

        for (int i = 0; i < 2; i++) {
            codeClass.addField("String", "Field" + i, "字段 " + i);
        }

        {
            CodeField codeField = new CodeField();
            codeClass.getFieldList().add(codeField);
            codeField.setType("String");
            codeField.setName("SQL1");

            for (int i = 0; i < 3; i++) {
                CodeValue codeValue = new CodeValue();
                codeValue.setType(CodeValueType.PLAIN);
                codeValue.setValue("\"plain_field_" + i + "\"");
                codeField.addValue(codeValue);
            }
        }
        {
            CodeField codeField = new CodeField();
            codeClass.getFieldList().add(codeField);
            codeField.setType("String");
            codeField.setName("SQL2");

            for (int i = 0; i < 3; i++) {
                CodeValue codeValue = new CodeValue();
                codeValue.setType(CodeValueType.STRING);
                codeValue.setValue("string_field_" + i);
                codeField.addValue(codeValue);
            }
        }

        codeClass.setMethodList(Lists.newArrayList());
        for (int i = 0; i < 3; i++) {
            CodeMethod codeMethod = codeClass.addMethod("Method" + i, "方法 " + i);
            codeMethod.setReturnType("int");
            codeMethod.setAccessModifiers(AccessModifiers.Public);

            for (int j = 0; j < 3; j++) {
                codeMethod.addParameter("int", "p" + (j + 1));
            }

            codeMethod.setStepBuilders(Lists.newArrayList());
        }

        {
            CodeMethod codeMethod=new CodeMethod();
            codeMethod.setName("TheConstructor");
            codeMethod.setAccessModifiers(AccessModifiers.Public);
            codeMethod.setStepBuilders(Lists.newArrayList());
            codeClass.addConstructor(codeMethod);
        }

        return codeClass;
    }
}
