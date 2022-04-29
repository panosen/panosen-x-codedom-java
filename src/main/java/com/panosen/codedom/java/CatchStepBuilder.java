package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

public class CatchStepBuilder extends StepBuilderCollection {

    /**
     * Exception
     */
    private String exceptionType;

    /**
     * e
     */
    private String exceptionName;

    /**
     * [getter] Exception
     *
     * @return String
     */
    public String getExceptionType() {
        return exceptionType;
    }

    /**
     * [setter] Exception
     *
     * @param exceptionType exceptionType
     */
    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    /**
     * [getter] e
     *
     * @return String
     */
    public String getExceptionName() {
        return exceptionName;
    }

    /**
     * [setter] e
     *
     * @param exceptionName exceptionName
     */
    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }
}
