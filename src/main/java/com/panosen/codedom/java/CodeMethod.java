package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import com.google.common.collect.Lists;

import java.util.List;


public class CodeMethod extends CodeObject {

    /**
     * 类型
     */
    private String returnType;

    /**
     * 访问修饰符
     */
    private AccessModifiers accessModifiers;

    /**
     * 参数
     */
    private List<CodeParameter> parameters;

    /**
     * 特性
     */
    private List<CodeAttribute> attributeList;

    /**
     * 异常
     */
    private List<String> exceptionList;

    /**
     * static
     */
    private Boolean isStatic;

    /**
     * synchronized
     */
    private Boolean isSynchronized;

    /**
     * IStepBuilderCollection.StepBuilders
     */
    private List<StepBuilderOrCollection> stepBuilders;

    /**
     * [getter] 类型
     *
     * @return String
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * [setter] 类型
     *
     * @param returnType returnType
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    /**
     * [getter] 访问修饰符
     *
     * @return AccessModifiers
     */
    public AccessModifiers getAccessModifiers() {
        return accessModifiers;
    }

    /**
     * [setter] 访问修饰符
     *
     * @param accessModifiers accessModifiers
     */
    public void setAccessModifiers(AccessModifiers accessModifiers) {
        this.accessModifiers = accessModifiers;
    }

    /**
     * [getter] 参数
     *
     * @return List&lt;CodeParameter&gt;
     */
    public List<CodeParameter> getParameters() {
        return parameters;
    }

    /**
     * [setter] 参数
     *
     * @param parameters parameters
     */
    public void setParameters(List<CodeParameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * [getter] 特性
     *
     * @return List&lt;CodeAttribute&gt;
     */
    public List<CodeAttribute> getAttributeList() {
        return attributeList;
    }

    /**
     * [setter] 特性
     *
     * @param attributeList attributeList
     */
    public void setAttributeList(List<CodeAttribute> attributeList) {
        this.attributeList = attributeList;
    }

    /**
     * [getter] 异常
     *
     * @return List&lt;String&gt;
     */
    public List<String> getExceptionList() {
        return exceptionList;
    }

    /**
     * [setter] 异常
     *
     * @param exceptionList exceptionList
     */
    public void setExceptionList(List<String> exceptionList) {
        this.exceptionList = exceptionList;
    }

    /**
     * [getter] static
     *
     * @return Boolean
     */
    public Boolean getIsStatic() {
        return isStatic;
    }

    /**
     * [setter] static
     *
     * @param isStatic isStatic
     */
    public void setIsStatic(Boolean isStatic) {
        this.isStatic = isStatic;
    }

    /**
     * [getter] synchronized
     *
     * @return Boolean
     */
    public Boolean getIsSynchronized() {
        return isSynchronized;
    }

    /**
     * [setter] synchronized
     *
     * @param isSynchronized isSynchronized
     */
    public void setIsSynchronized(Boolean isSynchronized) {
        this.isSynchronized = isSynchronized;
    }

    /**
     * [getter] IStepBuilderCollection.StepBuilders
     *
     * @return List&lt;StepBuilderOrCollection&gt;
     */
    public List<StepBuilderOrCollection> getStepBuilders() {
        return stepBuilders;
    }

    /**
     * [setter] IStepBuilderCollection.StepBuilders
     *
     * @param stepBuilders stepBuilders
     */
    public void setStepBuilders(List<StepBuilderOrCollection> stepBuilders) {
        this.stepBuilders = stepBuilders;
    }

    /**
     * AddParameter
     *
     * @param parameter parameter
     * @return CodeParameter
     */
    public CodeParameter addParameter(CodeParameter parameter) {
        if (this.parameters == null) {
            this.parameters = Lists.newArrayList();
        }
        this.parameters.add(parameter);
        return parameter;
    }

    /**
     * AddParameter
     *
     * @param summary summary
     * @param name    name
     * @param type    type
     * @return CodeParameter
     */
    public CodeParameter addParameter(String type, String name, String summary) {
        if (this.parameters == null) {
            this.parameters = Lists.newArrayList();
        }
        CodeParameter parameter = new CodeParameter();
        parameter.setType(type);
        parameter.setName(name);
        parameter.setSummary(summary);
        this.parameters.add(parameter);
        return parameter;
    }

    /**
     * AddAttribute
     *
     * @param codeAttribute codeAttribute
     * @return CodeMethod
     */
    public CodeMethod addAttribute(CodeAttribute codeAttribute) {
        if (this.attributeList == null) {
            this.attributeList = Lists.newArrayList();
        }
        this.attributeList.add(codeAttribute);
        return this;
    }

    /**
     * AddAttribute
     *
     * @param name name
     * @return CodeAttribute
     */
    public CodeAttribute addAttribute(String name) {
        if (this.attributeList == null) {
            this.attributeList = Lists.newArrayList();
        }
        CodeAttribute codeAttribute = new CodeAttribute();
        codeAttribute.setName(name);
        this.attributeList.add(codeAttribute);
        return codeAttribute;
    }

    /**
     * AddException
     *
     * @param exception exception
     * @return CodeMethod
     */
    public CodeMethod addException(String exception) {
        if (this.exceptionList == null) {
            this.exceptionList = Lists.newArrayList();
        }
        this.exceptionList.add(exception);
        return this;
    }

    /**
     * step
     *
     * @param stepBuilder stepBuilder
     * @return CodeMethod
     */
    public CodeMethod step(StepBuilder stepBuilder) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        this.stepBuilders.add(stepBuilder);
        return this;
    }

    /**
     * stepEmpty
     *
     * @return CodeMethod
     */
    public CodeMethod stepEmpty() {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        EmptyStepBuilder emptyStepBuilder = new EmptyStepBuilder();
        this.stepBuilders.add(emptyStepBuilder);
        return this;
    }

    /**
     * stepStatement
     *
     * @param statement statement
     * @return CodeMethod
     */
    public CodeMethod stepStatement(String statement) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        StatementStepBuilder statementStepBuilder = new StatementStepBuilder();
        statementStepBuilder.setStatement(statement);
        this.stepBuilders.add(statementStepBuilder);
        return this;
    }

    /**
     * stepIf
     *
     * @param condition condition
     * @return IfStepBuilder
     */
    public IfStepBuilder stepIf(String condition) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        IfStepBuilder ifStepBuilder = new IfStepBuilder();
        ifStepBuilder.setCondition(condition);
        this.stepBuilders.add(ifStepBuilder);
        return ifStepBuilder;
    }

    /**
     * stepTry
     *
     * @return TryStepBuilder
     */
    public TryStepBuilder stepTry() {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        TryStepBuilder tryStepBuilder = new TryStepBuilder();
        this.stepBuilders.add(tryStepBuilder);
        return tryStepBuilder;
    }

    /**
     * stepForeach
     *
     * @param item  item
     * @param items items
     * @return ForeachStepBuilder
     */
    public ForeachStepBuilder stepForeach(String item, String items) {
        return stepForeach(null, item, items);
    }

    /**
     * stepForeach
     *
     * @param type  type
     * @param item  item
     * @param items items
     * @return ForeachStepBuilder
     */
    public ForeachStepBuilder stepForeach(String type, String item, String items) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        ForeachStepBuilder foreachStepBuilder = new ForeachStepBuilder();
        foreachStepBuilder.setType(type);
        foreachStepBuilder.setItem(item);
        foreachStepBuilder.setItems(items);
        this.stepBuilders.add(foreachStepBuilder);
        return foreachStepBuilder;
    }

    /**
     * stepFor
     *
     * @param start  start
     * @param middle middle
     * @param end    end
     * @return ForStepBuilder
     */
    public ForStepBuilder stepFor(String start, String middle, String end) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        ForStepBuilder forStepBuilder = new ForStepBuilder();
        forStepBuilder.setStart(start);
        forStepBuilder.setMiddle(middle);
        forStepBuilder.setEnd(end);
        this.stepBuilders.add(forStepBuilder);
        return forStepBuilder;
    }

    /**
     * stepPushIndent
     *
     * @param key key
     * @return PushIndentStepBuilder
     */
    public PushIndentStepBuilder stepPushIndent(String key) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        PushIndentStepBuilder pushIndentStepBuilder = new PushIndentStepBuilder();
        pushIndentStepBuilder.setKey(key);
        this.stepBuilders.add(pushIndentStepBuilder);
        return pushIndentStepBuilder;
    }

    /**
     * stepAssignStringVariable
     *
     * @param name  name
     * @param value value
     * @return AssignStringVariableStepBuilder
     */
    public AssignStringVariableStepBuilder stepAssignStringVariable(String name, String value) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        AssignStringVariableStepBuilder assignStringVariableStepBuilder = new AssignStringVariableStepBuilder();
        assignStringVariableStepBuilder.setName(name);
        assignStringVariableStepBuilder.setValue(value);
        this.stepBuilders.add(assignStringVariableStepBuilder);
        return assignStringVariableStepBuilder;
    }
}
