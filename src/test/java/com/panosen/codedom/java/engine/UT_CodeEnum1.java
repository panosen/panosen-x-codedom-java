package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeEnum;

public class UT_CodeEnum1 extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "/**" + System.lineSeparator() +
                " * 状态" + System.lineSeparator() +
                " */" + System.lineSeparator() +
                "public enum Status {" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    A_0," + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    A_1," + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    A_2," + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * of 0" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    B_0," + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * of 1" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    B_1," + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    /**" + System.lineSeparator() +
                "     * of 2" + System.lineSeparator() +
                "     */" + System.lineSeparator() +
                "    B_2" + System.lineSeparator() +
                "}" + System.lineSeparator();
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
