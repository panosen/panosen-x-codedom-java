package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import com.google.common.collect.Lists;
import com.panosen.codedom.DataItem;
import com.panosen.codedom.DataValue;

import java.util.List;


public class CodeProperty extends CodeMember {

    /**
     * 访问修饰符
     */
    private AccessModifiers accessModifiers;

    /**
     * 类型
     */
    private String type;

    /**
     * 特性
     */
    private List<CodeAttribute> attributeList;

    /**
     * 值
     */
    private List<DataItem> valueList;

    /**
     * static
     */
    private boolean isStatic;

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
     * [getter] 类型
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * [setter] 类型
     *
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * [getter] 特性
     *
     * @return List&lt;CodeAttribute&gt;
     */
    public List<CodeAttribute> getAttributeList() {
        return attributeList;
    }

    /**
     * [setter] 特性
     *
     * @param attributeList attributeList
     */
    public void setAttributeList(List<CodeAttribute> attributeList) {
        this.attributeList = attributeList;
    }

    /**
     * [getter] 值
     *
     * @return List&lt;CodeValue&gt;
     */
    public List<DataItem> getValueList() {
        return valueList;
    }

    /**
     * [setter] 值
     *
     * @param valueList valueList
     */
    public void setValueList(List<DataItem> valueList) {
        this.valueList = valueList;
    }

    /**
     * [getter] static
     *
     * @return Boolean
     */
    public boolean getIsStatic() {
        return isStatic;
    }

    /**
     * [setter] static
     *
     * @param isStatic isStatic
     */
    public void setIsStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    /**
     * AddAttribute
     *
     * @param codeAttribute codeAttribute
     * @return CodeProperty
     */
    public CodeProperty addAttribute(CodeAttribute codeAttribute) {
        if (this.attributeList == null) {
            this.attributeList = Lists.newArrayList();
        }
        this.attributeList.add(codeAttribute);
        return this;
    }

    /**
     * AddAttribute
     *
     * @param name name
     * @return CodeAttribute
     */
    public CodeAttribute addAttribute(String name) {
        if (this.attributeList == null) {
            this.attributeList = Lists.newArrayList();
        }
        CodeAttribute codeAttribute = new CodeAttribute();
        codeAttribute.setName(name);
        this.attributeList.add(codeAttribute);
        return codeAttribute;
    }

    /**
     * AddValue
     *
     * @param codeValue codeValue
     * @return CodeProperty
     */
    public CodeProperty addValue(DataValue codeValue) {
        if (this.valueList == null) {
            this.valueList = Lists.newArrayList();
        }
        this.valueList.add(codeValue);
        return this;
    }

    /**
     * AddStringValue
     *
     * @param value value
     * @return CodeProperty
     */
    public CodeProperty addStringValue(String value) {
        if (this.valueList == null) {
            this.valueList = Lists.newArrayList();
        }
        this.valueList.add(DataValue.doubleQuotationString(value));
        return this;
    }

    /**
     * AddPlainValue
     *
     * @param value value
     * @return CodeProperty
     */
    public CodeProperty addPlainValue(String value) {
        if (this.valueList == null) {
            this.valueList = Lists.newArrayList();
        }
        this.valueList.add(DataValue.ofString(value));
        return this;
    }
}
