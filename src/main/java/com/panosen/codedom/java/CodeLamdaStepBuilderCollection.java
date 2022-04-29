package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import java.util.List;

import com.google.common.collect.Lists;
import com.panosen.codedom.DataItem;

public class CodeLamdaStepBuilderCollection extends DataItem {

    /**
     * 参数
     */
    private String parameter;

    /**
     * 步骤
     */
    private List<StepBuilderOrCollection> stepBuilders;

    /**
     * [getter] 参数
     *
     * @return String
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * [setter] 参数
     *
     * @param parameter parameter
     */
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    /**
     * [getter] 步骤
     *
     * @return List&lt;StepBuilderOrCollection&gt;
     */
    public List<StepBuilderOrCollection> getStepBuilders() {
        return stepBuilders;
    }

    /**
     * [setter] 步骤
     *
     * @param stepBuilders stepBuilders
     */
    public void setStepBuilders(List<StepBuilderOrCollection> stepBuilders) {
        this.stepBuilders = stepBuilders;
    }


    public CodeLamdaStepBuilderCollection step(StepBuilder stepBuilder) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        this.stepBuilders.add(stepBuilder);
        return this;
    }

    public CodeLamdaStepBuilderCollection stepEmpty() {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        EmptyStepBuilder emptyStepBuilder = new EmptyStepBuilder();
        this.stepBuilders.add(emptyStepBuilder);
        return this;
    }

    public CodeLamdaStepBuilderCollection stepStatement(String statement) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        StatementStepBuilder statementStepBuilder = new StatementStepBuilder();
        statementStepBuilder.setStatement(statement);
        this.stepBuilders.add(statementStepBuilder);
        return this;
    }

    public IfStepBuilder stepIf(String condition) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        IfStepBuilder ifStepBuilder = new IfStepBuilder();
        ifStepBuilder.setCondition(condition);
        this.stepBuilders.add(ifStepBuilder);
        return ifStepBuilder;
    }

    public TryStepBuilder stepTry() {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        TryStepBuilder tryStepBuilder = new TryStepBuilder();
        this.stepBuilders.add(tryStepBuilder);
        return tryStepBuilder;
    }

    public ForeachStepBuilder stepForeach(String item, String items) {
        return stepForeach(null, item, items);
    }

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

    public PushIndentStepBuilder stepPushIndent(String key) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        PushIndentStepBuilder pushIndentStepBuilder = new PushIndentStepBuilder();
        pushIndentStepBuilder.setKey(key);
        this.stepBuilders.add(pushIndentStepBuilder);
        return pushIndentStepBuilder;
    }

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
