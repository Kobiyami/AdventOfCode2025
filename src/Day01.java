import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day01 {
public static void main(String[] args) {
        System.out.println("AdventOfCode Day 01 - first step");

        // PSEUDO-CODE :
        // On initialise la variable dial à 50
        int dial = 50;
        // On initialise une variable password à 0
        int password = 0;
        // On parcourt toutes les lignes de l'input
   String filename = "inputs/day01.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;
        while ((line = br.readLine()) != null) {

            System.out.println(line);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}