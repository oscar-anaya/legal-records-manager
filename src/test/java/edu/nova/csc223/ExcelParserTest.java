/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * @author Oscar Anaya
 */

package edu.nova.csc223;

import edu.nova.csc223.models.Client;
import edu.nova.csc223.utilities.ClientRepository;
import edu.nova.csc223.utilities.ExcelParser;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExcelParserTest {

    /**
     * Tests the readReport() method:
     * readReport() returns a List object rather than a Null
     * a Client list is generated from the FileVine report and it's not misread as being empty
     * @throws Exception
     */
    @Test
    void testReadReport() throws Exception {
        ClientRepository repo = new ExcelParser();
        List<Client> clientList = repo.readReport();

        assertNotNull(clientList);
        assertFalse(clientList.isEmpty(), "Parsed client list should not be empty");

        // Verify every parsed client has a valid ID and Name
        for (Client client : clientList) {
            assertFalse(client.clientID().isBlank(), "Client ID should not be blank");
            assertFalse(client.name().isBlank(), "Client name should not be blank");
            System.out.println("Client ID: " + client.clientID() + "\nClient name: " + client.name() + "\n");
        }
    }
}
