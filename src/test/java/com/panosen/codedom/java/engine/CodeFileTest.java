package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.CodeWriter;
import com.panosen.codedom.java.AccessModifiers;
import com.panosen.codedom.java.CodeClass;
import com.panosen.codedom.java.CodeFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;

public class CodeFileTest {

    @Test
    public void Test() {

        CodeFile codeFile = PrepareCode();

        StringWriter stringWriter = new StringWriter();

        new JavaCodeEngine().generateCodeFile(codeFile, new CodeWriter(stringWriter));

        String actual = stringWriter.toString();

        String expeced = PrepareExpected();

        Assert.assertEquals(expeced, actual);
    }

    private String PrepareExpected() {
        return "package abc;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "import maven.a1;" + System.lineSeparator() +
                "import maven.a2;" + System.lineSeparator() +
                "import project.a1;" + System.lineSeparator() +
                "import project.a2;" + System.lineSeparator() +
                "import project.c1;" + System.lineSeparator() +
                "import project.c2;" + System.lineSeparator() +
                "import system.a1;" + System.lineSeparator() +
                "import system.a2;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "import javax.persistence.*;" + System.lineSeparator() +
                "import java.sql.Timestamp;" + System.lineSeparator() +
                "import java.sql.Types;" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "public class T {" + System.lineSeparator() +
                "}" + System.lineSeparator();
    }

    private CodeFile PrepareCode() {
        CodeFile codeFile = new CodeFile();
        codeFile.setPackageName("abc");

        codeFile.addImport("system.a1");
        codeFile.addImport("system", "a1");
        codeFile.addImport("system", "a2");

        codeFile.addImport("maven.a1");
        codeFile.addImport("maven", "a1");
        codeFile.addImport("maven", "a2");

        codeFile.addImport("java.sql.Types");
        codeFile.addImport("java.sql.Timestamp");

        codeFile.addImport("javax.persistence.*");

        codeFile.addImport("project.a1");
        codeFile.addImport("project", "a1");
        codeFile.addImport("project", "a2");

        ArrayList<String> items = Lists.newArrayList();
        items.add("project.c1");
        items.add("project.c2");
        codeFile.addImports(items);

        codeFile.addImport("abc.TT");

        CodeClass codeClass = codeFile.addClass("T");
        codeClass.setAccessModifiers(AccessModifiers.Public);
        return codeFile;
    }
}
