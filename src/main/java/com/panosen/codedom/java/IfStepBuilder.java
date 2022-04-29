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


public class IfStepBuilder extends StepBuilderCollection {

    /**
     * Condition
     */
    private String condition;

    /**
     * ElseIfStepBuilders
     */
    private List<ElseIfStepBuilder> elseIfStepBuilders;

    /**
     * ElseStepBuilder
     */
    private ElseStepBuilder elseStepBuilder;

    /**
     * [getter] Condition
     *
     * @return String
     */
    public String getCondition() {
        return condition;
    }

    /**
     * [setter] Condition
     *
     * @param condition condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * [getter] ElseIfStepBuilders
     *
     * @return List&lt;ElseIfStepBuilder&gt;
     */
    public List<ElseIfStepBuilder> getElseIfStepBuilders() {
        return elseIfStepBuilders;
    }

    /**
     * [setter] ElseIfStepBuilders
     *
     * @param elseIfStepBuilders elseIfStepBuilders
     */
    public void setElseIfStepBuilders(List<ElseIfStepBuilder> elseIfStepBuilders) {
        this.elseIfStepBuilders = elseIfStepBuilders;
    }

    /**
     * [getter] ElseStepBuilder
     *
     * @return ElseStepBuilder
     */
    public ElseStepBuilder getElseStepBuilder() {
        return elseStepBuilder;
    }

    /**
     * [setter] ElseStepBuilder
     *
     * @param elseStepBuilder elseStepBuilder
     */
    public void setElseStepBuilder(ElseStepBuilder elseStepBuilder) {
        this.elseStepBuilder = elseStepBuilder;
    }

    /**
     * WithElseIf
     *
     * @param condition condition
     * @return ElseIfStepBuilder
     */
    public ElseIfStepBuilder withElseIf(String condition) {
        if (this.elseIfStepBuilders == null) {
            this.elseIfStepBuilders = Lists.newArrayList();
        }
        ElseIfStepBuilder elseIfStepBuilder = new ElseIfStepBuilder();
        elseIfStepBuilder.setCondition(condition);
        this.elseIfStepBuilders.add(elseIfStepBuilder);
        return elseIfStepBuilder;
    }

    /**
     * WithElse
     *
     * @return ElseStepBuilder
     */
    public ElseStepBuilder withElse() {
        ElseStepBuilder elseStepBuilder = new ElseStepBuilder();
        this.elseStepBuilder = elseStepBuilder;
        return elseStepBuilder;
    }
}
