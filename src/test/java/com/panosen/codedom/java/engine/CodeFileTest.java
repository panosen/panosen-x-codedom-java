package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.CodeWriter;
import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.CodeClass;
import com.panosen.codedom.java.CodeFile;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CodeFileTest {

    @Test
    public void Test() {

        CodeFile codeFile = PrepareCode();

        StringBuilder builder = new StringBuilder();

        new JavaCodeEngine().generateCodeFile(codeFile, new CodeWriter(builder));

        String actual = builder.toString();

        String expeced = PrepareExpected();

        Assert.assertEquals(expeced, actual);
    }

    private String PrepareExpected() {
        return "package abc;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "import system.a1;" + System.lineSeparator() +
                "import system.a2;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "import maven.a1;" + System.lineSeparator() +
                "import maven.a2;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "import project.a1;" + System.lineSeparator() +
                "import project.a2;" + System.lineSeparator() +
                "import project.c1;" + System.lineSeparator() +
                "import project.c2;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "public class T {" + System.lineSeparator() +
                "}" + System.lineSeparator();
    }

    private CodeFile PrepareCode() {
        CodeFile codeFile = new CodeFile();
        codeFile.setPackageName("abc");

        codeFile.addSystemImport("system.a1");
        codeFile.addSystemImport("system", "a1");
        codeFile.addSystemImport("system", "a2");

        codeFile.addMavenImport("maven.a1");
        codeFile.addMavenImport("maven", "a1");
        codeFile.addMavenImport("maven", "a2");

        codeFile.addProjectImport("project.a1");
        codeFile.addProjectImport("project", "a1");
        codeFile.addProjectImport("project", "a2");

        ArrayList<String> items = Lists.newArrayList();
        items.add("project.c1");
        items.add("project.c2");
        codeFile.addProjectImports(items);

        codeFile.addProjectImport("abc.TT");

        CodeClass codeClass = codeFile.addClass("T");
        codeClass.setAccessModifiers(AccessModifiers.Public);
        return codeFile;
    }
}
