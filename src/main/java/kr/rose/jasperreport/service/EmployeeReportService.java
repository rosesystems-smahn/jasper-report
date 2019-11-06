package kr.rose.jasperreport.service;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.rose.jasperreport.dto.Employee;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import org.springframework.stereotype.Service;


import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmployeeReportService {

    private List<Employee> empList = Arrays.asList(
            new Employee(1, "Sandeep", "Data Matrix", "Front-end Developer", 20000),
            new Employee(2, "Prince", "Genpact", "Consultant", 40000),
            new Employee(3, "Gaurav", "Silver Touch ", "Sr. Java Engineer", 47000),
            new Employee(4, "Abhinav", "Akal Info Sys", "CTO", 700000));

    public String generateReport() {
        try {

            String reportPath = "E:\\content\\report";

            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "\\employee-rpt.jrxml");

            // Get your data source
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(empList);

            // Add parameters
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "Rosesystems.kr");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    jrBeanCollectionDataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Emp-Rpt.pdf");

            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportPath + "\\Emp-Rpt.html");

            /**
             * JasperExportManager 를 거치지 않고 String 형식으로 반환하는 코드,,,,,
             * 참고 URL
             * https://stackoverflow.com/questions/27779612/export-jasperreports-in-html-format
             */
            Exporter exporter = new HtmlExporter();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            exporter.setExporterOutput(new SimpleHtmlExporterOutput(out));
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.exportReport();

            System.out.println("Done");

            String iframe = "<iframe src=\"file:\\\\\\" + reportPath + "\\Emp-Rpt.html  \" width=\"600\" height=\"300\">";

            return "Report successfully generated @path= " + reportPath + "<p></p>" + out.toString("UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    private String htmlText(ByteArrayOutputStream out){
        return "";
    }
}
