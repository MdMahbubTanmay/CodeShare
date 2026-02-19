/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahbub.codeshare;

/**
 *
 * @author mahbub
 */


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

public class GetData {
    public static String getCode() throws Exception {
        Firestore db = FirebaseInitializer.getFirestore();
        
        // Pointing to sourceUID instead of MID to fetch the specific user's code
        DocumentReference docRef = db.collection("Rooms").document(MainUI.joinUID);
        
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get(); 

        if (document.exists()) {
            // Check if the "Code" field actually exists in that document
            String fetchedCode = document.getString("Code");
            return (fetchedCode != null) ? fetchedCode : "// No code found in this document";
        } else {
            return "// Error: Invalid Room!";
        }
    }
}
