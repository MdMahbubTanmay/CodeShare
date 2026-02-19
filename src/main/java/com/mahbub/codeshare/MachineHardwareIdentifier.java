/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahbub.codeshare;


/**
 *
 * @author mahbub
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MachineHardwareIdentifier {
    
    



    public static String getUniqueId() {
    String os = System.getProperty("os.name").toLowerCase();
    String id = "unknown-id";

    try {
        if (os.contains("win")) {
         
            String output = executeCommand("wmic csproduct get uuid");
            String[] lines = output.split("\n");
            if (lines.length > 1) {
                id = lines[1].trim(); // Line 0 is the header "UUID", Line 1 is the ID
            }
        } else {
           
            String output = executeCommand("cat /etc/machine-id");
            id = output.trim(); 
        }
    } catch (Exception e) {
        id = "error-fetching-id";
    }
    return id;
}

    private static String executeCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString();
    }

}
