package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.BinaryOperator;
import com.panosen.codedom.java.CodeBinaryOperatorExpression;

public class CodeBinaryOperatorExpressionTest extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "a + b";
    }

    @Override
    protected com.panosen.codedom.java.Code PrepareCode() {
        CodeBinaryOperatorExpression codeExpression = new CodeBinaryOperatorExpression();
        codeExpression.setOperator(BinaryOperator.Add);
        codeExpression.setLeft("a");
        codeExpression.setRight("b");

        return codeExpression;
    }
}