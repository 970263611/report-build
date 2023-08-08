package com.dahuaboke.report;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dahua
 * @time 2023/8/8 11:07
 * 报告注册链条
 */
@Component
public class ReportRegisterChain {

    private List<ReportRegister> registerList = new ArrayList();

    //添加报告注册器
    public void append(AbstractPartGenerator partGenerator, Method method, MethodIndexEnum index) {
        append(new ReportRegister(partGenerator, method, index));
    }

    //添加报告注册器
    public void append(ReportRegister reportRegister) {
        registerList.add(reportRegister);
    }

    //获取注册链条
    public List<ReportRegister> getChain() {
        return registerList;
    }
}
