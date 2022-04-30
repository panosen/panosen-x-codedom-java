package com.panosen.codedom.java.engine;

import com.panosen.codedom.DataValue;
import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeEnum;

public class UT_CodeEnum2 extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "/**" + System.lineSeparator() +
                " * 状态" + System.lineSeparator() +
                " */" + System.lineSeparator() +
                "public enum Status {" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    None()," + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    Active(1)," + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    Inactive(2);" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    private final int value;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    Status() {" + System.lineSeparator() +
                "        this.value = 0;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    Status(int value) {" + System.lineSeparator() +
                "        this.value = value;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    public int getValue() {" + System.lineSeparator() +
                "        return value;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "}" + System.lineSeparator();
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
