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
import com.google.common.collect.Sets;
import com.panosen.codedom.CodeWriter;
import com.panosen.codedom.java.engine.GenerateOptions;
import com.panosen.codedom.java.engine.JavaCodeEngine;

import java.io.StringWriter;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;


public class CodeFile {

    /**
     * 包
     */
    private String packageName;

    /**
     * 引用
     */
    private SortedSet<String> importList;

    /**
     * 类
     */
    private List<CodeClass> classList;

    /**
     * 接口
     */
    private List<CodeInterface> interfaceList;

    /**
     * 枚举
     */
    private List<CodeEnum> enumList;

    /**
     * 格言
     */
    private List<String> mottos;

    /**
     * [getter] 包
     *
     * @return String
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * [setter] 包
     *
     * @param packageName packageName
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * [getter] 引用
     *
     * @return SortedSet&lt;String&gt;
     */
    public SortedSet<String> getImportList() {
        return importList;
    }

    /**
     * [setter] 引用
     *
     * @param importList importList
     */
    public void setImportList(SortedSet<String> importList) {
        this.importList = importList;
    }

    /**
     * [getter] 类
     *
     * @return List&lt;CodeClass&gt;
     */
    public List<CodeClass> getClassList() {
        return classList;
    }

    /**
     * [setter] 类
     *
     * @param classList classList
     */
    public void setClassList(List<CodeClass> classList) {
        this.classList = classList;
    }

    /**
     * [getter] 接口
     *
     * @return List&lt;CodeInterface&gt;
     */
    public List<CodeInterface> getInterfaceList() {
        return interfaceList;
    }

    /**
     * [setter] 接口
     *
     * @param interfaceList interfaceList
     */
    public void setInterfaceList(List<CodeInterface> interfaceList) {
        this.interfaceList = interfaceList;
    }

    /**
     * [getter] 枚举
     *
     * @return List&lt;CodeEnum&gt;
     */
    public List<CodeEnum> getEnumList() {
        return enumList;
    }

    /**
     * [setter] 枚举
     *
     * @param enumList enumList
     */
    public void setEnumList(List<CodeEnum> enumList) {
        this.enumList = enumList;
    }

    /**
     * [getter] 格言
     *
     * @return List&lt;String&gt;
     */
    public List<String> getMottos() {
        return mottos;
    }

    /**
     * [setter] 格言
     *
     * @param mottos mottos
     */
    public void setMottos(List<String> mottos) {
        this.mottos = mottos;
    }

    /**
     * 添加一个格言
     *
     * @param motto 格言
     * @return CodeFile
     */
    public CodeFile addMotto(String motto) {
        if (this.mottos == null) {
            this.mottos = Lists.newArrayList();
        }
        this.mottos.add(motto);
        return this;
    }

    /**
     * 添加一个引用
     *
     * @param fullName 引用
     */
    public void addImport(String fullName) {
        if (this.importList == null) {
            this.importList = Sets.newTreeSet();
        }
        this.importList.add(fullName);
    }

    /**
     * 添加一个引用
     *
     * @param packageName 包
     * @param name        类
     */
    public void addImport(String packageName, String name) {
        if (this.importList == null) {
            this.importList = Sets.newTreeSet();
        }
        this.importList.add(packageName + "." + name);
    }

    /**
     * 添加一批引用
     *
     * @param imports 引用
     */
    public void addImports(List<String> imports) {
        if (this.importList == null) {
            this.importList = Sets.newTreeSet();
        }
        this.importList.addAll(imports);
    }

    /**
     * 添加一个类
     *
     * @param codeClass 类
     * @return CodeFile
     */
    public CodeFile addClass(CodeClass codeClass) {
        if (this.classList == null) {
            this.classList = Lists.newArrayList();
        }
        this.classList.add(codeClass);
        return this;
    }

    /**
     * 添加一个类
     *
     * @param name 类名
     * @return CodeClass
     */
    public CodeClass addClass(String name) {
        return addClass(name, null);
    }

    /**
     * 添加一个类
     *
     * @param name    类名
     * @param summary 注释
     * @return CodeClass
     */
    public CodeClass addClass(String name, String summary) {
        if (this.classList == null) {
            this.classList = Lists.newArrayList();
        }
        CodeClass codeClass = new CodeClass();
        codeClass.setName(name);
        codeClass.setSummary(summary);
        this.classList.add(codeClass);
        return codeClass;
    }

    /**
     * 添加一个枚举
     *
     * @param codeEnum 枚举
     * @return CodeFile
     */
    public CodeFile addEnum(CodeEnum codeEnum) {
        if (this.enumList == null) {
            this.enumList = Lists.newArrayList();
        }
        this.enumList.add(codeEnum);
        return this;
    }

    /**
     * 添加一个枚举
     *
     * @param name 枚举名
     * @return CodeEnum
     */
    public CodeEnum addEnum(String name) {
        return addEnum(name, null);
    }

    /**
     * 添加一个枚举
     *
     * @param name    枚举名
     * @param summary 注释
     * @return 枚举
     */
    public CodeEnum addEnum(String name, String summary) {
        if (this.enumList == null) {
            this.enumList = Lists.newArrayList();
        }
        CodeEnum codeEnum = new CodeEnum();
        codeEnum.setName(name);
        codeEnum.setSummary(summary);
        this.enumList.add(codeEnum);
        return codeEnum;
    }

    /**
     * TransformText
     *
     * @return String
     */
    public String transformText() {
        return transformText(null);
    }

    /**
     * TransformText
     *
     * @param options options
     * @return String
     */
    public String transformText(GenerateOptions options) {
        if (options == null) {
            options = new GenerateOptions();
        }
        StringWriter stringWriter = new StringWriter();
        new JavaCodeEngine().generateCodeFile(this, new CodeWriter(stringWriter), options);
        return stringWriter.toString();
    }
}
