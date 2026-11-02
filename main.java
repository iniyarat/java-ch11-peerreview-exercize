/*
Program: Chapter 12 Peer Review Exercize
Programmer: Iniya Rathinakumar
Date: November 2nd, 2026
The program reads an unspecified number of numerical scores from the online text file provided in the assignment.
*/

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
* Reads scores from an online text file and displays their total and average.
* @author Iniya Rathinakumar
*/
public class Chapter12Exercise {

    /**
    * Reads the scores from the online file and calculates the total and average.
    * @param args command-line arguments
    */
    public static void main(String[] args) {
        String fileURL = "https://liveexample.pearsoncmg.com/data/Scores.txt";
        double total = 0;
        int count = 0;
        try {
            URL url = new URL(fileURL);
            Scanner input = new Scanner(url.openStream());
            while (input.hasNextDouble()) {
                double score = input.nextDouble();
                total += score;
                count++;
            }
            input.close();
            if (count > 0) {
                double average = total / count;
                System.out.println("Total is " + total);
                System.out.println("Average is " + average);
            } else {
                System.out.println("No scores were found.");
            }
        } catch (IOException e) {
            System.out.println("The file could not be read.");
            System.out.println(e.getMessage());
        }
    }
}