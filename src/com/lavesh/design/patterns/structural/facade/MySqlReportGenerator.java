package com.lavesh.design.patterns.structural.facade;

public class MySqlReportGenerator {
	
	public static void getMySqlConnection() {
		System.out.println("Getting MySql Connection.");
	}
	
	public static void PdfReportGenerate() {
		System.out.println("Generating Pdf Report using MySql Connection");
	}
	
	
	public static void HtmlReportGenerate() {
		System.out.println("Generating HTML report using MySql Connection");
	}

}
