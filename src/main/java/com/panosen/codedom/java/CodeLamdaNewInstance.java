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

public class CodeLamdaNewInstance extends DataItem {

    /**
     * 参数
     */
    private String parameter;

    /**
     * 类名
     */
    private String className;

    /**
     * 步骤集合
     */
    private StepBuilderCollection stepBuilderCollection;

    /**
     * Statements
     */
    private List<String> statements;

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
     * [getter] 类名
     *
     * @return String
     */
    public String getClassName() {
        return className;
    }

    /**
     * [setter] 类名
     *
     * @param className className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * [getter] 步骤集合
     *
     * @return StepBuilderCollection
     */
    public StepBuilderCollection getStepBuilderCollection() {
        return stepBuilderCollection;
    }

    /**
     * [setter] 步骤集合
     *
     * @param stepBuilderCollection stepBuilderCollection
     */
    public void setStepBuilderCollection(StepBuilderCollection stepBuilderCollection) {
        this.stepBuilderCollection = stepBuilderCollection;
    }

    /**
     * [getter] Statements
     *
     * @return List&lt;String&gt;
     */
    public List<String> getStatements() {
        return statements;
    }

    /**
     * [setter] Statements
     *
     * @param statements statements
     */
    public void setStatements(List<String> statements) {
        this.statements = statements;
    }

    public CodeLamdaNewInstance StepStatement(String statement) {
        if (this.statements == null) {
            this.statements = Lists.newArrayList();
        }
        this.statements.add(statement);
        return this;
    }
}
