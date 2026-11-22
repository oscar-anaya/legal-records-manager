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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    /**
     * Tests the methods addMedProvider
     * Also tests the getNumMedItems MedicalProvider counter
     * Also represents best-case scenario
     */
    @Test
    void testAddMedProvider() {
        Client client = new Client("clientID", "doa", "client name", "dob","ssn", "address",
                "followUpDate", "law firm", "phase", "phaseDate", "hashtag", new ArrayList<>());

        assertEquals(0, client.getNumMedItems());

        MedicalProvider provider = new MedicalProvider("provider name", "date ordered", "provider address",
                "provider fax", "provider email", "provider notes", "provider instructions");
        client.addMedProvider(provider);

        assertEquals(1, client.getNumMedItems());
    }

    /**
     * Verifies input preservation: makes sure adding medical providers to a Client does not modify the original list used as input
     */
    @Test
    void testMedProviderInputListPreservation() {
        List<MedicalProvider> originalProviderList = new ArrayList<>();
        MedicalProvider firstProvider = new MedicalProvider("provider name", "date ordered", "provider address",
                "provider fax", "provider email", "provider notes", "provider instructions");
        originalProviderList.add(firstProvider);

        Client client = new Client("clientID", "doa", "client name", "dob","ssn", "address",
                "followUpDate", "law firm", "phase", "phaseDate", "hashtag", new ArrayList<>(originalProviderList));

        client.addMedProvider(new MedicalProvider("provider 2 name", "date ordered", "provider 2 address",
                "provider 2 fax", "provider 2 email", "provider 2 notes", "provider 2 instructions"));

        assertEquals(1, originalProviderList.size(), "Original provider list should containe only one medical provider");
    }

    /**
     * Tests null pointer exception on required fields
     */
    @Test
    void testNullPointerExceptionOnRequiredFields() {
        assertThrows(NullPointerException.class, () -> new Client(
                null, "doa", "client name", "dob","ssn", "address",
                "followUpDate", "law firm", "phase", "phaseDate", "hashtag", new ArrayList<>()));

        assertThrows(NullPointerException.class, () -> new Client(
                "clientID", "doa", null, "dob","ssn", "address",
                "followUpDate", "law firm", "phase", "phaseDate", "hashtag", new ArrayList<>()));

        assertThrows(NullPointerException.class, () -> new Client(
                "clientID", "doa", "client name", "dob","ssn", "address",
                "followUpDate", "law firm", "phase", "phaseDate", null,  new ArrayList<>()));
    }

    /**
     * Representative worst-case stress test
     */
    @Test
    void testWorstCaseScenario(){

        long pairwiseStart = System.nanoTime();
        Map<String, Client> clientMap = new LinkedHashMap<>();

        for(int i = 0; i < 5000; i++) {

            Client client = new Client("clientID" + " " + i, "doa", "client name", "dob", "ssn", "address",
                    "followUpDate", "law firm", "phase", "phaseDate", "hashtag", new ArrayList<>());

            for (int j = 0; j < 100; j++) {
                MedicalProvider provider = new MedicalProvider("provider name", "date ordered", "provider address",
                        "provider fax", "provider email", "provider notes", "provider instructions");
                client.addMedProvider(provider);
            }
            clientMap.put(client.clientID(), client);
        }

        assertEquals(5000, clientMap.size());
        assertEquals(100, clientMap.get("clientID 0").getNumMedItems());
        assertEquals(100, clientMap.get("clientID 499").getNumMedItems());

        long pairwiseEnd = System.nanoTime();
        System.out.println("Elapsed time for the stress test: " + String.format("%.3f", (pairwiseEnd - pairwiseStart) / 1_000_000_000.0) + " seconds");
    }

    /**
     * Tests a null provider won't be added to Client
     */
    @Test
    void testNullProviderIsNotAddedToClient() {

        Client client = new Client("clientID", "doa", "client name", "dob","ssn", "address",
                "followUpDate", "law firm", "phase", "phaseDate", "hashtag", new ArrayList<>());

        assertThrows(NullPointerException.class, () -> client.addMedProvider(null));

        assertEquals(0, client.getNumMedItems());
    }
}



