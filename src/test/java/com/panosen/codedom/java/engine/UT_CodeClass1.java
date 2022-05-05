package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.DataValue;
import com.panosen.codedom.java.*;

public class UT_CodeClass1 extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "/**" + System.lineSeparator() +
                " * 学生" + System.lineSeparator() +
                " */" + System.lineSeparator() +
                "public class Student {" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 常量 0" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    const string Constant0 = \"aa\";" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 常量 1" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    const string Constant1 = \"aa\";" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 字段 0" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    private String Field0;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 字段 1" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    private String Field1;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    private String SQL1 = \"plain_field_0\" +" + System.lineSeparator() +
                "        \"plain_field_1\" +" + System.lineSeparator() +
                "        \"plain_field_2\";" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    private String SQL2 = \"string_field_0\" +" + System.lineSeparator() +
                "        \"string_field_1\" +" + System.lineSeparator() +
                "        \"string_field_2\";" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    private int property0;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 属性 1" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    private int property1;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    public TheConstructor() {" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    public int getProperty0() {" + System.lineSeparator() +
                "        return property0;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    public void setProperty0(int property0) {" + System.lineSeparator() +
                "        this.property0 = property0;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * [getter] 属性 1" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public int getProperty1() {" + System.lineSeparator() +
                "        return property1;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * [setter] 属性 1" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public void setProperty1(int property1) {" + System.lineSeparator() +
                "        this.property1 = property1;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 方法 0" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public int Method0(int p1, int p2, int p3) {" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 方法 1" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public int Method1(int p1, int p2, int p3) {" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * 方法 2" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    public int Method2(int p1, int p2, int p3) {" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "}" + System.lineSeparator();
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
                codeField.addValue(DataValue.ofString("\"plain_field_" + i + "\""));
            }
        }
        {
            CodeField codeField = new CodeField();
            codeClass.getFieldList().add(codeField);
            codeField.setType("String");
            codeField.setName("SQL2");

            for (int i = 0; i < 3; i++) {
                codeField.addValue(DataValue.doubleQuotationString("string_field_" + i));
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
