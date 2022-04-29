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

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;


public class CodeFile {

    /**
     * 包
     */
    private String packageName;

    /**
     * 系统引用
     */
    private SortedMap<String, SortedSet<String>> systemImportList;

    /**
     * 从nuget包里面的引用
     */
    private SortedMap<String, SortedSet<String>> mavenImportList;

    /**
     * 当前项目的引用
     */
    private SortedMap<String, SortedSet<String>> projectImportList;

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
     * [getter] 系统引用
     *
     * @return Map&lt;String, SortedSet&lt;String&gt;&gt;
     */
    public SortedMap<String, SortedSet<String>> getSystemImportList() {
        return systemImportList;
    }

    /**
     * [setter] 系统引用
     *
     * @param systemImportList systemImportList
     */
    public void setSystemImportList(SortedMap<String, SortedSet<String>> systemImportList) {
        this.systemImportList = systemImportList;
    }

    /**
     * [getter] 从nuget包里面的引用
     *
     * @return SortedMap&lt;String, SortedSet&lt;String&gt;&gt;
     */
    public SortedMap<String, SortedSet<String>> getMavenImportList() {
        return mavenImportList;
    }

    /**
     * [setter] 从nuget包里面的引用
     *
     * @param mavenImportList mavenImportList
     */
    public void setMavenImportList(SortedMap<String, SortedSet<String>> mavenImportList) {
        this.mavenImportList = mavenImportList;
    }

    /**
     * [getter] 当前项目的引用
     *
     * @return SortedMap&lt;String, SortedSet&lt;String&gt;&gt;
     */
    public SortedMap<String, SortedSet<String>> getProjectImportList() {
        return projectImportList;
    }

    /**
     * [setter] 当前项目的引用
     *
     * @param projectImportList projectImportList
     */
    public void setProjectImportList(SortedMap<String, SortedSet<String>> projectImportList) {
        this.projectImportList = projectImportList;
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
     * 添加一个系统引用
     *
     * @param fullName 系统引用
     */
    public void addSystemImport(String fullName) {
        if (this.systemImportList == null) {
            this.systemImportList = Maps.newTreeMap();
        }
        String packageName = fullName.substring(0, fullName.lastIndexOf("."));
        String name = fullName.substring(fullName.lastIndexOf(".") + 1);
        this.systemImportList.putIfAbsent(packageName, Sets.newTreeSet());
        this.systemImportList.get(packageName).add(name);
    }

    /**
     * 添加一个系统引用
     *
     * @param packageName 包
     * @param name        类
     */
    public void addSystemImport(String packageName, String name) {
        if (this.systemImportList == null) {
            this.systemImportList = Maps.newTreeMap();
        }
        this.systemImportList.putIfAbsent(packageName, Sets.newTreeSet());
        this.systemImportList.get(packageName).add(name);
    }

    /**
     * 添加一批系统引用
     *
     * @param imports 系统引用
     */
    public void addSystemImports(List<String> imports) {
        if (this.systemImportList == null) {
            this.systemImportList = Maps.newTreeMap();
        }
        for (String $import : imports) {
            String packageName = $import.substring(0, $import.lastIndexOf("."));
            String name = $import.substring($import.lastIndexOf(".") + 1);
            this.systemImportList.putIfAbsent(packageName, Sets.newTreeSet());
            this.systemImportList.get(packageName).add(name);
        }
    }

    /**
     * 添加一个Maven引用
     *
     * @param fullName 包
     */
    public void addMavenImport(String fullName) {
        if (this.mavenImportList == null) {
            this.mavenImportList = Maps.newTreeMap();
        }
        String packageName = fullName.substring(0, fullName.lastIndexOf("."));
        String name = fullName.substring(fullName.lastIndexOf(".") + 1);
        this.mavenImportList.putIfAbsent(packageName, Sets.newTreeSet());
        this.mavenImportList.get(packageName).add(name);
    }

    /**
     * 添加一个Maven引用
     *
     * @param packageName 包
     * @param name        类
     */
    public void addMavenImport(String packageName, String name) {
        if (this.mavenImportList == null) {
            this.mavenImportList = Maps.newTreeMap();
        }
        this.mavenImportList.putIfAbsent(packageName, Sets.newTreeSet());
        this.mavenImportList.get(packageName).add(name);
    }

    /**
     * 添加一批Maven引用
     *
     * @param imports Maven引用
     */
    public void addMavenImports(List<String> imports) {
        if (this.mavenImportList == null) {
            this.mavenImportList = Maps.newTreeMap();
        }
        for (String $import : imports) {
            String packageName = $import.substring(0, $import.lastIndexOf("."));
            String name = $import.substring($import.lastIndexOf(".") + 1);
            this.mavenImportList.putIfAbsent(packageName, Sets.newTreeSet());
            this.mavenImportList.get(packageName).add(name);
        }
    }

    /**
     * 添加一个项目引用
     *
     * @param fullName 项目引用
     */
    public void addProjectImport(String fullName) {
        if (this.projectImportList == null) {
            this.projectImportList = Maps.newTreeMap();
        }
        String packageName = fullName.substring(0, fullName.lastIndexOf("."));
        String name = fullName.substring(fullName.lastIndexOf(".") + 1);
        this.projectImportList.putIfAbsent(packageName, Sets.newTreeSet());
        this.projectImportList.get(packageName).add(name);
    }

    /**
     * 添加一个项目引用
     *
     * @param packageName 包
     * @param name        类
     */
    public void addProjectImport(String packageName, String name) {
        if (this.projectImportList == null) {
            this.projectImportList = Maps.newTreeMap();
        }
        this.projectImportList.putIfAbsent(packageName, Sets.newTreeSet());
        this.projectImportList.get(packageName).add(name);
    }

    /**
     * 添加一批项目引用
     *
     * @param imports 项目引用
     */
    public void addProjectImports(List<String> imports) {
        if (this.projectImportList == null) {
            this.projectImportList = Maps.newTreeMap();
        }
        for (String $import : imports) {
            String packageName = $import.substring(0, $import.lastIndexOf("."));
            String name = $import.substring($import.lastIndexOf(".") + 1);
            this.projectImportList.putIfAbsent(packageName, Sets.newTreeSet());
            this.projectImportList.get(packageName).add(name);
        }
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
        StringBuilder builder = new StringBuilder();
        new JavaCodeEngine().generateCodeFile(this, new CodeWriter(builder), options);
        return builder.toString();
    }
}
