package com.lavesh.design.patterns.structural.facade;

/*
 * Facade pattern is a structural pattern used to simplify the interface to a complex system.
 * It is used to provide a single uniform interface to a system containing multiple interfaces.
 * 
 * */

public class ReportHelperFacade {

	private static boolean isMySQlConnected = false;
	private static boolean isOracleConnected = false;
	
	public enum DatabaseType {
		MySql, Oracle
	}
	
	public enum ReportType {
		HTML, PDF
	}
	
	public static void generateReport(DatabaseType dbType, ReportType rpType) {
		
		
		switch (dbType) {
		case MySql:
			if (!isMySQlConnected) {
				MySqlReportGenerator.getMySqlConnection();
				isMySQlConnected = true;
			}
			switch (rpType) {
			case HTML:
				MySqlReportGenerator.HtmlReportGenerate();
				break;

			case PDF:
				MySqlReportGenerator.PdfReportGenerate();
				break;
			}
			break;

		case Oracle:
			if (!isOracleConnected) {
				OracleReportGenerator.getOracleConnection();
				isOracleConnected = true;
			}
			switch (rpType) {
			case HTML:
				OracleReportGenerator.HtmlReportGenerate();
				break;

			case PDF:
				OracleReportGenerator.PdfReportGenerate();
				break;
			}
			break;
		}
		
	}

}
