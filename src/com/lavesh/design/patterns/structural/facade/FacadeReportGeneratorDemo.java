package com.lavesh.design.patterns.structural.facade;

public class FacadeReportGeneratorDemo {

    public static void main(String[] args) {
        ReportHelperFacade.generateReport(ReportHelperFacade.DatabaseType.MySql, ReportHelperFacade.ReportType.HTML);
        ReportHelperFacade.generateReport(ReportHelperFacade.DatabaseType.MySql, ReportHelperFacade.ReportType.PDF);

        ReportHelperFacade.generateReport(ReportHelperFacade.DatabaseType.Oracle, ReportHelperFacade.ReportType.HTML);
        ReportHelperFacade.generateReport(ReportHelperFacade.DatabaseType.Oracle, ReportHelperFacade.ReportType.PDF);
    }


}
