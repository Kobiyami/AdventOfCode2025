import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day03 {

    public static void main(String[] args) {
        String filename = "inputs/day03.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String bank;
            long password = 0; // peut dépasser un int

            while ((bank = br.readLine()) != null) {

                System.out.println("Line: " + bank);

                /*int max = -1;
                boolean found99 = false;
                for (int i = 0; i < bank.length(); i++) {
                    int d1 = bank.charAt(i) - '0';
                    for (int j = i + 1; j < bank.length(); j++) {
                        int d2 = bank.charAt(j) - '0';
                        int val = d1 * 10 + d2;
                        if (val > max) max = val;
                        if (val == 99) { found99 = true; break; }
                    }
                    if (found99) break;
                }
                password += max;
                System.out.println("Max = " + max);
                */

                // NOUVEAU CODE : récupérer la meilleure "sous-séquence" de 12 digits
                String best12 = meilleureSequence12(bank);

                System.out.println("sequence de 12 = " + best12);

                long value12 = Long.parseLong(best12);
                password += value12;
            }

            System.out.println("Password total = " + password);

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Trouve la meilleure sous-séquence lexicographique de longueur 12.
     */
    private static String meilleureSequence12(String s) {
        int n = s.length();
        int k = 12;

        StringBuilder result = new StringBuilder(k);

        int start = 0;

        for (int remaining = k; remaining > 0; remaining--) {

            int end = n - remaining;
            // dernière position possible pour ce choix

            char best = '0' - 1;
            int bestPos = start;

            for (int i = start; i <= end; i++) {
                char c = s.charAt(i);

                if (c > best) {
                    best = c;
                    bestPos = i;
                }
                if (best == '9') break; // optimisation
            }

            result.append(best);
            start = bestPos + 1;
        }

        return result.toString();
    }
}
