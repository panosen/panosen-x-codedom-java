package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

public class ForeachStepBuilder extends StepBuilderCollection {

    /**
     * Type
     */
    private String type;

    /**
     * Item
     */
    private String item;

    /**
     * Items
     */
    private String items;

    /**
     * [getter] Type
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * [setter] Type
     *
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * [getter] Item
     *
     * @return String
     */
    public String getItem() {
        return item;
    }

    /**
     * [setter] Item
     *
     * @param item item
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * [getter] Items
     *
     * @return String
     */
    public String getItems() {
        return items;
    }

    /**
     * [setter] Items
     *
     * @param items items
     */
    public void setItems(String items) {
        this.items = items;
    }
}
