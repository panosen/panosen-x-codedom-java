package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

public class CodeObject extends Code {

    /**
     * Name
     */
    private String name;

    /**
     * Summary
     */
    private String summary;

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
     * [getter] Summary
     *
     * @return String
     */
    public String getSummary() {
        return summary;
    }

    /**
     * [setter] Summary
     *
     * @param summary summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
}
