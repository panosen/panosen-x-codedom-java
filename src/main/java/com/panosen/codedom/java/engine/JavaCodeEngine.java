package com.panosen.codedom.java.engine;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.panosen.NameExtension;
import com.panosen.codedom.CodeWriter;
import com.panosen.codedom.DataItem;
import com.panosen.codedom.DataValue;
import com.panosen.codedom.Marks;
import com.panosen.codedom.java.*;

import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;

public class JavaCodeEngine {

    /**
     * GenerateDataItem
     *
     * @param dataItem   dataItem
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateDataItem(DataItem dataItem, CodeWriter codeWriter, GenerateOptions options) {
        if (dataItem instanceof DataValue) {
            generateDataValue((DataValue) dataItem, codeWriter, options);
        }

        if (dataItem instanceof CodeLamdaNewInstance) {
            generateLamdaNewInstance((CodeLamdaNewInstance) dataItem, codeWriter, options);
        }

        if (dataItem instanceof CodeLamdaExpression) {
            generateLamdaExpression((CodeLamdaExpression) dataItem, codeWriter, options);
        }

        if (dataItem instanceof CodeLamdaStepBuilderCollection) {
            generateLamdaStepBuilderCollection((CodeLamdaStepBuilderCollection) dataItem, codeWriter, options);
        }
    }

    /**
     * GenerateDataValue
     *
     * @param dataValue  dataValue
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateDataValue(DataValue dataValue, CodeWriter codeWriter, GenerateOptions options) {
        if (dataValue.getValue() == null) {
            codeWriter.write("null");
        } else {
            codeWriter.write(dataValue.getValue());
        }
    }

    /**
     * Generate
     *
     * @param code    code
     * @param stringWriter builder
     */
    public void generate(Code code, StringWriter stringWriter) {
        generate(code, new CodeWriter(stringWriter), null);
    }

    /**
     * Generate
     *
     * @param code    code
     * @param stringWriter builder
     * @param options options
     */
    public void generate(Code code, StringWriter stringWriter, GenerateOptions options) {
        generate(code, new CodeWriter(stringWriter), options);
    }

    /**
     * Generate
     *
     * @param code       code
     * @param codeWriter codeWriter
     */
    public void generate(Code code, CodeWriter codeWriter) {
        generate(code, codeWriter, null);
    }

    /**
     * Generate
     *
     * @param code       code
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generate(Code code, CodeWriter codeWriter, GenerateOptions options) {
        if (code == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        if (code instanceof CodeClass) {
            generateClass((CodeClass) code, codeWriter, options);
            return;
        }

        if (code instanceof CodeInterface) {
            generateInterface((CodeInterface) code, codeWriter, options);
            return;
        }

        if (code instanceof CodeExpression) {
            generateExpresion((CodeExpression) code, codeWriter, options);
            return;
        }

        if (code instanceof CodeMethod) {
            generateMethod((CodeMethod) code, codeWriter, options);
            return;
        }

        if (code instanceof CodeEnum) {
            generateEnum((CodeEnum) code, codeWriter, options);
            return;
        }
    }

    /**
     * GenerateExpresion
     *
     * @param codeExpression codeExpression
     * @param codeWriter     codeWriter
     * @param options        options
     */
    public void generateExpresion(CodeExpression codeExpression, CodeWriter codeWriter, GenerateOptions options) {
        if (codeExpression == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        if (codeExpression instanceof CodeThisReferenceExpression) {
            generateCodeThisReferenceExpression((CodeThisReferenceExpression) codeExpression, codeWriter, options);
            return;
        }

        if (codeExpression instanceof CodeFieldReferenceExpression) {
            generateCodeFieldReferenceExpression((CodeFieldReferenceExpression) codeExpression, codeWriter, options);
            return;
        }

        if (codeExpression instanceof CodeBinaryOperatorExpression) {
            generateBinaryOperatorExpresion((CodeBinaryOperatorExpression) codeExpression, codeWriter, options);
            return;
        }
    }

    /**
     * GenerateBinaryOperatorExpresion
     *
     * @param codeExpression codeExpression
     * @param codeWriter     codeWriter
     * @param options        options
     */
    public void generateBinaryOperatorExpresion(CodeBinaryOperatorExpression codeExpression, CodeWriter codeWriter, GenerateOptions options) {
        if (codeExpression == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter
                .write(codeExpression.getLeft() != null ? codeExpression.getLeft() : "")
                .write(Marks.WHITESPACE)
                .write(codeExpression.getOperator() != null ? codeExpression.getOperator().getValue() : "")
                .write(Marks.WHITESPACE)
                .write(codeExpression.getRight() != null ? codeExpression.getRight() : "");
    }

    /**
     * GenerateCodeFieldReferenceExpression
     *
     * @param codeExpression codeExpression
     * @param codeWriter     codeWriter
     * @param options        options
     */
    public void generateCodeFieldReferenceExpression(CodeFieldReferenceExpression codeExpression, CodeWriter codeWriter, GenerateOptions options) {
        if (codeExpression == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        if (codeExpression.getTargetObject() == null) {
            return;
        }
        if (codeExpression.getFieldName() == null) {
            return;
        }

        generateExpresion(codeExpression.getTargetObject(), codeWriter, options);

        codeWriter.write(".");
        codeWriter.write(codeExpression.getFieldName());
    }

    /**
     * GenerateCodeThisReferenceExpression
     *
     * @param codeExpression codeExpression
     * @param codeWriter     codeWriter
     * @param options        options
     */
    public void generateCodeThisReferenceExpression(CodeThisReferenceExpression codeExpression, CodeWriter codeWriter, GenerateOptions options) {
        if (codeExpression == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write("this");
    }

    /**
     * GenerateAssignStringVariableStepBuilder
     *
     * @param assignStringVariableStepBuilder assignStringVariableStepBuilder
     * @param codeWriter                      codeWriter
     * @param options                         options
     */
    public void generateAssignStringVariableStepBuilder(AssignStringVariableStepBuilder assignStringVariableStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        if (assignStringVariableStepBuilder == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        List<String> items = Arrays.asList(assignStringVariableStepBuilder.getValue().split(System.lineSeparator()));

        if (items.size() == 1) {
            codeWriter.write(options.getIndentString()).writeLine("String " + assignStringVariableStepBuilder.getName() + " = \"" + items.get(0) + "\";");
        } else {
            codeWriter.write(options.getIndentString()).writeLine("String " + assignStringVariableStepBuilder.getName() + " = \"" + items.get(0) + "\"");
            for (int index = 1, length = items.size(); index < length; index++) {
                String line = "+ \"" + items.get(index) + "\"";
                if (index == items.size() - 1) {
                    line = line + ";";
                }
                codeWriter.write(options.getIndentString()).write(options.getTabString()).write(options.getTabString()).writeLine(line);
            }
        }

    }

    /**
     * GenerateAttribute
     *
     * @param codeAttribute codeAttribute
     * @param codeWriter    codeWriter
     * @param options       options
     */
    public void generateAttribute(CodeAttribute codeAttribute, CodeWriter codeWriter, GenerateOptions options) {
        if (codeAttribute == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        List<String> items = Lists.newArrayList();
        if (codeAttribute.getParamList() != null && !codeAttribute.getParamList().isEmpty()) {
            items.addAll(codeAttribute.getParamList().stream().map(this::ToValue).collect(Collectors.toList()));
        }
        if (codeAttribute.getParamMap() != null && !codeAttribute.getParamMap().isEmpty()) {
            items.addAll(codeAttribute.getParamMap().entrySet().stream().map(v -> v.getKey() + " = " + ToValue(v.getValue())).collect(Collectors.toList()));
        }
        String itemString = items.size() > 0 ? "(" + String.join(", ", items) + ")" : "";

        codeWriter.write(Marks.AT).write(codeAttribute.getName() != null ? codeAttribute.getName() : "").write(itemString);
    }

    /**
     * ToValue
     *
     * @param codeValue codeValue
     * @return String
     */
    public String ToValue(CodeValue codeValue) {
        switch (codeValue.getType()) {
            case STRING:
                return "\"" + codeValue.getValue() + "\"";

            case PLAIN:
            default:
                return codeValue.getValue();
        }
    }

    /**
     * 生成类
     *
     * @param codeClass  codeClass
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateClass(CodeClass codeClass, CodeWriter codeWriter, GenerateOptions options) {
        if (codeClass == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        generateSummary(codeClass.getSummary(), codeWriter, options);

        if (codeClass.getAttributeList() != null && codeClass.getAttributeList().size() > 0) {
            for (CodeAttribute codeAttribute : codeClass.getAttributeList()) {
                codeWriter.write(options.getIndentString());
                generateAttribute(codeAttribute, codeWriter, options);
                codeWriter.writeLine();
            }
        }

        codeWriter.write(options.getIndentString());

        if (codeClass.getAccessModifiers() != null) {
            codeWriter.write(codeClass.getAccessModifiers().getValue()).write(Marks.WHITESPACE);
        }

        if (codeClass.getIsFinal()) {
            codeWriter.write(Keywords.FINAL).write(Marks.WHITESPACE);
        }

        if (codeClass.getIsAbstract()) {
            codeWriter.write(Keywords.ABSTRACT).write(Marks.WHITESPACE);
        }

        codeWriter.write(Keywords.CLASS).write(Marks.WHITESPACE).write(codeClass.getName());

        if (codeClass.getBaseClass() != null) {
            codeWriter.write(Marks.WHITESPACE).write(Keywords.EXTENDS).write(Marks.WHITESPACE).write(codeClass.getBaseClass().getName());
        }

        if (codeClass.getInterfaceList() != null && !codeClass.getInterfaceList().isEmpty()) {
            for (CodeInterface codeInterface : codeClass.getInterfaceList()) {
                codeWriter.write(Marks.WHITESPACE).write(Keywords.IMPLEMENTS).write(Marks.WHITESPACE).write(codeInterface.getName());
            }
        }

        codeWriter.write(Marks.WHITESPACE).writeLine(Marks.LEFT_BRACE);

        options.pushIndent();

        if (codeClass.getConstantList() != null && !codeClass.getConstantList().isEmpty()) {
            for (CodeConstant codeConstant : codeClass.getConstantList()) {
                codeWriter.writeLine();
                generateConstant(codeConstant, codeWriter, options);
            }
        }

        if (codeClass.getFieldList() != null && !codeClass.getFieldList().isEmpty()) {
            for (CodeField codeField : codeClass.getFieldList()) {
                codeWriter.writeLine();
                generateField(codeField, codeWriter, options);
            }
        }

        if (codeClass.getPropertyList() != null && !codeClass.getPropertyList().isEmpty()) {
            for (CodeProperty codeProperty : codeClass.getPropertyList()) {
                codeWriter.writeLine();
                generatePropertyField(codeProperty, codeWriter, options);
            }
        }

        if (codeClass.getConstructorList() != null && !codeClass.getConstructorList().isEmpty()) {
            for (CodeMethod codeConstructor : codeClass.getConstructorList()) {
                codeWriter.writeLine();
                generateConstructor(codeConstructor, codeWriter, options);
            }
        }

        if (codeClass.getPropertyList() != null && !codeClass.getPropertyList().isEmpty()) {
            for (CodeProperty codeProperty : codeClass.getPropertyList()) {
                codeWriter.writeLine();
                generatePropertyMethod(codeProperty, codeWriter, options);
            }
        }

        if (codeClass.getMethodList() != null && !codeClass.getMethodList().isEmpty()) {
            for (CodeMethod codeMethod : codeClass.getMethodList()) {
                codeWriter.writeLine();
                generateMethod(codeMethod, codeWriter, options);
            }
        }

        options.PopIndent();

        codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
    }

    /**
     * 生成cs文件
     *
     * @param codeFile   codeFile
     * @param codeWriter codeWriter
     */
    public void generateCodeFile(CodeFile codeFile, CodeWriter codeWriter) {
        generateCodeFile(codeFile, codeWriter, null);
    }

    /**
     * 生成cs文件
     *
     * @param codeFile   codeFile
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateCodeFile(CodeFile codeFile, CodeWriter codeWriter, GenerateOptions options) {
        if (codeFile == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(Keywords.PACKAGE).write(Marks.WHITESPACE).write(codeFile.getPackageName()).writeLine(Marks.SEMICOLON);

        if (codeFile.getMottos() != null && !codeFile.getMottos().isEmpty()) {
            codeWriter.writeLine();
            codeWriter.writeLine("/*");
            codeWriter.writeLine(" *------------------------------------------------------------------------------");
            for (int i = 0, length = codeFile.getMottos().size(); i < length; i++) {
                codeWriter.writeLine(" *     " + codeFile.getMottos().get(i));
                if (i < length - 1) {
                    codeWriter.writeLine(" *");
                }
            }
            codeWriter.writeLine(" *------------------------------------------------------------------------------");
            codeWriter.writeLine(" */");
        }

        List<String> usingList = Lists.newArrayList();
        addImportList(usingList, codeFile.getSystemImportList(), codeFile.getPackageName());
        addImportList(usingList, codeFile.getMavenImportList(), codeFile.getPackageName());
        addImportList(usingList, codeFile.getProjectImportList(), codeFile.getPackageName());

        if (usingList.size() > 0) {
            for (String usingItem : usingList) {
                if (Strings.isNullOrEmpty(usingItem)) {
                    codeWriter.writeLine();
                    continue;
                }

                codeWriter.write(Keywords.IMPORT).write(Marks.WHITESPACE).write(usingItem).writeLine(";");
            }
        }

        if (codeFile.getClassList() != null && !codeFile.getClassList().isEmpty()) {
            for (CodeClass codeClass : codeFile.getClassList()) {
                codeWriter.writeLine();
                generateClass(codeClass, codeWriter, options);
            }
        }

        if (codeFile.getInterfaceList() != null && !codeFile.getInterfaceList().isEmpty()) {
            for (CodeInterface codeInterface : codeFile.getInterfaceList()) {
                codeWriter.writeLine();
                generateInterface(codeInterface, codeWriter, options);
            }
        }

        if (codeFile.getEnumList() != null && !codeFile.getEnumList().isEmpty()) {
            for (CodeEnum codeEnum : codeFile.getEnumList()) {
                codeWriter.writeLine();
                generateEnum(codeEnum, codeWriter, options);
            }
        }
    }

    private static void addImportList(List<String> targetUsingList, SortedMap<String, SortedSet<String>> packageList, String packageName) {
        if (packageList == null || packageList.isEmpty()) {
            return;
        }

        targetUsingList.add("");

        for (Map.Entry<String, SortedSet<String>> entry : packageList.entrySet()) {
            if (entry.getKey().equals(packageName)) {
                continue;
            }
            for (String name : entry.getValue()) {
                targetUsingList.add(entry.getKey() + "." + name);
            }
        }
    }

    /**
     * GenerateConstant
     *
     * @param codeConstant codeConstant
     * @param codeWriter   codeWriter
     * @param options      options
     */
    public void generateConstant(CodeConstant codeConstant, CodeWriter codeWriter, GenerateOptions options) {
        if (codeConstant == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        generateSummary(codeConstant.getSummary(), codeWriter, options);
        codeWriter.write(options.getIndentString());

        if (codeConstant.getAccessModifiers() != null) {
            codeWriter.write(codeConstant.getAccessModifiers().getValue()).write(Marks.WHITESPACE);
        }

        codeWriter.write(Keywords.CONST).write(Marks.WHITESPACE);

        codeWriter.write(codeConstant.getType())
                .write(Marks.WHITESPACE).write(codeConstant.getName())
                .write(Marks.WHITESPACE).write(Marks.EQUAL)
                .write(Marks.WHITESPACE).write(codeConstant.getValue() != null ? codeConstant.getValue() : "NULL")
                .writeLine(Marks.SEMICOLON);
    }

    /**
     * GenerateMethod
     *
     * @param codeMethod codeMethod
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateConstructor(CodeMethod codeMethod, CodeWriter codeWriter, GenerateOptions options) {
        if (codeMethod == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        if (options.getUseJavaCoc()) {
            generateJavaDoc(codeMethod, codeWriter, options);
        } else {
            generateSummary(codeMethod.getSummary(), codeWriter, options);
        }

        if (codeMethod.getAttributeList() != null && !codeMethod.getAttributeList().isEmpty()) {
            for (CodeAttribute codeAttribute : codeMethod.getAttributeList()) {
                codeWriter.write(options.getIndentString());
                generateAttribute(codeAttribute, codeWriter, options);
                codeWriter.writeLine();
            }
        }

        codeWriter.write(options.getIndentString());

        if (codeMethod.getAccessModifiers() != null) {
            codeWriter.write(codeMethod.getAccessModifiers().getValue()).write(Marks.WHITESPACE);
        }

        if (codeMethod.getIsSynchronized()) {
            codeWriter.write(Keywords.SYNCHRONIZED).write(Marks.WHITESPACE);
        }

        if (codeMethod.getIsStatic()) {
            codeWriter.write(Keywords.STATIC).write(Marks.WHITESPACE);
        }

        codeWriter.write(codeMethod.getName());

        codeWriter.write(Marks.LEFT_BRACKET);

        if (codeMethod.getParameters() != null && !codeMethod.getParameters().isEmpty()) {
            for (int index = 0, length = codeMethod.getParameters().size(); index < length; index++) {
                CodeParameter codeParameter = codeMethod.getParameters().get(index);
                generateParameter(codeParameter, codeWriter, options);

                if (index < length - 1) {
                    codeWriter.write(Marks.COMMA).write(Marks.WHITESPACE);
                }
            }
        }

        codeWriter.write(Marks.RIGHT_BRACKET);

        if (codeMethod.getExceptionList() != null && !codeMethod.getExceptionList().isEmpty()) {
            codeWriter.write(Marks.WHITESPACE).write(Keywords.THROWS).write(Marks.WHITESPACE)
                    .write(String.join(", ", codeMethod.getExceptionList()));
        }

        if (codeMethod.getStepBuilders() == null) {
            codeWriter.writeLine(Marks.SEMICOLON);
            return;
        }

        codeWriter.write(Marks.WHITESPACE).writeLine(Marks.LEFT_BRACE);

        options.pushIndent();

        for (StepBuilderOrCollection stepBuilder : codeMethod.getStepBuilders()) {
            generateStepBuilderOrCollection(stepBuilder, codeWriter, options);
        }

        options.PopIndent();

        codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
    }

    /**
     * 生成类
     *
     * @param codeEnum   codeEnum
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateEnum(CodeEnum codeEnum, CodeWriter codeWriter, GenerateOptions options) {
        if (codeEnum == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        generateSummary(codeEnum.getSummary(), codeWriter, options);

        codeWriter.write(options.getIndentString());

        if (codeEnum.getAccessModifiers() != null) {
            codeWriter.write(codeEnum.getAccessModifiers().getValue()).write(Marks.WHITESPACE);
        }

        codeWriter.write(Keywords.ENUM).write(Marks.WHITESPACE).write(codeEnum.getName())
                .write(Marks.WHITESPACE).writeLine(Marks.LEFT_BRACE);

        options.pushIndent();

        boolean withEmptyConstructor = codeEnum.getValueList() != null && !codeEnum.getValueList().isEmpty()
                && codeEnum.getValueList().stream().anyMatch(v -> v.getValue() != null)
                && codeEnum.getValueList().stream().anyMatch(v -> v.getValue() == null);

        boolean withValueConstructor = codeEnum.getValueList() != null && !codeEnum.getValueList().isEmpty()
                && codeEnum.getValueList().stream().anyMatch(v -> v.getValue() != null);

        if (codeEnum.getValueList() != null && !codeEnum.getValueList().isEmpty()) {
            boolean forceConstructor = codeEnum.getValueList().stream().anyMatch(v -> v.getValue() != null);
            Iterator<CodeEnumValue> enumerator = codeEnum.getValueList().iterator();
            boolean moveNext = enumerator.hasNext();
            while (moveNext) {
                codeWriter.writeLine();
                generateEnumValue(enumerator.next(), codeWriter, forceConstructor, options);

                moveNext = enumerator.hasNext();
                if (moveNext) {
                    codeWriter.write(Marks.COMMA);
                    codeWriter.writeLine();
                }
            }

            if (withEmptyConstructor || withValueConstructor) {
                codeWriter.write(Marks.SEMICOLON);
            }
            codeWriter.writeLine();
        }

        if (withValueConstructor) {
            codeWriter.writeLine();
            codeWriter.write(options.getIndentString());
            codeWriter.writeLine("private final int value;");
        }

        if (withEmptyConstructor) {
            codeWriter.writeLine();
            codeWriter.write(options.getIndentString()).write(codeEnum.getName()).write(Marks.LEFT_BRACKET).write(Marks.RIGHT_BRACKET)
                    .write(Marks.WHITESPACE).write(Marks.LEFT_BRACE).writeLine();
            options.pushIndent();
            codeWriter.write(options.getIndentString()).writeLine("this.value = 0;");
            options.PopIndent();
            codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
        }

        if (withValueConstructor) {
            {
                codeWriter.writeLine();
                codeWriter.write(options.getIndentString()).write(codeEnum.getName())
                        .write(Marks.LEFT_BRACKET).write("int value").write(Marks.RIGHT_BRACKET)
                        .write(Marks.WHITESPACE).write(Marks.LEFT_BRACE).writeLine();
                options.pushIndent();
                codeWriter.write(options.getIndentString()).writeLine("this.value = value;");
                options.PopIndent();
                codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
            }

            {
                codeWriter.writeLine();
                //public int getValue() {
                codeWriter.write(options.getIndentString()).write(Keywords.PUBLIC).write(Marks.WHITESPACE).write(JavaTypeConstant.INTEGER).write(Marks.WHITESPACE)
                        .write("getValue").write(Marks.LEFT_BRACKET).write(Marks.RIGHT_BRACKET)
                        .write(Marks.WHITESPACE).write(Marks.LEFT_BRACE).writeLine();
                options.pushIndent();
                codeWriter.write(options.getIndentString()).writeLine("return value;");
                options.PopIndent();
                codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
            }
        }

        options.PopIndent();

        codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
    }

    /**
     * 生成字段
     *
     * @param codeEnumValue    codeEnumValue
     * @param codeWriter       codeWriter
     * @param forceConstructor forceConstructor
     * @param options          options
     */
    public void generateEnumValue(CodeEnumValue codeEnumValue, CodeWriter codeWriter, Boolean forceConstructor, GenerateOptions options) {
        if (codeEnumValue == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        generateSummary(codeEnumValue.getSummary(), codeWriter, options);

        codeWriter.write(options.getIndentString());

        codeWriter.write(codeEnumValue.getName());

        if (codeEnumValue.getValue() != null || forceConstructor) {
            codeWriter.write(Marks.LEFT_BRACKET);
        }

        if (codeEnumValue.getValue() != null) {
            generateDataItem(codeEnumValue.getValue(), codeWriter, options);
        }

        if (codeEnumValue.getValue() != null || forceConstructor) {
            codeWriter.write(Marks.RIGHT_BRACKET);
        }
    }

    /**
     * 生成字段
     *
     * @param codeField  codeField
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateField(CodeField codeField, CodeWriter codeWriter, GenerateOptions options) {
        if (codeField == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        generateSummary(codeField.getSummary(), codeWriter, options);

        if (codeField.getAttributeList() != null && !codeField.getAttributeList().isEmpty()) {
            for (CodeAttribute attribute : codeField.getAttributeList()) {
                codeWriter.write(options.getIndentString());
                generateAttribute(attribute, codeWriter, options);
                codeWriter.writeLine();
            }
        }

        codeWriter.write(options.getIndentString());

        if (codeField.getAccessModifiers() != null) {
            codeWriter.write(codeField.getAccessModifiers().getValue()).write(Marks.WHITESPACE);
        } else {
            codeWriter.write(AccessModifiers.Private.getValue()).write(Marks.WHITESPACE);
        }

        if (codeField.getIsFinal()) {
            codeWriter.write(Keywords.FINAL).write(Marks.WHITESPACE);
        }

        if (codeField.getIsStatic()) {
            codeWriter.write(Keywords.STATIC).write(Marks.WHITESPACE);
        }

        codeWriter.write(codeField.getType()).write(Marks.WHITESPACE);

        codeWriter.write(codeField.getName());

        if (codeField.getValueList() != null && !codeField.getValueList().isEmpty()) {
            options.pushIndent();

            codeWriter.write(Marks.WHITESPACE).write(Marks.EQUAL).write(Marks.WHITESPACE);
            for (int i = 0, length = codeField.getValueList().size(); i < length; i++) {
                CodeValue codeValue = codeField.getValueList().get(i);
                switch (codeValue.getType()) {
                    case PLAIN:
                        codeWriter.write(codeValue.getValue());
                        break;
                    case STRING:
                        codeWriter.write(Marks.DOUBLE_QUOTATION).write(codeValue.getValue()).write(Marks.DOUBLE_QUOTATION);
                        break;
                    default:
                        break;
                }

                if (i < length - 1) {
                    codeWriter.write(Marks.WHITESPACE).writeLine(Marks.PLUS);

                    codeWriter.write(options.getIndentString());
                }
            }

            options.PopIndent();
        }

        codeWriter.writeLine(Marks.SEMICOLON);
    }

    /**
     * 生成接口
     *
     * @param codeInterface codeInterface
     * @param codeWriter    codeWriter
     * @param options       options
     */
    public void generateInterface(CodeInterface codeInterface, CodeWriter codeWriter, GenerateOptions options) {
        if (codeInterface == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        generateSummary(codeInterface.getSummary(), codeWriter, options);

        codeWriter.write(options.getIndentString());

        if (codeInterface.getAccessModifiers() != null) {
            codeWriter.write(codeInterface.getAccessModifiers().getValue()).write(Marks.WHITESPACE);
        }

        codeWriter.write(Keywords.INTERFACE).write(Marks.WHITESPACE).write(codeInterface.getName());

        if (codeInterface.getBaseInterface() != null) {
            codeWriter.write(Marks.WHITESPACE).write(Keywords.EXTENDS).write(Marks.WHITESPACE).write(codeInterface.getBaseInterface().getName());
        }

        codeWriter.write(Marks.WHITESPACE).writeLine(Marks.LEFT_BRACE);

        options.pushIndent();

        if (codeInterface.getMethodList() != null && !codeInterface.getMethodList().isEmpty()) {
            for (CodeMethod codeMethod : codeInterface.getMethodList()) {
                codeWriter.writeLine();
                generateMethod(codeMethod, codeWriter, options);
            }
        }

        options.PopIndent();

        codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
    }

    /**
     * 生成javadoc
     *
     * @param codeMethod codeMethod
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateJavaDoc(CodeMethod codeMethod, CodeWriter codeWriter, GenerateOptions options) {
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        String summary = !Strings.isNullOrEmpty(codeMethod.getSummary()) ? codeMethod.getSummary() : codeMethod.getName();
        String[] lines = summary.split("[\r\n]");

        codeWriter.write(options.getIndentString()).writeLine("/**");

        for (String line : lines) {
            if (Strings.isNullOrEmpty(line)) {
                continue;
            }
            codeWriter.write(options.getIndentString()).write(" * ").writeLine(line);
        }

        if ((codeMethod.getParameters() != null && !codeMethod.getParameters().isEmpty()) ||
                (codeMethod.getReturnType() != null && !codeMethod.getReturnType().equals("void"))) {
            codeWriter.write(options.getIndentString()).writeLine(" *");
        }

        if (codeMethod.getParameters() != null && !codeMethod.getParameters().isEmpty()) {
            for (CodeParameter parameter : codeMethod.getParameters()) {
                String parmSummary = !Strings.isNullOrEmpty(parameter.getSummary()) ? parameter.getSummary() : parameter.getName();
                codeWriter.write(options.getIndentString()).write(" * @param ").write(parameter.getName()).write(" ").writeLine(parmSummary);
            }
        }
        if (codeMethod.getReturnType() != null && codeMethod.getReturnType() != "void") {
            codeWriter.write(options.getIndentString()).write(" * @return ").writeLine(EncodeSummary(codeMethod.getReturnType()));
        }

        codeWriter.write(options.getIndentString()).writeLine(" */");
    }

    private String EncodeSummary(String value) {
        if (Strings.isNullOrEmpty(value)) {
            return "";
        }

        return value.replace("<", "&lt;").replace(">", "&gt;");
    }

    /**
     * GenerateMethod
     *
     * @param codeMethod codeMethod
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateMethod(CodeMethod codeMethod, CodeWriter codeWriter, GenerateOptions options) {
        if (codeMethod == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        if (options.getUseJavaCoc()) {
            generateJavaDoc(codeMethod, codeWriter, options);
        } else {
            generateSummary(codeMethod.getSummary(), codeWriter, options);
        }

        if (codeMethod.getAttributeList() != null && !codeMethod.getAttributeList().isEmpty()) {
            for (CodeAttribute codeAttribute : codeMethod.getAttributeList()) {
                codeWriter.write(options.getIndentString());
                generateAttribute(codeAttribute, codeWriter, options);
                codeWriter.writeLine();
            }
        }

        codeWriter.write(options.getIndentString());

        if (codeMethod.getAccessModifiers() != null) {
            codeWriter.write(codeMethod.getAccessModifiers().getValue()).write(Marks.WHITESPACE);
        }

        if (codeMethod.getIsSynchronized()) {
            codeWriter.write(Keywords.SYNCHRONIZED).write(Marks.WHITESPACE);
        }

        if (codeMethod.getIsStatic()) {
            codeWriter.write(Keywords.STATIC).write(Marks.WHITESPACE);
        }

        if (!Strings.isNullOrEmpty(codeMethod.getReturnType())) {
            codeWriter.write(codeMethod.getReturnType()).write(Marks.WHITESPACE);
        } else {
            codeWriter.write(Keywords.VOID).write(Marks.WHITESPACE);
        }

        codeWriter.write(codeMethod.getName());

        codeWriter.write(Marks.LEFT_BRACKET);

        if (codeMethod.getParameters() != null && !codeMethod.getParameters().isEmpty()) {
            for (int index = 0, length = codeMethod.getParameters().size(); index < length; index++) {
                CodeParameter codeParameter = codeMethod.getParameters().get(index);
                generateParameter(codeParameter, codeWriter, options);

                if (index < length - 1) {
                    codeWriter.write(Marks.COMMA).write(Marks.WHITESPACE);
                }
            }
        }

        codeWriter.write(Marks.RIGHT_BRACKET);

        if (codeMethod.getExceptionList() != null && !codeMethod.getExceptionList().isEmpty()) {
            codeWriter.write(Marks.WHITESPACE).write(Keywords.THROWS).write(Marks.WHITESPACE).write(String.join(", ", codeMethod.getExceptionList()));
        }

        if (codeMethod.getStepBuilders() == null) {
            codeWriter.writeLine(Marks.SEMICOLON);
            return;
        }

        codeWriter.write(Marks.WHITESPACE).writeLine(Marks.LEFT_BRACE);

        options.pushIndent();

        for (StepBuilderOrCollection stepBuilder : codeMethod.getStepBuilders()) {
            generateStepBuilderOrCollection(stepBuilder, codeWriter, options);
        }

        options.PopIndent();

        codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
    }

    /**
     * GenerateParameter
     *
     * @param codeParameter codeParameter
     * @param codeWriter    codeWriter
     * @param options       options
     */
    public void generateParameter(CodeParameter codeParameter, CodeWriter codeWriter, GenerateOptions options) {
        if (codeParameter == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        if (codeParameter.getAttributeList() != null && !codeParameter.getAttributeList().isEmpty()) {
            for (CodeAttribute codeAttribute : codeParameter.getAttributeList()) {
                generateAttribute(codeAttribute, codeWriter, options);
                codeWriter.write(Marks.WHITESPACE);
            }
        }
        codeWriter.write(codeParameter.getType()).write(Marks.WHITESPACE).write(codeParameter.getName());
    }

    /**
     * 生成属性对应的字段
     *
     * @param codeProperty codeProperty
     * @param codeWriter   codeWriter
     * @param options      options
     */
    public void generatePropertyField(CodeProperty codeProperty, CodeWriter codeWriter, GenerateOptions options) {
        if (codeProperty == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        generateSummary(codeProperty.getSummary(), codeWriter, options);

        if (codeProperty.getAttributeList() != null && !codeProperty.getAttributeList().isEmpty()) {
            for (CodeAttribute attribute : codeProperty.getAttributeList()) {
                codeWriter.write(options.getIndentString());
                generateAttribute(attribute, codeWriter, options);
                codeWriter.writeLine();
            }
        }

        codeWriter.write(options.getIndentString());

        if (codeProperty.getAccessModifiers() != null) {
            codeWriter.write(codeProperty.getAccessModifiers().getValue()).write(Marks.WHITESPACE);
        } else {
            codeWriter.write(AccessModifiers.Private.getValue()).write(Marks.WHITESPACE);
        }

        if (codeProperty.getIsStatic()) {
            codeWriter.write(Keywords.STATIC).write(Marks.WHITESPACE);
        }

        codeWriter.write(codeProperty.getType()).write(Marks.WHITESPACE)
                .write(NameExtension.toLowerCamelCase(codeProperty.getName()));

        if (codeProperty.getValueList() != null && !codeProperty.getValueList().isEmpty()) {
            options.pushIndent();

            codeWriter.write(Marks.WHITESPACE).write(Marks.EQUAL).write(Marks.WHITESPACE);
            for (int index = 0, length = codeProperty.getValueList().size(); index < length; index++) {
                CodeValue codeValue = codeProperty.getValueList().get(index);
                switch (codeValue.getType()) {
                    case PLAIN:
                        codeWriter.write(codeValue.getValue());
                        break;
                    case STRING:
                        codeWriter.write(Marks.DOUBLE_QUOTATION).write(codeValue.getValue()).write(Marks.DOUBLE_QUOTATION);
                        break;
                    default:
                        break;
                }

                if (index < length - 1) {
                    codeWriter.write(Marks.WHITESPACE).writeLine(Marks.PLUS);

                    codeWriter.write(options.getIndentString());
                }
            }

            options.PopIndent();
        }

        codeWriter.writeLine(Marks.SEMICOLON);
    }

    /**
     * 生成属性对应的方法
     *
     * @param codeProperty codeProperty
     * @param codeWriter   codeWriter
     * @param options      options
     */
    public void generatePropertyMethod(CodeProperty codeProperty, CodeWriter codeWriter, GenerateOptions options) {
        if (codeProperty == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        {
            CodeMethod codeMethod = BuildMethod_GetProperty(codeProperty);
            if (!Strings.isNullOrEmpty(codeProperty.getSummary())) {
                codeMethod.setSummary("[getter] " + codeProperty.getSummary());
            } else if (options.getUseJavaCoc()) {
                codeMethod.setSummary("[getter] " + codeProperty.getName());
            }
            generateMethod(codeMethod, codeWriter, options);
        }

        codeWriter.writeLine();

        {
            CodeMethod codeMethod = BuildMethod_SetMethod(codeProperty);
            if (!Strings.isNullOrEmpty(codeProperty.getSummary())) {
                codeMethod.setSummary("[setter] " + codeProperty.getSummary());
            } else if (options.getUseJavaCoc()) {
                codeMethod.setSummary("[setter] " + codeProperty.getName());
            }
            generateMethod(codeMethod, codeWriter, options);
        }
    }

    private CodeMethod BuildMethod_GetProperty(CodeProperty codeProperty) {
        CodeMethod codeMethod = new CodeMethod();
        codeMethod.setAccessModifiers(AccessModifiers.Public);
        codeMethod.setIsStatic(codeProperty.getIsStatic());
        codeMethod.setReturnType(codeProperty.getType());
        codeMethod.setName("get" + codeProperty.getName());

        codeMethod.stepStatement("return " + NameExtension.toLowerCamelCase(codeProperty.getName()) + ";");

        return codeMethod;
    }

    private CodeMethod BuildMethod_SetMethod(CodeProperty codeProperty) {
        CodeMethod codeMethod = new CodeMethod();
        codeMethod.setAccessModifiers(AccessModifiers.Public);
        codeMethod.setIsStatic(codeProperty.getIsStatic());
        codeMethod.setReturnType("void");

        codeMethod.setName("set" + codeProperty.getName());

        codeMethod.addParameter(codeProperty.getType(), NameExtension.toLowerCamelCase(codeProperty.getName()));

        codeMethod.stepStatement("this." + NameExtension.toLowerCamelCase(codeProperty.getName()) + " = " + NameExtension.toLowerCamelCase(codeProperty.getName()) + ";");

        return codeMethod;
    }

    /**
     * 生成摘要
     *
     * @param summary    summary
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateSummary(String summary, CodeWriter codeWriter, GenerateOptions options) {
        if (Strings.isNullOrEmpty(summary)) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        String[] lines = summary.split("[\r\n]");

        codeWriter.write(options.getIndentString()).writeLine("/**");
        for (String line : lines) {
            if (Strings.isNullOrEmpty(line)) {
                continue;
            }
            codeWriter.write(options.getIndentString()).write(" * ").writeLine(line);
        }
        codeWriter.write(options.getIndentString()).writeLine(" */");
    }

    /**
     * ${param} -&gt; ${expression}
     *
     * @param lamda      lamda
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateLamdaExpression(CodeLamdaExpression lamda, CodeWriter codeWriter, GenerateOptions options) {
        if (lamda == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        // x -> new ${ClassName}
        codeWriter.write(lamda.getParameter())
                .write(Marks.WHITESPACE).write(Marks.MINUS).write(Marks.GREATER_THAN).write(Marks.WHITESPACE)
                .write(lamda.getExpression());
    }

    /**
     * x -&gt; new Studengt()
     *
     * @param lamda      lamda
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateLamdaNewInstance(CodeLamdaNewInstance lamda, CodeWriter codeWriter, GenerateOptions options) {
        if (lamda == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        // x => new ${ClassName}
        codeWriter.write(lamda.getParameter()).write(Marks.WHITESPACE).write(Marks.EQUAL).write(Marks.GREATER_THAN).write(Marks.WHITESPACE)
                .write(Keywords.NEW);

        if (!Strings.isNullOrEmpty(lamda.getClassName())) {
            codeWriter.write(Marks.WHITESPACE).write(lamda.getClassName());
        }

        if (lamda.getStatements() == null || lamda.getStatements().isEmpty()) {
            codeWriter.write(Marks.LEFT_BRACKET).write(Marks.RIGHT_BRACKET);
            return;
        }

        codeWriter.writeLine();

        codeWriter.write(options.getIndentString()).writeLine(Marks.LEFT_BRACE);
        options.pushIndent();

        Iterator<String> enumerator = lamda.getStatements().iterator();
        boolean moveNext = enumerator.hasNext();
        while (moveNext) {
            codeWriter.write(options.getIndentString()).write(enumerator.next());

            moveNext = enumerator.hasNext();
            if (moveNext) {
                codeWriter.write(Marks.COMMA);
            }

            codeWriter.writeLine();
        }

        options.PopIndent();
        codeWriter.write(options.getIndentString()).write(Marks.RIGHT_BRACE);
    }

    /**
     * ${param} -&gt; ${expression}
     *
     * @param lamda      lamda
     * @param codeWriter codeWriter
     * @param options    options
     */
    public void generateLamdaStepBuilderCollection(CodeLamdaStepBuilderCollection lamda, CodeWriter codeWriter, GenerateOptions options) {
        if (lamda == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(lamda.getParameter())
                .write(Marks.WHITESPACE).write(Marks.MINUS).writeLine(Marks.GREATER_THAN);

        codeWriter.write(options.getIndentString()).writeLine(Marks.LEFT_BRACE);
        options.pushIndent();

        generateStepBuilderOrCollectionList(lamda.getStepBuilders(), codeWriter, options);

        options.PopIndent();
        codeWriter.write(options.getIndentString()).write(Marks.RIGHT_BRACE);
    }

    /**
     * GenerateForeachStepBuilder
     *
     * @param foreachStepBuilder foreachStepBuilder
     * @param codeWriter         codeWriter
     * @param options            options
     */
    public void generateForeachStepBuilder(ForeachStepBuilder foreachStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        codeWriter.write(options.getIndentString()).write(Keywords.FOR).write(Marks.WHITESPACE).write(Marks.LEFT_BRACKET)
                .write(foreachStepBuilder.getType()).write(Marks.WHITESPACE)
                .write(foreachStepBuilder.getItem()).write(Marks.WHITESPACE)
                .write(Marks.COLON).write(Marks.WHITESPACE)
                .write(foreachStepBuilder.getItems())
                .write(Marks.RIGHT_BRACKET)
                .write(Marks.WHITESPACE);

        generateStepBuilderOrCollectionListAsBlock(foreachStepBuilder.getStepBuilders(), codeWriter, options);
    }

    /**
     * GenerateForStepBuilder
     *
     * @param forStepBuilder forStepBuilder
     * @param codeWriter     codeWriter
     * @param options        options
     */
    public void generateForStepBuilder(ForStepBuilder forStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        codeWriter.write(options.getIndentString()).write(Keywords.FOR).write(Marks.WHITESPACE).write(Marks.LEFT_BRACKET)
                .write(forStepBuilder.getStart()).write(Marks.SEMICOLON).write(Marks.WHITESPACE)
                .write(forStepBuilder.getMiddle()).write(Marks.SEMICOLON).write(Marks.WHITESPACE)
                .write(forStepBuilder.getEnd())
                .write(Marks.RIGHT_BRACKET)
                .write(Marks.WHITESPACE);

        generateStepBuilderOrCollectionListAsBlock(forStepBuilder.getStepBuilders(), codeWriter, options);
    }

    /**
     * GeneratePushIndentStepBuilder
     *
     * @param pushIndentStepBuilder pushIndentStepBuilder
     * @param codeWriter            codeWriter
     * @param options               options
     */
    public void generatePushIndentStepBuilder(PushIndentStepBuilder pushIndentStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        codeWriter.write(options.getIndentString()).writeLine(pushIndentStepBuilder.getKey());

        if (pushIndentStepBuilder.getStepBuilders() == null || pushIndentStepBuilder.getStepBuilders().isEmpty()) {
            return;
        }

        options.pushIndent();

        for (StepBuilderOrCollection item : pushIndentStepBuilder.getStepBuilders()) {
            generateStepBuilderOrCollection(item, codeWriter, options);
        }

        options.PopIndent();
    }

    /**
     * GenerateStatementStepBuilder
     *
     * @param statementStepBuilder statementStepBuilder
     * @param codeWriter           codeWriter
     * @param options              options
     */
    public void generateStatementStepBuilder(StatementStepBuilder statementStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        codeWriter.write(options.getIndentString()).writeLine(statementStepBuilder.getStatement());
    }

    /**
     * 生成方法步骤
     *
     * @param stepBuilder stepBuilder
     * @param codeWriter  codeWriter
     * @param options     options
     */
    public void generateStepBuilderOrCollection(StepBuilderOrCollection stepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        if (stepBuilder == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        if (stepBuilder instanceof EmptyStepBuilder) {
            codeWriter.writeLine();
        }

        if (stepBuilder instanceof StatementStepBuilder) {
            generateStatementStepBuilder((StatementStepBuilder) stepBuilder, codeWriter, options);
        }

        if (stepBuilder instanceof IfStepBuilder) {
            generateIfStepBuilder((IfStepBuilder) stepBuilder, codeWriter, options);
        }

        if (stepBuilder instanceof TryStepBuilder) {
            generateTryStepBuilder((TryStepBuilder) stepBuilder, codeWriter, options);
        }

        if (stepBuilder instanceof ForeachStepBuilder) {
            generateForeachStepBuilder((ForeachStepBuilder) stepBuilder, codeWriter, options);
        }

        if (stepBuilder instanceof ForStepBuilder) {
            generateForStepBuilder((ForStepBuilder) stepBuilder, codeWriter, options);
        }

        if (stepBuilder instanceof PushIndentStepBuilder) {
            generatePushIndentStepBuilder((PushIndentStepBuilder) stepBuilder, codeWriter, options);
        }

        if (stepBuilder instanceof AssignStringVariableStepBuilder) {
            generateAssignStringVariableStepBuilder((AssignStringVariableStepBuilder) stepBuilder, codeWriter, options);
        }
    }

    /**
     * generateIfStepBuilder
     *
     * @param ifStepBuilder ifStepBuilder
     * @param codeWriter    codeWriter
     * @param options       options
     */
    public void generateIfStepBuilder(IfStepBuilder ifStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        codeWriter.write(options.getIndentString()).write(Keywords.IF).write(Marks.WHITESPACE)
                .write(Marks.LEFT_BRACKET).write(ifStepBuilder.getCondition()).write(Marks.RIGHT_BRACKET);

        generateStepBuilderOrCollectionListAsPartialBlock(ifStepBuilder.getStepBuilders(), codeWriter, options);

        if (ifStepBuilder.getElseIfStepBuilders() != null && !ifStepBuilder.getElseIfStepBuilders().isEmpty()) {
            for (ElseIfStepBuilder elseIfStepBuilder : ifStepBuilder.getElseIfStepBuilders()) {
                generateElseIfStepBuilder(elseIfStepBuilder, codeWriter, options);
            }
        }

        if (ifStepBuilder.getElseStepBuilder() != null) {
            generateElseStepBuilder(ifStepBuilder.getElseStepBuilder(), codeWriter, options);
        }

        codeWriter.writeLine();
    }

    /**
     * generateTryStepBuilder
     *
     * @param tryStepBuilder tryStepBuilder
     * @param codeWriter     codeWriter
     * @param options        options
     */
    public void generateTryStepBuilder(TryStepBuilder tryStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        if (tryStepBuilder == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(options.getIndentString()).write(Keywords.TRY);

        generateStepBuilderOrCollectionListAsPartialBlock(tryStepBuilder.getStepBuilders(), codeWriter, options);

        if (tryStepBuilder.getCatchStepBuilders() != null && !tryStepBuilder.getCatchStepBuilders().isEmpty()) {
            for (CatchStepBuilder catchStepBuilder : tryStepBuilder.getCatchStepBuilders()) {
                generateCacheStepBuilder(catchStepBuilder, codeWriter, options);
            }
        }

        generateFinallyStepBuilder(tryStepBuilder.getFinallyStepBuilder(), codeWriter, options);

        codeWriter.writeLine();
    }

    public void generateStepBuilderOrCollectionListAsPartialBlock(List<StepBuilderOrCollection> stepBuilders, CodeWriter codeWriter, GenerateOptions options) {
        codeWriter.write(Marks.WHITESPACE).writeLine(Marks.LEFT_BRACE);
        options.pushIndent();

        generateStepBuilderOrCollectionList(stepBuilders, codeWriter, options);

        options.PopIndent();
        codeWriter.write(options.getIndentString()).write(Marks.RIGHT_BRACE);
    }

    public void generateStepBuilderOrCollectionListAsBlock(List<StepBuilderOrCollection> stepBuilders, CodeWriter codeWriter, GenerateOptions options) {
        codeWriter.write(options.getIndentString()).writeLine(Marks.LEFT_BRACE);
        options.pushIndent();

        generateStepBuilderOrCollectionList(stepBuilders, codeWriter, options);

        options.PopIndent();
        codeWriter.write(options.getIndentString()).writeLine(Marks.RIGHT_BRACE);
    }

    public void generateStepBuilderOrCollectionList(List<StepBuilderOrCollection> stepBuilders, CodeWriter codeWriter, GenerateOptions options) {
        if (stepBuilders == null || stepBuilders.isEmpty()) {
            return;
        }

        for (StepBuilderOrCollection item : stepBuilders) {
            generateStepBuilderOrCollection(item, codeWriter, options);
        }
    }

    public void generateElseIfStepBuilder(ElseIfStepBuilder elseIfStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        if (elseIfStepBuilder == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(Marks.WHITESPACE).write(Keywords.ELSE).write(Marks.WHITESPACE)
                .write(Keywords.IF).write(Marks.WHITESPACE)
                .write(Marks.LEFT_BRACKET).write(elseIfStepBuilder.getCondition())
                .write(Marks.RIGHT_BRACKET);

        generateStepBuilderOrCollectionListAsPartialBlock(elseIfStepBuilder.getStepBuilders(), codeWriter, options);
    }

    public void generateElseStepBuilder(ElseStepBuilder elseStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        if (elseStepBuilder == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(Marks.WHITESPACE).write(Keywords.ELSE);

        generateStepBuilderOrCollectionListAsPartialBlock(elseStepBuilder.getStepBuilders(), codeWriter, options);
    }

    public void generateCacheStepBuilder(CatchStepBuilder catchStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        if (catchStepBuilder == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(Marks.WHITESPACE).write(Keywords.CATCH);

        if (!Strings.isNullOrEmpty(catchStepBuilder.getExceptionType())) {
            codeWriter.write(Marks.WHITESPACE).write(Marks.LEFT_BRACKET).write(catchStepBuilder.getExceptionType());

            if (!Strings.isNullOrEmpty(catchStepBuilder.getExceptionName())) {
                codeWriter.write(Marks.WHITESPACE).write(catchStepBuilder.getExceptionName());
            }

            codeWriter.write(Marks.RIGHT_BRACKET);
        }

        generateStepBuilderOrCollectionListAsPartialBlock(catchStepBuilder.getStepBuilders(), codeWriter, options);
    }

    public void generateFinallyStepBuilder(FinallyStepBuilder finallyStepBuilder, CodeWriter codeWriter, GenerateOptions options) {
        if (finallyStepBuilder == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(Marks.WHITESPACE).write(Keywords.FINALLY);

        generateStepBuilderOrCollectionListAsPartialBlock(finallyStepBuilder.getStepBuilders(), codeWriter, options);
    }
}
