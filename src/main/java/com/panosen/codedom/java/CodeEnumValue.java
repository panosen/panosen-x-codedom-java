package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import com.panosen.codedom.DataItem;

public class CodeEnumValue extends CodeObject {

    /**
     * 值
     */
    private DataItem value;

    /**
     * [getter] 值
     *
     * @return DataItem
     */
    public DataItem getValue() {
        return value;
    }

    /**
     * [setter] 值
     *
     * @param value value
     */
    public void setValue(DataItem value) {
        this.value = value;
    }
}
