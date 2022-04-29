package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import com.panosen.codedom.DataItem;

public class CodeLamdaExpression extends DataItem {

    /**
     * 参数
     */
    private String parameter;

    /**
     * ${Expression}
     */
    private String expression;

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
     * [getter] ${Expression}
     *
     * @return String
     */
    public String getExpression() {
        return expression;
    }

    /**
     * [setter] ${Expression}
     *
     * @param expression expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }
}
