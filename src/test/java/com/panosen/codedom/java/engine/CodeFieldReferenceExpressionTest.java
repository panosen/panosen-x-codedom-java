package com.panosen.codedom.java.engine;

import com.panosen.codedom.java.CodeFieldReferenceExpression;
import com.panosen.codedom.java.CodeThisReferenceExpression;

public class CodeFieldReferenceExpressionTest extends UTBase {

    @Override
    protected String PrepareExpected() {
        return "this.Name";
    }

    @Override
    protected com.panosen.codedom.java.Code PrepareCode() {
        CodeFieldReferenceExpression codeExpression = new CodeFieldReferenceExpression();
        codeExpression.setTargetObject(new CodeThisReferenceExpression());
        codeExpression.setFieldName("Name");

        return codeExpression;
    }
}
