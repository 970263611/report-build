package com.dahuaboke.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author dahua
 * @time 2023/8/8 10:19
 * 默认报告生成器
 */
@Component
public class SimpleReportGenerator implements ReportGenerator {

    @Autowired
    private ReportRegisterChain reportRegisterChain;

    //报告生成方法
    @Override
    public Report create() {
        try {
            Report report = new Report();
            List<ReportRegister> chain = reportRegisterChain.getChain();
            for (ReportRegister register : chain) {
                try {
                    Method reportMethod = register.getIndex().getMethod();
                    AbstractPartGenerator partGenerator = register.getPartGenerator();
                    Method partGeneratorMethod = register.getMethod();
                    Object invoke = partGeneratorMethod.invoke(partGenerator);
                    reportMethod.invoke(report, invoke);
                } catch (Exception e) {
                }
            }
            return report;
        } finally {
            ReportUtil.delReportData();
        }
    }
}
