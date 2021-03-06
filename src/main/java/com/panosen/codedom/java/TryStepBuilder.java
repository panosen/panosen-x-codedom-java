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


public class TryStepBuilder extends StepBuilderCollection {

    /**
     * catch
     */
    private List<CatchStepBuilder> catchStepBuilders;

    /**
     * finally
     */
    private FinallyStepBuilder finallyStepBuilder;

    /**
     * [getter] catch
     *
     * @return List&lt;CatchStepBuilder&gt;
     */
    public List<CatchStepBuilder> getCatchStepBuilders() {
        return catchStepBuilders;
    }

    /**
     * [setter] catch
     *
     * @param catchStepBuilders catchStepBuilders
     */
    public void setCatchStepBuilders(List<CatchStepBuilder> catchStepBuilders) {
        this.catchStepBuilders = catchStepBuilders;
    }

    /**
     * [getter] finally
     *
     * @return FinallyStepBuilder
     */
    public FinallyStepBuilder getFinallyStepBuilder() {
        return finallyStepBuilder;
    }

    /**
     * [setter] finally
     *
     * @param finallyStepBuilder finallyStepBuilder
     */
    public void setFinallyStepBuilder(FinallyStepBuilder finallyStepBuilder) {
        this.finallyStepBuilder = finallyStepBuilder;
    }


    /**
     * WithCatch
     *
     * @return CatchStepBuilder
     */
    public CatchStepBuilder withCatch() {
        return withCatch(null, null);
    }

    /**
     * WithCatch
     *
     * @param exceptionType exceptionType
     * @return CatchStepBuilder
     */
    public CatchStepBuilder withCatch(String exceptionType) {
        return withCatch(exceptionType, null);
    }

    /**
     * WithCatch
     *
     * @param exceptionName exceptionName
     * @param exceptionType exceptionType
     * @return CatchStepBuilder
     */
    public CatchStepBuilder withCatch(String exceptionType, String exceptionName) {
        if (this.catchStepBuilders == null) {
            this.catchStepBuilders = Lists.newArrayList();
        }
        CatchStepBuilder catchStepBuilder = new CatchStepBuilder();
        catchStepBuilder.setExceptionType(exceptionType);
        catchStepBuilder.setExceptionName(exceptionName);
        this.catchStepBuilders.add(catchStepBuilder);
        return catchStepBuilder;
    }

    /**
     * WithFinally
     *
     * @return FinallyStepBuilder
     */
    public FinallyStepBuilder withFinally() {
        FinallyStepBuilder finallyStepBuilder = new FinallyStepBuilder();
        this.finallyStepBuilder = finallyStepBuilder;
        return finallyStepBuilder;
    }
}
