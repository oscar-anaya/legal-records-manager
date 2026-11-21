/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * @author Oscar Anaya
 */

package edu.nova.csc223;

import edu.nova.csc223.models.MedicalProvider;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedicalProviderTest {

    /**
     * Tests null pointer exception on required fields
     */
    @Test
    void testNullPointerExceptionOnRequiredFields() {

        assertThrows(NullPointerException.class, () -> new MedicalProvider(null, "date ordered", "provider address",
                "provider fax", "provider email", "provider notes", "provider instructions"));

        assertThrows(NullPointerException.class, () -> new MedicalProvider("provider name", "date ordered", null,
                "provider fax", "provider email", null, "provider instructions"));

        assertThrows(NullPointerException.class, () -> new MedicalProvider("provider name", "date ordered", "provider address",
                "provider fax", "provider email", "provider notes", null));

    }

    /**
     * Tests a null provider won't be added to CLient
     */
    @Test
    void testNullProviderIsNotAddedToClient() {

    }

}
