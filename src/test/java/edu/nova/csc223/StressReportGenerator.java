/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * StressReportGenerator generates  "stress report.xlsx" for purposes of stress testing
 * Due to apache POI memory constrains, keep number of rows 100,000 or below this number
 * @author Oscar Anaya
 */

package edu.nova.csc223;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StressReportGenerator {

    public static void main(String[] args) throws IOException {

        generateReport(250, 20);
    }

    /**
     * Generates a sample Filevine report for stress testing purposes. saved to resources as: "stress report.xlsx"
     * @param numClients number of Clients in the report
     * @param providersPerClient number of MedicalProviders per Client
     * @throws IOException
     */
    public static void generateReport(int numClients, int providersPerClient) throws IOException {

        File outputFile = new File("src/main/resources/stress report - " + numClients + " clients.xlsx");
        if (outputFile.getParentFile() != null) {
            outputFile.getParentFile().mkdirs(); // Creates missing folders if needed
        }

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(outputFile)) {

            Sheet sheet = workbook.createSheet("Filevine Stress Report");

            // Create header row
            String[] headers = {"Received Date", "Project ID", "Date of Accident", "Client Full Name", "Client Date of Birth",
                    "Client's Details: Social Security Number", "Client Address Block", "Follow Up on R&B Task Prompt Trigger Date",
                    "Firm First Name", "Project Phase", "Phase Date", "Project Hashtags",
                    "Provider First Name", "Ordered Date", "Provider Address 1 Block with Company Info",
                    "Provider's Fax Phone", "Provider Email 1", "Notes", "Provider's Details: Notes"
            };

            Row headerRow = sheet.createRow(0);
            for (int c = 0; c < headers.length; c++) {
                headerRow.createCell(c).setCellValue(headers[c]);
            }

            // Generate client name and ID. rowNum is total rows in the report so it must remain outside of the outer loop
            int rowNum = 1;
            for (int i = 1; i <= numClients; i++) {
                String projectId = String.valueOf("Sample Project ID " + i);
                String clientName = "Test Client #" + i;

                //Generate the data for each column
                for (int j = 1; j <= providersPerClient; j++) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(""); // Received date must be blank
                    row.createCell(1).setCellValue(projectId);
                    row.createCell(2).setCellValue("00/00/0000");
                    row.createCell(3).setCellValue(clientName);
                    row.createCell(4).setCellValue("00/00/0000");
                    row.createCell(5).setCellValue("000-00-0000");
                    row.createCell(6).setCellValue(clientName + "\n123 Elden St St\nHerndon, VA 20170");
                    row.createCell(7).setCellValue("00/00/0000");
                    row.createCell(8).setCellValue("Law Firm");
                    row.createCell(9).setCellValue("Records & Bills");
                    row.createCell(10).setCellValue("00/00/0000");
                    row.createCell(11).setCellValue("#TestCase");
                    row.createCell(12).setCellValue("Medical Provider #" + j);
                    row.createCell(13).setCellValue("00/00/0000");
                    row.createCell(14).setCellValue("Medical Provider #" + j + "\n123 Elden St\nHerndon, VA 20170");
                    row.createCell(15).setCellValue("(000) 000-0000");
                    row.createCell(16).setCellValue("info@myemail.com");
                    row.createCell(17).setCellValue("These are sample notes\nMore notes\nEven more notes");
                    row.createCell(18).setCellValue("These are sample instructions\nMOre instructions\nEven more instructions");
                }
            }
            workbook.write(fileOut);
        }
        System.out.println("Generated target/stress_report - " + numClients + " clients.xlsx successfully!");
    }
}