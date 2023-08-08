package com.dahuaboke.report;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author dahua
 * @time 2023/8/8 10:56
 * 报告工具类
 */
@Component
public class ReportUtil implements ApplicationContextAware {

    private static final ThreadLocal<ReportData> threadLocal = new ThreadLocal();
    private static ApplicationContext applicationContext;

    //设置报告数据
    public static void setReportData(ReportData reportData) {
        threadLocal.set(reportData);
    }

    //获取报告数据
    public static ReportData getReportData() {
        return threadLocal.get();
    }

    //移除报告数据
    public static void delReportData() {
        threadLocal.remove();
    }

    //获取bean工具方法
    public static <T> T getBean(Class<T> clz) {
        T bean = applicationContext.getBean(clz);
        assert bean == null;
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ReportUtil.applicationContext = applicationContext;
    }
}
