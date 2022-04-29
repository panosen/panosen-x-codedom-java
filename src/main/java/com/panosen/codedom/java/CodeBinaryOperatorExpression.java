package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */


public class CodeBinaryOperatorExpression extends CodeExpression {

    /**
     * Operator
     */
    private BinaryOperator operator;

    /**
     * Left
     */
    private String left;

    /**
     * Right
     */
    private String right;

    /**
     * [getter] Operator
     *
     * @return BinaryOperator
     */
    public BinaryOperator getOperator() {
        return operator;
    }

    /**
     * [setter] Operator
     *
     * @param operator operator
     */
    public void setOperator(BinaryOperator operator) {
        this.operator = operator;
    }

    /**
     * [getter] Left
     *
     * @return String
     */
    public String getLeft() {
        return left;
    }

    /**
     * [setter] Left
     *
     * @param left left
     */
    public void setLeft(String left) {
        this.left = left;
    }

    /**
     * [getter] Right
     *
     * @return String
     */
    public String getRight() {
        return right;
    }

    /**
     * [setter] Right
     *
     * @param right right
     */
    public void setRight(String right) {
        this.right = right;
    }
}
