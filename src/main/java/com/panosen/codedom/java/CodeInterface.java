package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import com.google.common.collect.Lists;

import java.util.List;


public class CodeInterface extends CodeObject {

    /**
     * 访问修饰符
     */
    private AccessModifiers accessModifiers;

    /**
     * 方法
     */
    private List<CodeMethod> methodList;

    /**
     * 继承的接口
     */
    private CodeInterface baseInterface;

    /**
     * [getter] 访问修饰符
     *
     * @return AccessModifiers
     */
    public AccessModifiers getAccessModifiers() {
        return accessModifiers;
    }

    /**
     * [setter] 访问修饰符
     *
     * @param accessModifiers accessModifiers
     */
    public void setAccessModifiers(AccessModifiers accessModifiers) {
        this.accessModifiers = accessModifiers;
    }

    /**
     * [getter] 方法
     *
     * @return List&lt;CodeMethod&gt;
     */
    public List<CodeMethod> getMethodList() {
        return methodList;
    }

    /**
     * [setter] 方法
     *
     * @param methodList methodList
     */
    public void setMethodList(List<CodeMethod> methodList) {
        this.methodList = methodList;
    }

    /**
     * [getter] 继承的接口
     *
     * @return CodeInterface
     */
    public CodeInterface getBaseInterface() {
        return baseInterface;
    }

    /**
     * [setter] 继承的接口
     *
     * @param baseInterface baseInterface
     */
    public void setBaseInterface(CodeInterface baseInterface) {
        this.baseInterface = baseInterface;
    }

    /**
     * AddMethod
     *
     * @param codeMethod codeMethod
     * @return CodeInterface
     */
    public CodeInterface AddMethod(CodeMethod codeMethod) {
        if (this.methodList == null) {
            this.methodList = Lists.newArrayList();
        }
        this.methodList.add(codeMethod);
        return this;
    }

    /**
     * SetBaseInterface
     *
     * @param name    name
     * @param summary summary
     * @return CodeInterface
     */
    public CodeInterface SetBaseInterface(String name, String summary) {
        CodeInterface baseInterface = new CodeInterface();
        baseInterface.setName(name);
        baseInterface.setSummary(summary);
        this.baseInterface = baseInterface;
        return this;
    }
}
