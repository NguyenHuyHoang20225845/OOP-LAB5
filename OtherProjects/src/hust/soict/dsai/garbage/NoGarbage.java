package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

    public static void main(String[] args) {
        String filename = "test.exe"; // Specify your file path here
        byte[] inputBytes;
        long startTime, endTime;

        try {
            // Read all bytes from the file
            inputBytes = Files.readAllBytes(Paths.get(filename));

            // Measure the time for inefficient string concatenation
            startTime = System.currentTimeMillis();
           // String outputString = "";
          //  for (byte b : inputBytes) {
          //      outputString += (char) b; // Inefficient concatenation
         //   }
            StringBuilder outputStringBuilder = new StringBuilder();
            for ( byte b : inputBytes) {
            	outputStringBuilder.append((char)b);
            	
            	
            	
            }
            endTime = System.currentTimeMillis();

            // Output the execution time
            System.out.println("Time with inefficient concatenation: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
