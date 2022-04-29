package com.panosen.codedom.java.engine;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

public class GenerateOptions {

    public GenerateOptions() {
        this.tabString = "    ";
        this.indentSize = 0;
        this.indentString = "";
    }

    /**
     * TabString
     */
    private String tabString;

    /**
     * 强制加注释
     */
    private boolean useJavaCoc;

    /**
     * 缩进个数
     */
    private Integer indentSize;

    /**
     * 缩进字符
     */
    private String indentString;

    /**
     * [getter] TabString
     *
     * @return String
     */
    public String getTabString() {
        return tabString;
    }

    /**
     * [setter] TabString
     *
     * @param tabString tabString
     */
    public void setTabString(String tabString) {
        this.tabString = tabString;
    }

    /**
     * [getter] 强制加注释
     *
     * @return Boolean
     */
    public boolean getUseJavaCoc() {
        return useJavaCoc;
    }

    /**
     * [setter] 强制加注释
     *
     * @param useJavaCoc useJavaCoc
     */
    public void setUseJavaCoc(boolean useJavaCoc) {
        this.useJavaCoc = useJavaCoc;
    }

    /**
     * [getter] 缩进个数
     *
     * @return Integer
     */
    public Integer getIndentSize() {
        return indentSize;
    }

    /**
     * [setter] 缩进个数
     *
     * @param indentSize indentSize
     */
    public void setIndentSize(Integer indentSize) {
        this.indentSize = indentSize;

        buildIndentString();
    }

    /**
     * [getter] 缩进字符
     *
     * @return String
     */
    public String getIndentString() {
        return indentString;
    }

    /**
     * 增加缩进
     */
    public void pushIndent() {
        this.indentSize = this.indentSize + 1;
        buildIndentString();
    }

    /**
     * 减少缩进
     */
    public void PopIndent() {
        if (this.indentSize > 0) {
            this.indentSize = this.indentSize - 1;
        }
        buildIndentString();
    }

    private void buildIndentString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.indentSize; i++) {
            builder.append(this.tabString);
        }
        this.indentString = builder.toString();
    }
}
