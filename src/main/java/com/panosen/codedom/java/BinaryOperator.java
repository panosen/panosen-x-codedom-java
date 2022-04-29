package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

public class BinaryOperator {

    /**
     * Value
     */
    private String value;

    /**
     * [getter] Value
     *
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * [setter] Value
     *
     * @param value value
     */
    public void setValue(String value) {
        this.value = value;
    }

    private BinaryOperator(String value) {
        this.value = value;
    }

    /// <summary>
    /// +
    /// </summary>
    public static final BinaryOperator Add = new BinaryOperator("+");

    /// <summary>
    /// -
    /// </summary>
    public static final BinaryOperator Subtract = new BinaryOperator("-");

    /// <summary>
    /// *
    /// </summary>
    public static final BinaryOperator Multiply = new BinaryOperator("*");

    /// <summary>
    /// /
    /// </summary>
    public static final BinaryOperator Divide = new BinaryOperator("/");

    /// <summary>
    /// %
    /// </summary>
    public static final BinaryOperator Modulus = new BinaryOperator("%");

    /// <summary>
    /// =
    /// </summary>
    public static final BinaryOperator Assign = new BinaryOperator("=");

    /// <summary>
    /// !=
    /// </summary>
    public static final BinaryOperator IdentityInequality = new BinaryOperator("!=");

    /// <summary>
    /// ==
    /// </summary>
    public static final BinaryOperator IdentityEquality = new BinaryOperator("==");

    /// <summary>
    /// ==
    /// </summary>
    public static final BinaryOperator ValueEquality = new BinaryOperator("==");

    /// <summary>
    /// |
    /// </summary>
    public static final BinaryOperator BitwiseOr = new BinaryOperator("|");

    /// <summary>
    /// &amp;
    /// </summary>
    public static final BinaryOperator BitwiseAnd = new BinaryOperator("&");

    /// <summary>
    /// ||
    /// </summary>
    public static final BinaryOperator BooleanOr = new BinaryOperator("||");

    /// <summary>
    /// &amp;&amp;
    /// </summary>
    public static final BinaryOperator BooleanAnd = new BinaryOperator("&&");

    /// <summary>
    /// &lt;
    /// </summary>
    public static final BinaryOperator LessThan = new BinaryOperator("<");

    /// <summary>
    /// &gt;=
    /// </summary>
    public static final BinaryOperator LessThanOrEqual = new BinaryOperator("<=");

    /// <summary>
    /// &gt;
    /// </summary>
    public static final BinaryOperator GreaterThan = new BinaryOperator(">=");

    /// <summary>
    /// &gt;=
    /// </summary>
    public static final BinaryOperator GreaterThanOrEqual = new BinaryOperator(">=");
}
