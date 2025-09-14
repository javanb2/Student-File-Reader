package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileScanner fileScanner = new FileScanner();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename: " );
        String fileName = scanner.nextLine();
        scanner.close();
        try {
            fileScanner.addFile(fileName);
            fileScanner.printStats();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}