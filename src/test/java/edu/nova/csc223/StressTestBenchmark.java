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

import edu.nova.csc223.models.Client;
import edu.nova.csc223.reports.PrintRawReports;
import edu.nova.csc223.utilities.ClientRepository;
import edu.nova.csc223.utilities.ExcelParser;

import java.util.List;

public class StressTestBenchmark {

    public static void main(String[] args) {

       ClientRepository repo = new ExcelParser();
       String testReport = "stress report - 250 clients.xlsx";

        for(int i = 0; i < 5; i++) {
            List<Client> clientList = repo.readReport("stress report - 5000 clients.xlsx");
            PrintRawReports.printExcelReport(clientList);
        }

        System.out.println("Java Virtual Machine is warmed up");

        long pairwiseStart = System.nanoTime();
        List<Client> clientStressTestList = repo.readReport(testReport);
        long pairwiseEnd = System.nanoTime();
        String parseTestSeconds = String.format("%.5f", (pairwiseEnd - pairwiseStart) / 1_000_000_000.0) + " seconds";

        pairwiseStart = System.nanoTime();
        PrintRawReports.printExcelReport(clientStressTestList);
        pairwiseEnd = System.nanoTime();
        String printTestSeconds = String.format("%.5f", (pairwiseEnd - pairwiseStart) / 1_000_000_000.0) + " seconds";

        System.out.println("\nElapsed time for the Parsing stress test: " + parseTestSeconds);
        System.out.println("\nElapsed time for the report print stress test: " + printTestSeconds);
    }
}
