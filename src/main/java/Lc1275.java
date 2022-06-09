public class Lc1275 {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antidiag = 0;
        int player = 1;
        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];
            rows[row] += player;
            cols[col] += player;
            if (row == col) {
                diag += player;
            }
            if (row + col == 2) {
                antidiag += player;
            }
            if (Math.abs(rows[row]) == 3 || Math.abs(cols[col]) == 3 || Math.abs(antidiag) == 3 || Math.abs((diag)) == 3) {
                if (player == 1) {
                    return "A";
                } else {
                    return "B";
                }
            }
            player *= -1;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
