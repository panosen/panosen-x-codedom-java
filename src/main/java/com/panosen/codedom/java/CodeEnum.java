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

import java.util.List;


public class CodeEnum extends CodeObject {

    /**
     * 访问修饰符
     */
    private AccessModifiers accessModifiers;

    /**
     * 字段
     */
    private List<CodeEnumValue> valueList;

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
     * [getter] 字段
     *
     * @return List&lt;CodeEnumValue&gt;
     */
    public List<CodeEnumValue> getValueList() {
        return valueList;
    }

    /**
     * [setter] 字段
     *
     * @param valueList valueList
     */
    public void setValueList(List<CodeEnumValue> valueList) {
        this.valueList = valueList;
    }

    public CodeEnum addValue(CodeEnumValue enumValue) {
        if (this.valueList == null) {
            this.valueList = Lists.newArrayList();
        }
        this.valueList.add(enumValue);
        return this;
    }

    /**
     * 添加枚举值
     *
     * @param name    name
     * @param summary summary
     * @param value   value
     * @return CodeEnumValue
     */
    public CodeEnumValue addValue(String name, String summary, DataItem value) {
        if (this.valueList == null) {
            this.valueList = Lists.newArrayList();
        }
        CodeEnumValue codeEnumValue = new CodeEnumValue();
        codeEnumValue.setName(name);
        codeEnumValue.setSummary(summary);
        codeEnumValue.setValue(value);
        this.valueList.add(codeEnumValue);
        return codeEnumValue;
    }
}
