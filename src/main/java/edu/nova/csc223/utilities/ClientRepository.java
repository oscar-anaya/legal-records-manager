/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * Repository interface for loading Client records and their List of pending MedicalProvider
 * readReport(String) needs to accept a String with report location and return a list of Clients,
 * each with a List of pending MedicalProviders
 *
 * @author Oscar Anaya
 */

package edu.nova.csc223.utilities;

import edu.nova.csc223.models.Client;
import java.util.List;

public interface ClientRepository {
    List<Client> readReport(String reportName);
}