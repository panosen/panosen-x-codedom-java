package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */


public class CodeConstant extends CodeObject {

    /**
     * 访问修饰符
     */
    private AccessModifiers accessModifiers;

    /**
     * Type
     */
    private String type;

    /**
     * Value
     */
    private String value;

    /**
     * [getter] 访问修饰符
     *
     * @return AccessModifiers
     */
    public AccessModifiers getAccessModifiers() {
        return accessModifiers;
    }

    /**
     * [setter] 访问修饰符
     *
     * @param accessModifiers accessModifiers
     */
    public void setAccessModifiers(AccessModifiers accessModifiers) {
        this.accessModifiers = accessModifiers;
    }

    /**
     * [getter] Type
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * [setter] Type
     *
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

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
}
