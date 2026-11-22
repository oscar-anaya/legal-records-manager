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
import edu.nova.csc223.utilities.ClientRepository;
import edu.nova.csc223.utilities.ExcelParser;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BaselineTesting {

    private final ClientRepository repo = new ExcelParser();

    /**
     * T-01: tests a normal successful case
     */
    @Test
    void testNormalCase() {

        List<Client> clientList = repo.readReport("stress report - 250 clients.xlsx");
        String consoleOutput = captureConsoleOutputFromExcelReport(clientList);

        assertEquals(250, clientList.size());
        assertTrue(consoleOutput.contains("Test Client #250"));
        assertTrue(consoleOutput.contains("Medical Provider #20"));
    }

    /**
     * T-02: Tests a second normal case with different data
     */
    @Test
    void testDifferentNormalCase() {

        List<Client> clientList = repo.readReport("sample report.xlsx");
        String consoleOutput = captureConsoleOutputFromExcelReport(clientList);

        assertEquals(8, clientList.size());
        assertTrue(consoleOutput.contains("Total Clients: 8"));
    }

    /**
     * T-03: Tests an empty input (Filevine report contains 0  Clients)
     */
    @Test
    void testEmptyInput() {

        List<Client> clientList = repo.readReport("stress report - 0 clients.xlsx");
        String consoleOutput = captureConsoleOutputFromExcelReport(clientList);

        assertEquals(0, clientList.size());
        assertEquals(consoleOutput.trim(), "Total Clients: 0");
    }

    /**
     * T-04: Tests a single Client input. Also tests to verify multiple Clients are not created
     *  when multiple pending Medical Providers share the same clientID
     */
    @Test
    void testSingleItemInput() {

        List<Client> clientList = repo.readReport("stress report - 1 clients.xlsx");
        String consoleOutput = captureConsoleOutputFromExcelReport(clientList);

        assertEquals(1, clientList.size());
        assertTrue(consoleOutput.contains("Total Clients: 1"));
    }

    /**
     * T-05: Tests input with 0 matches (All medical records have received date)
     */
    @Test
    void testNoMatchInput() {

        List<Client> clientList = repo.readReport("stress report - all medical records received.xlsx");
        String consoleOutput = captureConsoleOutputFromExcelReport(clientList);

        assertEquals(0, clientList.size());
        assertEquals(consoleOutput.trim(), "Total Clients: 0");
    }

    /**
     *  T-06: Tests upper boundary: 5000 Clients each with 20 Medical Providers
     */
    @Test
    void testUpperBoundary() {
    List<Client> clientList = repo.readReport("stress report - 5000 clients.xlsx");
    String consoleOutput = captureConsoleOutputFromExcelReport(clientList);

    assertEquals(5000, clientList.size());
    assertTrue(consoleOutput.contains("Test Client #5000"));
    assertTrue(consoleOutput.contains("Medical Provider #20"));
    }

    /**
     * T-07: Tests invalid input (Filevine report does not exist)
     */
    @Test
    void testInvalidInput() {

        List<Client> clientList = repo.readReport("test invalid report.xlsx");
        String consoleOutput = captureConsoleOutputFromExcelReport(clientList);

        assertNotNull(clientList);
        assertTrue(clientList.isEmpty());
        assertEquals(consoleOutput.trim(),"Total Clients: 0");
    }


    /**
     * Helper method to run printExcelReport(List) and capture console output
     * */
    private String captureConsoleOutputFromExcelReport(List<Client> clientList) {

        PrintStream originalOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            PrintRawReports.printExcelReport(clientList);
        } finally {
            System.setOut(originalOut);
        }
        return buffer.toString(StandardCharsets.UTF_8);
    }
}
