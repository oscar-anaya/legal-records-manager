/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * Interface class for parsing the Filevine report. readReport needs to accept a String with
 * report name and return a list of Clients, each with a List of pending MedicalProviders
 * @author Oscar Anaya
 */

package edu.nova.csc223.utilities;

import edu.nova.csc223.models.Client;
import java.util.List;

public interface ClientRepository {
    List<Client> readReport(String reportName);
}