import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day02 {

    public static void main(String[] args) {
        // Lecture du fichier
        String input = lireFichierEnString();

        // Résoudre le puzzle
        long resultat = resoudre(input);

        // Afficher
        System.out.println("Résultat: " + resultat);
    }

    // Fonction pour lire le fichier
    public static String lireFichierEnString() {
        try {
            return Files.readString(Paths.get("inputs/day02.txt"));
        } catch (IOException e) {
            System.err.println("Erreur lecture: " + e.getMessage());
            return "";
        }
    }

    public static long resoudre(String input) {
        input = input.replace("\n", "").replace("\r", "").trim();
        String[] ranges = input.split(",");

        long totalSomme = 0;

        for (String range : ranges) {
            range = range.trim();
            String[] parts = range.split("-");
            long debut = Long.parseLong(parts[0]);
            long fin = Long.parseLong(parts[1]);

            // Additionner tous les IDs repeated de ce range
            totalSomme += sommeRepeatedDansRange(debut, fin);
        }

        return totalSomme;
    }

    public static long sommeRepeatedDansRange(long debut, long fin) {
        long somme = 0;
        for (long id = debut; id <= fin; id++) {
            if (isRepeated(id)) {
                somme += id;
            }
        }
        return somme;
    }

    public static boolean isRepeated(long number) {
        String s = String.valueOf(number);
        if (s.length() % 2 != 0) {
            return false;
        }
        int mid = s.length() / 2;
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);
        return firstHalf.equals(secondHalf);
    }
}