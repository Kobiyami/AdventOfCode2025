import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day04 {

    public static void main(String[] args) {
        String filename = "inputs/day04.txt";

        ArrayList<String> lines = new ArrayList<>();

        // Lecture toutes les lignes
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int rows = lines.size();
        int cols = lines.get(0).length();

        // Construction de la grille
        char[][] grid = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            grid[r] = lines.get(r).toCharArray();
        }

        // Offsets des 8 directions
        int[][] dirs = {
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };

        int accessible = 0;

        // Parcours de la grille
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] != '@') continue;

                int voisins = 0;

                // décompte des voisins @
                for (int[] d : dirs) {
                    int rr = r + d[0];
                    int cc = c + d[1];

                    if (rr >= 0 && rr < rows && cc >= 0 && cc < cols) {
                        if (grid[rr][cc] == '@') {
                            voisins++;
                        }
                    }
                }

                if (voisins < 4) {
                    accessible++;
                }
            }
        }

        System.out.println("Nombre de rolls accessibles = " + accessible);
    }
}
