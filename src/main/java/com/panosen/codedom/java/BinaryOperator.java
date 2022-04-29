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

    /// <summary>
    /// BinaryOperator
    /// </summary>
    public static BinaryOperator fromEnum(EnumBinaryOperator binaryOperator) {
        switch (binaryOperator) {
            case Add:
                return Add;

            case Subtract:
                return Subtract;

            case Multiply:
                return Multiply;

            case Divide:
                return Divide;

            case Modulus:
                return Modulus;

            case Assign:
                return Assign;

            case IdentityInequality:
                return IdentityInequality;

            case IdentityEquality:
                return IdentityEquality;

            case ValueEquality:
                return ValueEquality;

            case BitwiseOr:
                return BitwiseOr;

            case BitwiseAnd:
                return BitwiseAnd;

            case BooleanOr:
                return BooleanOr;

            case BooleanAnd:
                return BooleanAnd;

            case LessThan:
                return LessThan;

            case LessThanOrEqual:
                return LessThanOrEqual;

            case GreaterThan:
                return GreaterThan;

            case GreaterThanOrEqual:
                return GreaterThanOrEqual;

            default:
                break;
        }

        return new BinaryOperator("");
    }
}
