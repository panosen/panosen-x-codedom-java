package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

public class AssignStringVariableStepBuilder extends StepBuilder {

    /**
     * Name
     */
    private String name;

    /**
     * Value
     */
    private String value;

    /**
     * [getter] Name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * [setter] Name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
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
