package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

/**
 * 访问修饰符
 */
public enum AccessModifiers {

    /**
     * Public
     */
    Public,

    /**
     * Private
     */
    Private,

    /**
     * Protected
     */
    Protected;

    /**
     * 值
     *
     * @return String
     */
    public String getValue() {
        switch (this) {
            case Public:
                return "public";
            case Private:
                return "private";
            case Protected:
                return "protected";
            default:
                return "";
        }
    }
}
