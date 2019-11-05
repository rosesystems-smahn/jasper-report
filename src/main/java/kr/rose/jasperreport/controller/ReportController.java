package kr.rose.jasperreport.controller;


import kr.rose.jasperreport.service.EmployeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class ReportController {
    @Autowired
    private EmployeeReportService employeeReportService;

    @GetMapping("/report")
    public String empReport(){
        return employeeReportService.generateReport();
    }
}
