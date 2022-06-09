import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc51 {
    char[][] board;
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> diagSet = new HashSet<>();
    Set<Integer> antiDiagSet = new HashSet<>();
    List<List<String>> res;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new char[n][n];
        this.res = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }
        backtrack(0);
        return res;
    }

    private List<String> transform(char[][] board) {
        ArrayList<String> res = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder rowSb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                rowSb.append(board[row][col]);
            }
            res.add(rowSb.toString());
        }
        return res;
    }

    private void backtrack(int row) {
        if (row == n) {
            res.add(transform(board));
        }
        for (int col = 0; col < n; col++) {
            if (valid(col, row + col, row - col)) {
                board[row][col] = 'Q';
                colSet.add(col);
                diagSet.add(row + col);
                antiDiagSet.add(row - col);
                backtrack(row + 1);
                board[row][col] = '.';
                colSet.remove(col);
                diagSet.remove(row + col);
                antiDiagSet.remove(row - col);
            }
        }
    }

    private boolean valid(int col, int diag, int antiDiag) {
        return !colSet.contains(col) && !diagSet.contains(diag) && !antiDiagSet.contains(antiDiag);
    }
}
