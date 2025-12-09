import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day03 {
    public static void main(String[] args) {
        String filename = "inputs/day03.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch(IOException e){
                e.printStackTrace(System.err);
            }
    }
}
