package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceLeakExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            String firstLine = reader.readLine();
            System.out.println(firstLine);
            // The reader is not closed in this execution path
            if (firstLine == null) {
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Resource leak: 'reader' is never closed on normal or exceptional execution paths
    }
}
