package com.dahuaboke;

import com.dahuaboke.report.Report;
import com.dahuaboke.report.ReportBuilder;
import com.dahuaboke.report.ReportData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dahua
 * @time 2023/8/8 11:46
 */
@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping("/test")
    public Report test() {
        return ReportBuilder.build(new ReportData());
    }
}
