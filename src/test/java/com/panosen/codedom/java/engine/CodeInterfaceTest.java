package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.java.*;

public class CodeInterfaceTest extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "/**\r\n" +
                " * 学生\r\n" +
                " */\r\n" +
                "public interface IStudentRepository {\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 方法 0\r\n" +
                "     */\r\n" +
                "    int Method0(int p1, int p2, int p3);\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 方法 1\r\n" +
                "     */\r\n" +
                "    int Method1(int p1, int p2, int p3);\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * 方法 2\r\n" +
                "     */\r\n" +
                "    int Method2(int p1, int p2, int p3);\r\n" +
                "}\r\n";
    }

    @Override
    protected Code PrepareCode() {
        CodeInterface codeInterface = new CodeInterface();
        codeInterface.setName("IStudentRepository");
        codeInterface.setSummary("学生");
        codeInterface.setAccessModifiers(AccessModifiers.Public);

        codeInterface.setMethodList(Lists.newArrayList());
        for (int i = 0; i < 3; i++) {
            CodeMethod codeMethod = new CodeMethod();
            codeInterface.getMethodList().add(codeMethod);

            codeMethod.setName("Method" + i);
            codeMethod.setReturnType("int");
            codeMethod.setSummary("方法 " + i);

            codeMethod.setParameters(Lists.newArrayList());
            for (int j = 0; j < 3; j++) {
                CodeParameter codeParameter = new CodeParameter();
                codeMethod.getParameters().add(codeParameter);

                codeParameter.setName("p" + (j + 1));
                codeParameter.setType("int");
            }
        }

        return codeInterface;
    }
}
