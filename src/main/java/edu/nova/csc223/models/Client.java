/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Progressive Software Development Project: Legal Records Manager
 *
 * @author Oscar Anaya
 */

package edu.nova.csc223.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Client(String clientID, String doa, String name, String dob, String ssn, String address, String followUpDate, String firm, String phase, String phaseDate, String hashtag, List<MedicalProvider> medicalProviders) {
   public Client {
       Objects.requireNonNull(clientID, "clientID cannot be null");
       Objects.requireNonNull(doa, "doa cannot be null");
       Objects.requireNonNull(name, "Client name cannot be null");
       Objects.requireNonNull(dob, "dob cannot be null");
       Objects.requireNonNull(ssn, "ssn cannot be null");
       Objects.requireNonNull(address, "address cannot be null");
       Objects.requireNonNull(followUpDate, "followUpDate cannot be null");
       Objects.requireNonNull(firm, "firm cannot be null");
       Objects.requireNonNull(phase, "phase cannot be null");
       Objects.requireNonNull(phaseDate, "phaseDate cannot be null");
       Objects.requireNonNull(hashtag, "hashtag cannot be null");

   }

    /**
     * Overloaded constructor. Created so i can add a List in the main compact constructor and use as a global parameter
     */
    public  Client(String clientID, String doa, String name, String dob, String ssn, String address, String followUpDate, String firm, String phase, String phaseDate, String hashtag) {
        this(clientID, doa, name, dob, ssn, address, followUpDate, firm, phase, phaseDate, hashtag, new ArrayList<>());

        }

        /**
         *Counter for number of medical providers
         *
         * @return int
         */
       public int getNumMedItems() {
            return medicalProviders.size();
        }

    /**
     * Add a medical provider object to the client
     * An alternative would've been creating a separate hashmap for the providers, but i need to preserve differences like status and notes
     */
    public void addMedProvider(MedicalProvider provider) {
        Objects.requireNonNull(provider, "provider cannot be null");
        medicalProviders.add(provider);
    }

    /**
     * toString() method override
     *
     * @return String
     */
    @Override
    public String toString() {

        return name + " DOA: " + doa;
    }
}
