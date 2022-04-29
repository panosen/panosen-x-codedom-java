package com.panosen.codedom.java.engine;

import com.panosen.codedom.DataValue;
import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeEnum;

public class UT_CodeEnum2 extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "/**\r\n" +
                " * 状态\r\n" +
                " */\r\n" +
                "public enum Status {\r\n" +
                "\r\n" +
                "    None(),\r\n" +
                "\r\n" +
                "    Active(1),\r\n" +
                "\r\n" +
                "    Inactive(2);\r\n" +
                "\r\n" +
                "    private final int value;\r\n" +
                "\r\n" +
                "    Status() {\r\n" +
                "        this.value = 0;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    Status(int value) {\r\n" +
                "        this.value = value;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    public int getValue() {\r\n" +
                "        return value;\r\n" +
                "    }\r\n" +
                "}\r\n";
    }

    @Override
    protected Code PrepareCode() {
        CodeEnum codeEnum = new CodeEnum();
        codeEnum.setName("Status");
        codeEnum.setSummary("状态");
        codeEnum.setAccessModifiers(AccessModifiers.Public);

        codeEnum.addValue("None");
        codeEnum.addValue("Active", DataValue.ofInteger(1));
        codeEnum.addValue("Inactive", DataValue.ofInteger(2));

        return codeEnum;
    }
}
