package com.panosen.codedom.java.engine;

import com.google.common.collect.Lists;
import com.panosen.codedom.java.*;

public class UT_CodeMethod1 extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "public void TestMethod(string name, int age) {" + System.lineSeparator() +
                "    name = age.ToString();" + System.lineSeparator() +
                "    name = age.ToString();" + System.lineSeparator() +
                "    try {" + System.lineSeparator() +
                "        int a = 0;" + System.lineSeparator() +
                "    } catch {" + System.lineSeparator() +
                "        //something 1" + System.lineSeparator() +
                "        11111" + System.lineSeparator() +
                "    } catch (Exception) {" + System.lineSeparator() +
                "        222" + System.lineSeparator() +
                "    } catch (Exception e) {" + System.lineSeparator() +
                "    } finally {" + System.lineSeparator() +
                "        333" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "    if (1) {" + System.lineSeparator() +
                "        ok" + System.lineSeparator() +
                "    } else if (b) {" + System.lineSeparator() +
                "        333" + System.lineSeparator() +
                "    } else {" + System.lineSeparator() +
                "        okok" + System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "    String sql = \"INSERT INTO `esmanage`.`field`\"" + System.lineSeparator() +
                "            + \"(`cluster_id`,\"" + System.lineSeparator() +
                "            + \"`document_id`,\"" + System.lineSeparator() +
                "            + \"`id`,\"" + System.lineSeparator() +
                "            + \"`name`,\"" + System.lineSeparator() +
                "            + \"`field_type`,\"" + System.lineSeparator() +
                "            + \"`remark`,\"" + System.lineSeparator() +
                "            + \"`data_status`,\"" + System.lineSeparator() +
                "            + \"`create_time`,\"" + System.lineSeparator() +
                "            + \"`last_update_time`)\"" + System.lineSeparator() +
                "            + \"VALUES\"" + System.lineSeparator() +
                "            + \"(<{ cluster_id: }>,\"" + System.lineSeparator() +
                "            + \"<{ document_id: }>,\"" + System.lineSeparator() +
                "            + \"<{ id: }>,\"" + System.lineSeparator() +
                "            + \"<{ name: }>,\"" + System.lineSeparator() +
                "            + \"<{ field_type: }>,\"" + System.lineSeparator() +
                "            + \"<{ remark: }>,\"" + System.lineSeparator() +
                "            + \"<{ data_status: 0}>,\"" + System.lineSeparator() +
                "            + \"<{ create_time: }>,\"" + System.lineSeparator() +
                "            + \"<{ last_update_time: }>);\";" + System.lineSeparator() +
                "}" + System.lineSeparator();
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
                "INSERT INTO `esmanage`.`field`" + System.lineSeparator() +
                "(`cluster_id`," + System.lineSeparator() +
                "`document_id`," + System.lineSeparator() +
                "`id`," + System.lineSeparator() +
                "`name`," + System.lineSeparator() +
                "`field_type`," + System.lineSeparator() +
                "`remark`," + System.lineSeparator() +
                "`data_status`," + System.lineSeparator() +
                "`create_time`," + System.lineSeparator() +
                "`last_update_time`)" + System.lineSeparator() +
                "VALUES" + System.lineSeparator() +
                "(<{ cluster_id: }>," + System.lineSeparator() +
                "<{ document_id: }>," + System.lineSeparator() +
                "<{ id: }>," + System.lineSeparator() +
                "<{ name: }>," + System.lineSeparator() +
                "<{ field_type: }>," + System.lineSeparator() +
                "<{ remark: }>," + System.lineSeparator() +
                "<{ data_status: 0}>," + System.lineSeparator() +
                "<{ create_time: }>," + System.lineSeparator() +
                "<{ last_update_time: }>);");

        return codeMethod;
    }
}
