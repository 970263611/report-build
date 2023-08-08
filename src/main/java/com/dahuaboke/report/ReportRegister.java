package com.dahuaboke.report;

import java.lang.reflect.Method;

/**
 * @author dahua
 * @time 2023/8/8 11:12
 * 报告注册器载体
 */
public class ReportRegister {

    private AbstractPartGenerator partGenerator;
    private Method method;
    private MethodIndexEnum index;

    public ReportRegister(AbstractPartGenerator partGenerator, Method method, MethodIndexEnum index) {
        this.partGenerator = partGenerator;
        this.method = method;
        this.index = index;
    }

    public AbstractPartGenerator getPartGenerator() {
        return partGenerator;
    }

    public void setPartGenerator(AbstractPartGenerator partGenerator) {
        this.partGenerator = partGenerator;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public MethodIndexEnum getIndex() {
        return index;
    }

    public void setIndex(MethodIndexEnum index) {
        this.index = index;
    }
}
