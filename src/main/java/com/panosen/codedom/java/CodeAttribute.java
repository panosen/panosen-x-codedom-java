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

import java.util.List;
import java.util.Map;


public class CodeAttribute extends CodeObject {

    /**
     * ParamList
     */
    private List<CodeValue> paramList;

    /**
     * ParamMap
     */
    private Map<String, CodeValue> paramMap;

    /**
     * [getter] ParamList
     *
     * @return List&lt;CodeValue&gt;
     */
    public List<CodeValue> getParamList() {
        return paramList;
    }

    /**
     * [setter] ParamList
     *
     * @param paramList paramList
     */
    public void setParamList(List<CodeValue> paramList) {
        this.paramList = paramList;
    }

    /**
     * [getter] ParamMap
     *
     * @return Map&lt;String, CodeValue&gt;
     */
    public Map<String, CodeValue> getParamMap() {
        return paramMap;
    }

    /**
     * [setter] ParamMap
     *
     * @param paramMap paramMap
     */
    public void setParamMap(Map<String, CodeValue> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * AddPlainParam
     *
     * @param value value
     * @return CodeAttribute
     */
    public CodeAttribute AddPlainParam(String value) {
        if (this.paramList == null) {
            this.paramList = Lists.newArrayList();
        }

        CodeValue codeValue = new CodeValue();
        codeValue.setType(CodeValueType.PLAIN);
        codeValue.setValue(value);
        this.paramList.add(codeValue);

        return this;
    }

    /**
     * AddStringParam
     *
     * @param value value
     * @return CodeAttribute
     */
    public CodeAttribute AddStringParam(String value) {
        if (this.paramList == null) {
            this.paramList = Lists.newArrayList();
        }

        CodeValue codeValue = new CodeValue();
        codeValue.setType(CodeValueType.STRING);
        codeValue.setValue(value);
        this.paramList.add(codeValue);

        return this;
    }

    /**
     * AddPlainParam
     *
     * @param key   key
     * @param value value
     * @return CodeAttribute
     */
    public CodeAttribute AddPlainParam(String key, String value) {
        if (this.paramMap == null) {
            this.paramMap = Maps.newHashMap();
        }

        CodeValue codeValue = new CodeValue();
        codeValue.setType(CodeValueType.PLAIN);
        codeValue.setValue(value);
        this.paramMap.putIfAbsent(key, codeValue);

        return this;
    }

    /**
     * AddStringParam
     *
     * @param key   key
     * @param value value
     * @return CodeAttribute
     */
    public CodeAttribute AddStringParam(String key, String value) {
        if (this.paramMap == null) {
            this.paramMap = Maps.newHashMap();
        }

        CodeValue codeValue = new CodeValue();
        codeValue.setType(CodeValueType.STRING);
        codeValue.setValue(value);
        this.paramMap.putIfAbsent(key, codeValue);

        return this;
    }
}
