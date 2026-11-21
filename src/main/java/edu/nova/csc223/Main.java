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
import edu.nova.csc223.utilities.ExcelParser;
import edu.nova.csc223.utilities.ClientRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        System.out.println("Progressive Software Development Project: Legal Records Manager");
        System.out.println("Project Structure Created successfully!");

        ClientRepository repo = new ExcelParser();
        List<Client> clientList = repo.readReport();

        //Outside loop prints Clients, inside loop prints the medial providers in each Client
        System.out.println("\n\nTotal Clients: " + clientList.size());
        for (Client client : clientList) {
            System.out.println("\n" + client.toString());
                for (MedicalProvider provider : client.medicalProviders()) {
                    System.out.println(provider.toString());
                }
        }
    }
}