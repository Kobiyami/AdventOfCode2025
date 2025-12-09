import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day03 {
    public static void main(String[] args) {
        String filename = "inputs/day03.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String bank;
            int password = 0;

            while ((bank = br.readLine()) != null) {

                System.out.println("Line: " + bank);
                int max = -1;
                boolean found99 = false;

                for (int i = 0; i < bank.length(); i++) {
                    int d1 = bank.charAt(i) - '0';

                    for (int j = i + 1; j < bank.length(); j++) {
                        int d2 = bank.charAt(j) - '0';
                        int val = d1 * 10 + d2;

                        if (val > max) {
                            max = val;
                        }

                        if (val == 99) {
                            // meilleur possible : sortir de la boucle j si 99 trouvé
                            found99 = true;
                            break; // sort de la boucle j
                        }
                    }

                    if (found99) {
                        break; // sortir de la boucle i si 99 trouvé
                    }
                }

                System.out.println("Max = " + max);
                password += max;
            }

            System.out.println("Password total = " + password);

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
