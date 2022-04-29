package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */


public class CodeFieldReferenceExpression extends CodeExpression {

    /**
     * TargetObject
     */
    private CodeExpression targetObject;

    /**
     * FieldName
     */
    private String fieldName;

    /**
     * [getter] TargetObject
     *
     * @return CodeExpression
     */
    public CodeExpression getTargetObject() {
        return targetObject;
    }

    /**
     * [setter] TargetObject
     *
     * @param targetObject targetObject
     */
    public void setTargetObject(CodeExpression targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * [getter] FieldName
     *
     * @return String
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * [setter] FieldName
     *
     * @param fieldName fieldName
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
