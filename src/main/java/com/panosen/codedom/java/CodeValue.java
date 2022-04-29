package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */


public class CodeValue {

    /**
     * 类型
     */
    private CodeValueType type;

    /**
     * 值
     */
    private String value;

    /**
     * [getter] 类型
     *
     * @return CodeValueType
     */
    public CodeValueType getType() {
        return type;
    }

    /**
     * [setter] 类型
     *
     * @param type type
     */
    public void setType(CodeValueType type) {
        this.type = type;
    }

    /**
     * [getter] 值
     *
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * [setter] 值
     *
     * @param value value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
