/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Programming Challenge Module 2 - Baseline Algorithm and Complexity Analysis
 *
 * @author Oscar Anaya
 */

package edu.nova.csc223.models;

import java.util.Objects;

public record MedicalProvider(String name, String ordered, String address, String fax, String email, String notes, String instructions) {
    public MedicalProvider {
        Objects.requireNonNull(name, "name cannot be null");
        Objects.requireNonNull(ordered, "ordered cannot be null");
        Objects.requireNonNull(address, "address cannot be null");
        Objects.requireNonNull(fax, "fax cannot be null");
        Objects.requireNonNull(email, "email cannot be null");
        Objects.requireNonNull(notes, "notes cannot be null");
        Objects.requireNonNull(instructions, "instructions cannot be null");
    }

    /**
     * toString method override
     *
     * @return String
     */
    @Override
    public String toString() {

        //More complete details
        //String providerDetails = String.format("%-11s %-11s %-11s %-11s\n",name, ordered, fax, email, notes);

        return name;
    }
}
