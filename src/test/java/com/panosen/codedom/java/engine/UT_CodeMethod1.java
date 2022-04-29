package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.java.*;

public class UT_CodeMethod1 extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "public void TestMethod(string name, int age) {\r\n" +
                "    name = age.ToString();\r\n" +
                "    name = age.ToString();\r\n" +
                "    try {\r\n" +
                "        int a = 0;\r\n" +
                "    } catch {\r\n" +
                "        //something 1\r\n" +
                "        11111\r\n" +
                "    } catch (Exception) {\r\n" +
                "        222\r\n" +
                "    } catch (Exception e) {\r\n" +
                "    } finally {\r\n" +
                "        333\r\n" +
                "    }\r\n" +
                "    if (1) {\r\n" +
                "        ok\r\n" +
                "    } else if (b) {\r\n" +
                "        333\r\n" +
                "    } else {\r\n" +
                "        okok\r\n" +
                "    }\r\n" +
                "    String sql = \"INSERT INTO `esmanage`.`field`\"\r\n" +
                "            + \"(`cluster_id`,\"\r\n" +
                "            + \"`document_id`,\"\r\n" +
                "            + \"`id`,\"\r\n" +
                "            + \"`name`,\"\r\n" +
                "            + \"`field_type`,\"\r\n" +
                "            + \"`remark`,\"\r\n" +
                "            + \"`data_status`,\"\r\n" +
                "            + \"`create_time`,\"\r\n" +
                "            + \"`last_update_time`)\"\r\n" +
                "            + \"VALUES\"\r\n" +
                "            + \"(<{ cluster_id: }>,\"\r\n" +
                "            + \"<{ document_id: }>,\"\r\n" +
                "            + \"<{ id: }>,\"\r\n" +
                "            + \"<{ name: }>,\"\r\n" +
                "            + \"<{ field_type: }>,\"\r\n" +
                "            + \"<{ remark: }>,\"\r\n" +
                "            + \"<{ data_status: 0}>,\"\r\n" +
                "            + \"<{ create_time: }>,\"\r\n" +
                "            + \"<{ last_update_time: }>);\";\r\n" +
                "}\r\n";
    }

    @Override
    protected Code PrepareCode() {
        CodeMethod codeMethod = new CodeMethod();
        codeMethod.setAccessModifiers(AccessModifiers.Public);
        codeMethod.setName("TestMethod");

        codeMethod.setParameters(Lists.newArrayList());
        {
            CodeParameter codeParameter = new CodeParameter();
            codeParameter.setName("name");
            codeParameter.setType("string");
            codeMethod.getParameters().add(codeParameter);
        }
        {
            CodeParameter codeParameter = new CodeParameter();
            codeParameter.setName("age");
            codeParameter.setType("int");
            codeMethod.getParameters().add(codeParameter);
        }

        //codeMethod.StepBuilders = new List<StepBuilder>();

        codeMethod.stepStatement("name = age.ToString();");
        codeMethod.stepStatement("name = age.ToString();");

        TryStepBuilder tryStepBuilder = codeMethod.stepTry();
        tryStepBuilder.stepStatement("int a = 0;");
        tryStepBuilder.withCatch().stepStatement("//something 1").stepStatement("11111");
        tryStepBuilder.withCatch("Exception").stepStatement("222");
        tryStepBuilder.withCatch("Exception", "e");
        tryStepBuilder.withFinally().stepStatement("333");

        IfStepBuilder ifStepBuilder = codeMethod.stepIf("1");
        ifStepBuilder.stepStatement("ok");
        ifStepBuilder.withElseIf("b").stepStatement("333");
        ifStepBuilder.withElse().stepStatement("okok");

        codeMethod.stepAssignStringVariable("sql", "" +
                "INSERT INTO `esmanage`.`field`\r\n" +
                "(`cluster_id`,\r\n" +
                "`document_id`,\r\n" +
                "`id`,\r\n" +
                "`name`,\r\n" +
                "`field_type`,\r\n" +
                "`remark`,\r\n" +
                "`data_status`,\r\n" +
                "`create_time`,\r\n" +
                "`last_update_time`)\r\n" +
                "VALUES\r\n" +
                "(<{ cluster_id: }>,\r\n" +
                "<{ document_id: }>,\r\n" +
                "<{ id: }>,\r\n" +
                "<{ name: }>,\r\n" +
                "<{ field_type: }>,\r\n" +
                "<{ remark: }>,\r\n" +
                "<{ data_status: 0}>,\r\n" +
                "<{ create_time: }>,\r\n" +
                "<{ last_update_time: }>);");

        return codeMethod;
    }
}
