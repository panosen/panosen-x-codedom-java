package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeEnum;

public class UT_CodeEnum1 extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "/**\r\n" +
                " * 状态\r\n" +
                " */\r\n" +
                "public enum Status {\r\n" +
                "\r\n" +
                "    A_0,\r\n" +
                "\r\n" +
                "    A_1,\r\n" +
                "\r\n" +
                "    A_2,\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * of 0\r\n" +
                "     */\r\n" +
                "    B_0,\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * of 1\r\n" +
                "     */\r\n" +
                "    B_1,\r\n" +
                "\r\n" +
                "    /**\r\n" +
                "     * of 2\r\n" +
                "     */\r\n" +
                "    B_2\r\n" +
                "}\r\n";
    }

    @Override
    protected Code PrepareCode() {
        CodeEnum codeEnum = new CodeEnum();
        codeEnum.setName("Status");
        codeEnum.setSummary("状态");
        codeEnum.setAccessModifiers(AccessModifiers.Public);

        for (int i = 0; i < 3; i++) {
            codeEnum.addValue("A_" + i);
        }

        for (int i = 0; i < 3; i++) {
            codeEnum.addValue("B_" + i, "of " + i);
        }

        return codeEnum;
    }
}
