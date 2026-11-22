/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * Contains the methods printPendingReport and printClientReport. Both help with printing reports to the terminal
 * @author Oscar Anaya
 */
package edu.nova.csc223.reports;

import edu.nova.csc223.models.Client;
import edu.nova.csc223.models.MedicalProvider;
import java.util.List;

public class PrintRawReports {
    /**
     * Reads the raw Filevine Excel report and prints all clients with pending medical providers.
     * @param clientList ArrayList of Clients each with a list of pending MedicalProviders
     */
    public static void printExcelReport(List<Client> clientList) {

        //Outside loop prints Clients, inside loop prints the medial providers in each Client
        System.out.println("\n\nTotal Clients: " + clientList.size());
        for (Client client : clientList) {
            System.out.println("\n" + client.toString());
            for (MedicalProvider provider : client.medicalProviders()) {
                System.out.println(provider.toString());
            }
        }
    }

    /**
     * Prints a list of Clients with phase date and medical provider count
     * @param clientList ArrayList of Clients each with a list of pending MedicalProviders
     */
    public static void printExcelClientReport(List<Client> clientList) {

        System.out.println("\n" + String.format("%-25s %-11s %-11s", "Client", "Phase Date", "Pending Provider Count"));

        for (Client client : clientList) {
            System.out.println(String.format("%-25s %-11s %-11s", client.name(), client.phaseDate(), client.getNumMedItems()));
        }
    }
}
