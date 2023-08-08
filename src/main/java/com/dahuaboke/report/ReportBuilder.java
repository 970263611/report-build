package com.dahuaboke.report;

/**
 * @author dahua
 * @time 2023/8/8 9:08
 * 报告生成器类
 */
public class ReportBuilder {

    //生成报告方法入口
    public static Report build(ReportData reportData) {
        ReportUtil.setReportData(reportData);
        ReportGenerator reportGenerator = ReportUtil.getBean(ReportGenerator.class);
        return reportGenerator.create();
    }
}
