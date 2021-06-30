package com.lavesh.design.patterns.structural.facade;

public class OracleReportGenerator {
	
	public static void getOracleConnection() {
		System.out.println("Getting Oracle Connection.");
	}
	
	public static void PdfReportGenerate() {
		System.out.println("Generating Pdf Report using Oracle Connection");
	}
	
	
	public static void HtmlReportGenerate() {
		System.out.println("Generating HTML report using Oracle Connection");
	}

}
