/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahbub.codeshare;
import javax.swing.JOptionPane;
import java.awt.Component;
/**
 *
 * @author mahbub
 */
public class CompileCode {
    
    public static void CompileC(String MyCode, Component mahbub) {
    String code = MyCode;
    String fileName;
    String execName;
    
    String os = System.getProperty("os.name").toLowerCase();
    String home = System.getProperty("user.home");
    
    // Define paths clearly
    if (os.contains("win")) {
        // Use a simple path for teacher's Windows
        fileName = "C:\\Users\\Public\\Documents\\c_code.c";
        execName = "C:\\Users\\Public\\Documents\\c_code_exec.exe";
    } else {
        // Ubuntu Public folder
        fileName = home + "/Public/c_code.c";
        execName = home + "/Public/c_code_exec";
    }

    try {
        // 1. Write the file
        java.nio.file.Files.writeString(java.nio.file.Paths.get(fileName), code);

        // 2. Compile with GCC
        // Note: We tell GCC exactly where to put the output file
        Process compile = new ProcessBuilder("gcc", fileName, "-o", execName).start();
        int exitCode = compile.waitFor();

        if (exitCode == 0) {
            if (os.contains("win")) {
                // Windows command to open new CMD and run
                new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", "\"" + execName + "\"").start();
            } else {
                // Ubuntu command for gnome-terminal
                new ProcessBuilder("gnome-terminal", "--", "bash", "-c", execName + "; echo; echo 'Process finished. Press any key to exit...'; read -n1; exec bash").start();
            }
        } else {
            JOptionPane.showMessageDialog(mahbub, "Compilation Failed! Check your C syntax.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(mahbub, "Error: " + ex.getMessage());
        ex.printStackTrace();
    }
    }
    
}
