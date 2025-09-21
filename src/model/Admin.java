package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public static boolean isValidAdmin(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("admin.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String fileUsername = parts[0].trim();
                    String filePassword = parts[1].trim();

                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading admin.txt: " + e.getMessage());
        }
        return false;
    }
}