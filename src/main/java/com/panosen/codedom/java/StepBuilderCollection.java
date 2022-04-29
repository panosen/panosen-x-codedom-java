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


public class StepBuilderCollection extends StepBuilderOrCollection {

    /**
     * IStepBuilderCollection.StepBuilders
     */
    private List<StepBuilderOrCollection> stepBuilders;

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
     * step
     *
     * @param stepBuilder stepBuilder
     * @return StepBuilderCollection
     */
    public StepBuilderCollection step(StepBuilder stepBuilder) {
        if (this.stepBuilders == null) {
            this.stepBuilders = Lists.newArrayList();
        }
        this.stepBuilders.add(stepBuilder);
        return this;
    }

    /**
     * stepEmpty
     *
     * @return StepBuilderCollection
     */
    public StepBuilderCollection stepEmpty() {
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
     * @return StepBuilderCollection
     */
    public StepBuilderCollection stepStatement(String statement) {
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
