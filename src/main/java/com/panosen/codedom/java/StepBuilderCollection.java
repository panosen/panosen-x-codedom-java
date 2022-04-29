package com.panosen.codedom.java;

/*
 *------------------------------------------------------------------------------
 *     Do not go gentle into that goods night.
 *
 *     harriszhang@live.cn
 *------------------------------------------------------------------------------
 */

import java.util.List;


public class StepBuilderCollection extends StepBuilderOrCollection {

    /**
     * IStepBuilderCollection.StepBuilders
     */
    private List<StepBuilderOrCollection> stepBuilders;

    /**
     * [getter] IStepBuilderCollection.StepBuilders
     *
     * @return List&lt;StepBuilderOrCollection&gt;
     */
    public List<StepBuilderOrCollection> getStepBuilders() {
        return stepBuilders;
    }

    /**
     * [setter] IStepBuilderCollection.StepBuilders
     *
     * @param stepBuilders stepBuilders
     */
    public void setStepBuilders(List<StepBuilderOrCollection> stepBuilders) {
        this.stepBuilders = stepBuilders;
    }
}
