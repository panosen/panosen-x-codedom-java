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


public class CodeClass extends CodeObject {

    /**
     * 是否是抽象类
     */
    private boolean isAbstract;

    /**
     * final
     */
    private boolean isFinal;

    /**
     * 访问修饰符
     */
    private AccessModifiers accessModifiers;

    /**
     * 属性
     */
    private List<CodeProperty> propertyList;

    /**
     * 字段
     */
    private List<CodeField> fieldList;

    /**
     * 方法
     */
    private List<CodeMethod> methodList;

    /**
     * 构造函数
     */
    private List<CodeMethod> constructorList;

    /**
     * 该类实现的接口
     */
    private List<CodeInterface> interfaceList;

    /**
     * 该类实现的接口
     */
    private CodeClass baseClass;

    /**
     * 常量
     */
    private List<CodeConstant> constantList;

    /**
     * 特性
     */
    private List<CodeAttribute> attributeList;

    /**
     * [getter] 是否是抽象类
     *
     * @return Boolean
     */
    public boolean getIsAbstract() {
        return isAbstract;
    }

    /**
     * [setter] 是否是抽象类
     *
     * @param isAbstract isAbstract
     */
    public void setIsAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    /**
     * [getter] final
     *
     * @return Boolean
     */
    public boolean getIsFinal() {
        return isFinal;
    }

    /**
     * [setter] final
     *
     * @param isFinal isFinal
     */
    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

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
     * [getter] 属性
     *
     * @return List&lt;CodeProperty&gt;
     */
    public List<CodeProperty> getPropertyList() {
        return propertyList;
    }

    /**
     * [setter] 属性
     *
     * @param propertyList propertyList
     */
    public void setPropertyList(List<CodeProperty> propertyList) {
        this.propertyList = propertyList;
    }

    /**
     * [getter] 字段
     *
     * @return List&lt;CodeField&gt;
     */
    public List<CodeField> getFieldList() {
        return fieldList;
    }

    /**
     * [setter] 字段
     *
     * @param fieldList fieldList
     */
    public void setFieldList(List<CodeField> fieldList) {
        this.fieldList = fieldList;
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
     * [getter] 构造函数
     *
     * @return List&lt;CodeMethod&gt;
     */
    public List<CodeMethod> getConstructorList() {
        return constructorList;
    }

    /**
     * [setter] 构造函数
     *
     * @param constructorList constructorList
     */
    public void setConstructorList(List<CodeMethod> constructorList) {
        this.constructorList = constructorList;
    }

    /**
     * [getter] 该类实现的接口
     *
     * @return List&lt;CodeInterface&gt;
     */
    public List<CodeInterface> getInterfaceList() {
        return interfaceList;
    }

    /**
     * [setter] 该类实现的接口
     *
     * @param interfaceList interfaceList
     */
    public void setInterfaceList(List<CodeInterface> interfaceList) {
        this.interfaceList = interfaceList;
    }

    /**
     * [getter] 该类实现的接口
     *
     * @return CodeClass
     */
    public CodeClass getBaseClass() {
        return baseClass;
    }

    /**
     * [setter] 该类实现的接口
     *
     * @param baseClass baseClass
     */
    public void setBaseClass(CodeClass baseClass) {
        this.baseClass = baseClass;
    }

    /**
     * [getter] 常量
     *
     * @return List&lt;CodeConstant&gt;
     */
    public List<CodeConstant> getConstantList() {
        return constantList;
    }

    /**
     * [setter] 常量
     *
     * @param constantList constantList
     */
    public void setConstantList(List<CodeConstant> constantList) {
        this.constantList = constantList;
    }

    /**
     * [getter] 特性
     *
     * @return List&lt;CodeAttribute&gt;
     */
    public List<CodeAttribute> getAttributeList() {
        return attributeList;
    }

    /**
     * [setter] 特性
     *
     * @param attributeList attributeList
     */
    public void setAttributeList(List<CodeAttribute> attributeList) {
        this.attributeList = attributeList;
    }


    /**
     * AddAttribute
     *
     * @param codeAttribute CodeAttribute
     * @return CodeClass
     */
    public CodeClass addAttribute(CodeAttribute codeAttribute) {
        if (this.attributeList == null) {
            this.attributeList = Lists.newArrayList();
        }
        this.attributeList.add(codeAttribute);
        return this;
    }

    /**
     * AddAttribute
     *
     * @param name name
     * @return CodeAttribute
     */
    public CodeAttribute addAttribute(String name) {
        if (this.attributeList == null) {
            this.attributeList = Lists.newArrayList();
        }
        CodeAttribute codeAttribute = new CodeAttribute();
        codeAttribute.setName(name);
        this.attributeList.add(codeAttribute);
        return codeAttribute;
    }

    /**
     * AddInterface
     *
     * @param codeInterface codeInterface
     * @return CodeClass
     */
    public CodeClass addInterface(CodeInterface codeInterface) {
        if (this.interfaceList == null) {
            this.interfaceList = Lists.newArrayList();
        }
        this.interfaceList.add(codeInterface);
        return this;
    }

    /**
     * AddInterface
     *
     * @param name    name
     * @param summary summary
     * @return CodeInterface
     */
    public CodeInterface addInterface(String name, String summary) {
        if (this.interfaceList == null) {
            this.interfaceList = Lists.newArrayList();
        }
        CodeInterface codeInterface = new CodeInterface();
        codeInterface.setName(name);
        codeInterface.setSummary(summary);
        this.interfaceList.add(codeInterface);
        return codeInterface;
    }

    /**
     * SetBaseClass
     *
     * @param name baseClassName
     * @return CodeClass
     */
    public CodeClass setBaseClass(String name) {
        return setBaseClass(name, null);
    }

    /**
     * SetBaseClass
     *
     * @param name    name
     * @param summary summary
     * @return CodeClass
     */
    public CodeClass setBaseClass(String name, String summary) {
        CodeClass baseClass = new CodeClass();
        baseClass.setName(name);
        baseClass.setSummary(summary);
        this.setBaseClass(baseClass);
        return this;
    }

    /**
     * 添加一个方法
     *
     * @param codeMethod codeMethod
     * @return CodeClass
     */
    public CodeClass addMethod(CodeMethod codeMethod) {
        if (this.methodList == null) {
            this.methodList = Lists.newArrayList();
        }
        this.methodList.add(codeMethod);
        return this;
    }

    /**
     * 添加一个方法
     *
     * @param name name
     * @return CodeMethod
     */
    public CodeMethod addMethod(String name) {
        return addMethod(name, null);
    }

    /**
     * 添加一个方法
     *
     * @param name    name
     * @param summary summary
     * @return CodeMethod
     */
    public CodeMethod addMethod(String name, String summary) {
        if (this.methodList == null) {
            this.methodList = Lists.newArrayList();
        }
        CodeMethod codeMethod = new CodeMethod();
        codeMethod.setName(name);
        codeMethod.setSummary(summary);
        this.methodList.add(codeMethod);
        return codeMethod;
    }

    /**
     * addMethods
     *
     * @param codeMethods codeMethods
     * @return CodeClass
     */
    public CodeClass addMethods(List<CodeMethod> codeMethods) {
        if (this.methodList == null) {
            this.methodList = Lists.newArrayList();
        }
        this.methodList.addAll(codeMethods);
        return this;
    }

    /**
     * AddConstructor
     *
     * @param codeMethod codeMethod
     * @return CodeClass
     */
    public CodeClass addConstructor(CodeMethod codeMethod) {
        if (this.constructorList == null) {
            this.constructorList = Lists.newArrayList();
        }
        this.constructorList.add(codeMethod);
        return this;
    }

    /**
     * 添加构造函数
     *
     * @return CodeMethod
     */
    public CodeMethod addConstructor() {
        if (this.constructorList == null) {
            this.constructorList = Lists.newArrayList();
        }
        CodeMethod codeMethod = new CodeMethod();
        this.constructorList.add(codeMethod);
        return codeMethod;
    }

    /**
     * AddProperty
     *
     * @param codeProperty codeProperty
     * @return CodeClass
     */
    public CodeClass addProperty(CodeProperty codeProperty) {
        if (this.propertyList == null) {
            this.propertyList = Lists.newArrayList();
        }
        this.propertyList.add(codeProperty);
        return this;
    }

    /**
     * addProperties
     *
     * @param properties properties
     * @return CodeClass
     */
    public CodeClass addProperties(List<CodeProperty> properties) {
        if (properties == null || properties.isEmpty()) {
            return this;
        }
        if (this.propertyList == null) {
            this.propertyList = Lists.newArrayList();
        }
        this.propertyList.addAll(properties);
        return this;
    }

    /**
     * AddProperty
     *
     * @param name name
     * @param type type
     * @return CodeProperty
     */
    public CodeProperty addProperty(String type, String name) {
        return addProperty(type, name, null);
    }

    /**
     * AddProperty
     *
     * @param name name
     * @param type type
     * @return CodeProperty
     */
    public CodeProperty addProperty(String type, String name, String summary) {
        if (this.propertyList == null) {
            this.propertyList = Lists.newArrayList();
        }
        CodeProperty codeProperty = new CodeProperty();
        codeProperty.setType(type);
        codeProperty.setName(name);
        codeProperty.setSummary(summary);
        this.propertyList.add(codeProperty);
        return codeProperty;
    }

    /**
     * AddField
     *
     * @param codeField codeField
     * @return CodeClass
     */
    public CodeClass addField(CodeField codeField) {
        if (this.fieldList == null) {
            this.fieldList = Lists.newArrayList();
        }
        this.fieldList.add(codeField);
        return this;
    }

    /**
     * addFields
     *
     * @param codeFields codeFields
     * @return CodeClass
     */
    public CodeClass addFields(List<CodeField> codeFields) {
        if (codeFields == null || codeFields.isEmpty()) {
            return this;
        }
        if (this.fieldList == null) {
            this.fieldList = Lists.newArrayList();
        }
        this.fieldList.addAll(codeFields);
        return this;
    }

    /**
     * AddField
     *
     * @param name name
     * @param type type
     * @return CodeField
     */
    public CodeField addField(String type, String name) {
        return addField(type, name, null);
    }

    /**
     * AddField
     *
     * @param name name
     * @param type type
     * @return CodeField
     */
    public CodeField addField(String type, String name, String summary) {
        if (this.fieldList == null) {
            this.fieldList = Lists.newArrayList();
        }
        CodeField codeField = new CodeField();
        codeField.setType(type);
        codeField.setName(name);
        codeField.setSummary(summary);
        this.fieldList.add(codeField);
        return codeField;
    }

    /**
     * AddConstant
     *
     * @param codeConstant codeConstant
     * @return CodeClass
     */
    public CodeClass addConstant(CodeConstant codeConstant) {
        if (this.constantList == null) {
            this.constantList = Lists.newArrayList();
        }
        this.constantList.add(codeConstant);
        return this;
    }

    /**
     * AddConstant
     *
     * @param type type
     * @param name name
     * @return CodeConstant
     */
    public CodeConstant addConstant(String type, String name, String value) {
        return addConstant(type, name, value, null);
    }

    /**
     * AddConstant
     *
     * @param type type
     * @param name name
     * @return CodeConstant
     */
    public CodeConstant addConstant(String type, String name, String value, String summary) {
        if (this.constantList == null) {
            this.constantList = Lists.newArrayList();
        }
        CodeConstant codeConstant = new CodeConstant();
        codeConstant.setName(name);
        codeConstant.setType(type);
        codeConstant.setValue(value);
        codeConstant.setSummary(summary);
        this.constantList.add(codeConstant);
        return codeConstant;
    }
}
