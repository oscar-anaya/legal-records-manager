/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * @author Oscar Anaya
 */

package edu.nova.csc223;

import edu.nova.csc223.models.Client;
import edu.nova.csc223.models.MedicalProvider;
import edu.nova.csc223.reports.PrintRawReports;
import edu.nova.csc223.utilities.ExcelParser;
import edu.nova.csc223.utilities.ClientRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        System.out.println("Progressive Software Development Project: Legal Records Manager");
        System.out.println("Project Structure Created successfully!");

        ClientRepository repo = new ExcelParser();
        List<Client> clientList = repo.readReport("sample report.xlsx");

        //printRawReport(clientList);

        //printClientReport(clientList);


        long pairwiseStart = System.nanoTime();
        PrintRawReports.printPendingReport(clientList);
        long pairwiseEnd = System.nanoTime();
        System.out.println("Elapsed time for the stress test: " + String.format("%.3f", (pairwiseEnd - pairwiseStart) / 1_000_000_000.0) + " seconds");
    }


    }