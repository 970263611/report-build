package com.dahuaboke.impl;

import com.dahuaboke.report.AbstractPartGenerator;
import com.dahuaboke.report.MethodIndexEnum;
import com.dahuaboke.report.ReportData;
import com.dahuaboke.report.ReportRegisterChain;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author dahua
 * @time 2023/8/8 10:11
 * 报告部分具体实现类
 */
@Component
public class DingPartGenerator extends AbstractPartGenerator {

    @Override
    protected void register(ReportRegisterChain chain) {
        Class clz = this.getClass();
        try {
            Method m1 = clz.getMethod("m1");
            Method m2 = clz.getMethod("m2");
            chain.append(this, m1, MethodIndexEnum.INPUT1);
            chain.append(this, m2, MethodIndexEnum.INPUT2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public String m1() {
        ReportData reportData = getReportData();
        return reportData.getM1();
    }

    public String m2() {
        ReportData reportData = getReportData();
        return reportData.getM2();
    }
}
