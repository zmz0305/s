import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lc36 {
    Set<Character>[] rowSet;
    Set<Character>[] colSet;
    Set<Character>[] blockSet;

    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        rowSet = new HashSet[N];
        colSet = new HashSet[N];
        blockSet = new HashSet[N];
        int rows = N;
        int cols = N;
        for (int i = 0; i < N; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            blockSet[i] = new HashSet<>();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                Character val = board[row][col];
                int block = row / 3 * 3 + col / 3;
                if (val > 9 || val < 1 || rowSet[row].contains(val) || colSet[col].contains(val) || blockSet[block].contains(val)) {
                    System.out.println(row);
                    System.out.println(col);
                    System.out.println(Arrays.toString(rowSet));
                    System.out.println(Arrays.toString(colSet));
                    System.out.println(Arrays.toString(blockSet));
                    return false;
                }
                rowSet[row].add(val);
                colSet[col].add(val);
                blockSet[block].add(val);
            }
        }
        return true;
    }
}
