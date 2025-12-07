import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day01 {
public static void main(String[] args) {
        //System.out.println("AdventOfCode Day 01 - first part");
        System.out.println("AdventOfCode Day 01 - second part");

        // PSEUDO-CODE :
        // variable pour compter le numéro de la ligne du fichier input
        int nbLine = 1;
        // On initialise la variable dial à 50
        int dial = 50;
        // On initialise une variable password à 0
        int password = 0;
        // On parcourt toutes les lignes de l'input
    String filename = "inputs/day01.txt";
    //String filename = "inputs/test.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            int nbOfClicks = Integer.parseInt(line.substring(1));
            System.out.println("Numéro de ligne " + nbLine);
            System.out.println("Dial avant modif " + dial);
            System.out.println("direction " + line.charAt(0));
            System.out.println("nombre de clics réels " + nbOfClicks);
            System.out.println("mot de passe avant simplification " + password);
            password+=nbOfClicks / 100; // on augmente password tous les 100 clicks
            nbOfClicks=nbOfClicks % 100; // et donc on soustraie ce nombre de clicks pour avoir un nombre de clicks restant à faire inférieur à 100
            System.out.println("nombre de clics "+ nbOfClicks);
            System.out.println("nouveau mot de passe " + password);
            // Dial est maintenant compris entre 0 et 99
            //Si nbOfClicks != 0 ALORS
            if (nbOfClicks != 0){
                if (line.charAt(0)=='R') {
                    if (dial + nbOfClicks == 100) {
                        dial = 0;
                        password += 1;
                    } else if (dial + nbOfClicks > 100) {
                        dial = dial + nbOfClicks - 100;
                        password += 1;
                    } else {
                        dial = dial + nbOfClicks;
                    }
                }
                else if (dial - nbOfClicks == 0){
                    password += 1;
                    dial = 0;
                } else if (dial==0){
                    dial = 100 - nbOfClicks + dial;
                } else if (nbOfClicks > dial){
                    dial = 100 - nbOfClicks + dial;
                    password += 1;
                } else {dial = dial - nbOfClicks;
                }


            }

            System.out.println("Dial après modification "+ dial);
            System.out.println("Mot de passe après modifications " + password);
            nbLine+=1;        }

    } catch (IOException e) {
        e.printStackTrace(System.err);
    }
    System.out.println(password);
}
}
