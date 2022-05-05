package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.Code;
import com.panosen.codedom.java.CodeClass;
import com.panosen.codedom.java.CodeProperty;

public class UT_CodeAttribute extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "public class Student {" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    @Apple" + System.lineSeparator() +
                "    @Banana(1)" + System.lineSeparator() +
                "    @Candy(\"2\")" + System.lineSeparator() +
                "    @Dog(\"3\", name = \"4\")" + System.lineSeparator() +
                "    private int property0;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    public int getProperty0() {" + System.lineSeparator() +
                "        return property0;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "    public void setProperty0(int property0) {" + System.lineSeparator() +
                "        this.property0 = property0;" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "}" + System.lineSeparator();
    }

    @Override
    protected Code PrepareCode() {
        CodeClass codeClass = new CodeClass();
        codeClass.setName("Student");
        codeClass.setAccessModifiers(AccessModifiers.Public);

        {
            CodeProperty codeProperty = codeClass.addProperty("int", "Property0");
            codeProperty.addAttribute("Apple");
            codeProperty.addAttribute("Banana").addPlainParam("1");
            codeProperty.addAttribute("Candy").addStringParam("2");
            codeProperty.addAttribute("Dog").addStringParam("3").addStringParam("name", "4");
        }

        return codeClass;
    }
}
