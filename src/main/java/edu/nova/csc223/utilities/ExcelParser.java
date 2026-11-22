/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * readReport(String) creates a LinkedHashMap with clientID keys in order to parse the Filevine report,
 * but returns an ArrayList since LinkedHashMap is no longer needed as each Client object holds clientID key.
 * I will revisit this later in case a LinkedHashMap needs to be returned as the application grows.
 *
 * @author Oscar Anaya
 */
package edu.nova.csc223.utilities;

import edu.nova.csc223.models.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser implements ClientRepository {

    /**
     * Parses the Filevine report to generate an ArrayList of Client with pending MedicalProvider objects
     *
     * @param reportName name of Filevine report to be read. Need to include extension in filename (.xlsx)
     * @return reportArray Array list of Clients each with a list of pending MedicalProvider objects
     */
    public ArrayList<Client> readReport(String reportName) {

        // Declare local variables.
        ArrayList<Client> reportArray;
        Map<String, Client> clientMap = new LinkedHashMap<>();

        try (FileInputStream fis = new FileInputStream("src/main/resources/" + reportName);
             Workbook clientReport = new XSSFWorkbook(fis)) {

            Sheet sheet = clientReport.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip Header

                // Row-level skip: check if records were already received and skip if true
                String receivedDate = getCellValue(row.getCell(0));
                if (!receivedDate.isEmpty())
                    continue;

                String clientID = getCellValue(row.getCell(1)); //Client ID

                // Create client if does not exist and add to clientMap
                Client client = clientMap.get(clientID);
                if (client == null) {
                    client = new Client(
                            clientID,
                            getCellValue(row.getCell(2)),//DOA
                            getCellValue(row.getCell(3)),// Client name
                            getCellValue(row.getCell(4)), // DOB
                            getCellValue(row.getCell(5)), // SSN
                            getCellValue(row.getCell(6)), // Address
                            getCellValue(row.getCell(7)), // Follow-up Task
                            getCellValue(row.getCell(8)), // Firm Name
                            getCellValue(row.getCell(9)), // Project Phase
                            getCellValue(row.getCell(10)), // Phase Date
                            getCellValue(row.getCell(11)) // Hashtag
                    );
                    clientMap.put(clientID, client);
                }

                // Add the Medical Provider from this row to the client
                MedicalProvider provider = new MedicalProvider(
                        getCellValue(row.getCell(12)), // Provider Name
                        getCellValue(row.getCell(13)), // Ordered Date
                        getCellValue(row.getCell(14)), // Address
                        getCellValue(row.getCell(15)), // Fax
                        getCellValue(row.getCell(16)), // Email
                        getCellValue(row.getCell(17)), // Notes
                        getCellValue(row.getCell(18))  // Detail Notes
                );

                client.addMedProvider(provider);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        reportArray = new ArrayList<>(clientMap.values());
        return reportArray;
    }

    /**
     * Helper to safely extract cell values as Strings regardless of Excel type
     */
    private static String getCellValue(Cell cell) {

        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter(); // POI utility to reformat each cell column into whatever it's visible
        return formatter.formatCellValue(cell).trim();
    }
}
