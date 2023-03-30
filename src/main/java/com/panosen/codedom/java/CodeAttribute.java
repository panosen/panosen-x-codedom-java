package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.panosen.codedom.DataValue;
import org.checkerframework.checker.units.qual.C;

import java.util.List;
import java.util.Map;


public class CodeAttribute extends CodeObject {

    /**
     * ParamList
     */
    private List<CodeAttributeParam> paramList;

    /**
     * [getter] ParamList
     *
     * @return List&lt;CodeAttributeParam&gt;
     */
    public List<CodeAttributeParam> getParamList() {
        return paramList;
    }

    /**
     * [setter] ParamList
     *
     * @param paramList paramList
     */
    public void setParamList(List<CodeAttributeParam> paramList) {
        this.paramList = paramList;
    }

    /**
     * AddPlainParam
     *
     * @param value value
     * @return CodeAttribute
     */
    public CodeAttribute addPlainParam(String value) {
        if (this.paramList == null) {
            this.paramList = Lists.newArrayList();
        }
        CodeAttributeParam codeAttributeParam = new CodeAttributeParam();
        codeAttributeParam.setValue(DataValue.ofString(value));
        this.paramList.add(codeAttributeParam);

        return this;
    }

    /**
     * AddStringParam
     *
     * @param value value
     * @return CodeAttribute
     */
    public CodeAttribute addStringParam(String value) {
        if (this.paramList == null) {
            this.paramList = Lists.newArrayList();
        }
        CodeAttributeParam codeAttributeParam = new CodeAttributeParam();
        codeAttributeParam.setValue(DataValue.doubleQuotationString(value));
        this.paramList.add(codeAttributeParam);

        return this;
    }

    /**
     * AddPlainParam
     *
     * @param key   key
     * @param value value
     * @return CodeAttribute
     */
    public CodeAttribute addPlainParam(String key, String value) {
        if (this.paramList == null) {
            this.paramList = Lists.newArrayList();
        }
        CodeAttributeParam codeAttributeParam = new CodeAttributeParam();
        codeAttributeParam.setKey(key);
        codeAttributeParam.setValue(DataValue.ofString(value));
        this.paramList.add(codeAttributeParam);

        return this;
    }

    /**
     * AddStringParam
     *
     * @param key   key
     * @param value value
     * @return CodeAttribute
     */
    public CodeAttribute addStringParam(String key, String value) {
        if (this.paramList == null) {
            this.paramList = Lists.newArrayList();
        }
        CodeAttributeParam codeAttributeParam = new CodeAttributeParam();
        codeAttributeParam.setKey(key);
        codeAttributeParam.setValue(DataValue.doubleQuotationString(value));
        this.paramList.add(codeAttributeParam);
        return this;
    }
}
