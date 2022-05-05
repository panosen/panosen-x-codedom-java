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

import java.util.List;
import java.util.Map;


public class CodeAttribute extends CodeObject {

    /**
     * ParamList
     */
    private List<DataValue> paramList;

    /**
     * ParamMap
     */
    private Map<String, DataValue> paramMap;

    /**
     * [getter] ParamList
     *
     * @return List&lt;CodeValue&gt;
     */
    public List<DataValue> getParamList() {
        return paramList;
    }

    /**
     * [setter] ParamList
     *
     * @param paramList paramList
     */
    public void setParamList(List<DataValue> paramList) {
        this.paramList = paramList;
    }

    /**
     * [getter] ParamMap
     *
     * @return Map&lt;String, CodeValue&gt;
     */
    public Map<String, DataValue> getParamMap() {
        return paramMap;
    }

    /**
     * [setter] ParamMap
     *
     * @param paramMap paramMap
     */
    public void setParamMap(Map<String, DataValue> paramMap) {
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
        this.paramList.add(DataValue.ofString(value));

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
        this.paramList.add(DataValue.doubleQuotationString(value));

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
        this.paramMap.putIfAbsent(key, DataValue.ofString(value));

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
        this.paramMap.putIfAbsent(key, DataValue.doubleQuotationString(value));

        return this;
    }
}
