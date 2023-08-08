package com.dahuaboke.report;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author dahua
 * @time 2023/8/8 10:12
 * 报告部分生成父类
 */
public abstract class AbstractPartGenerator {

    @Autowired
    private ReportRegisterChain chain;

    @PostConstruct
    public void init() {
        register(chain);
    }

    //获取报告全量数据，子类自行获取
    protected ReportData getReportData() {
        return ReportUtil.getReportData();
    }

    //定义抽象注册方法，参数为注册链条，子类自行将信息添加到链条上
    protected abstract void register(ReportRegisterChain chain);
}
