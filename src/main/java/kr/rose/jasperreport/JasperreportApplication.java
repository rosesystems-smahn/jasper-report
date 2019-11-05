package kr.rose.jasperreport;

import kr.rose.jasperreport.service.EmployeeReportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JasperreportApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasperreportApplication.class, args);
    }

    @Bean
    public String generateReport(final EmployeeReportService employeeReportService) {

        String msg = employeeReportService.generateReport();

        System.out.println(msg);

        return msg;
    }
}
