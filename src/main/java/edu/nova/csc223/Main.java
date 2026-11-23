/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * @author Oscar Anaya
 */

package edu.nova.csc223;

import edu.nova.csc223.models.Client;
import edu.nova.csc223.reports.PrintRawReports;
import edu.nova.csc223.utilities.ExcelParser;
import edu.nova.csc223.utilities.ClientRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        System.out.println("Progressive Software Development Project: Legal Records Manager");
        System.out.println("Project Structure Created successfully!");

        //Base algorithm
        ClientRepository repo = new ExcelParser();
        List<Client> clientList = repo.readReport("sample report.xlsx");

        PrintRawReports.printExcelReport(clientList);

        //Base algorithm. Same as above
        //PrintRawReports.printExcelReport(new ExcelParser().readReport("sample report.xlsx"));

    }
    }