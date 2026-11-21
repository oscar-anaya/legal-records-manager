/**
 * CSC 223 - Data Structures and Algorithms
 * Professor Emilia Butu
 * Programming Challenge Module 2 - Baseline Algorithm and Complexity Analysis
 *
 * @author Oscar Anaya
 */

package edu.nova.csc223.utilities;

import edu.nova.csc223.models.Client;
import java.util.List;

public interface ClientRepository {
    List<Client> readReport();
}