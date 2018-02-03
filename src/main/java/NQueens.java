import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Qing (Chris) Yuan on Feb/03/2018 3:30 PM
 */
public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4;
        nQueens.solveNQueens(n);

    }

    private List<List<String>> lol = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return lol;

        int[][] board = new int[n][n];

        solveRow(0, board);
        return lol;
    }

    private void solveRow(int curRow, int[][] board) {
        if (curRow == board.length) {
            appendResult(board);
            return;
        }
        int limit = board.length;
        if(curRow == 0) limit = (limit + 1)/2;

        for (int i = 0; i < limit; i++) {
            if (validMove(board, curRow, i)) {
                board[curRow][i] = 1;
                solveRow(curRow + 1, board);
                board[curRow][i] = 0;
            } else continue;
        }
    }

    private boolean validMove(int[][] board, int rowIndex, int colIndex) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((colIndex == j || Math.abs(rowIndex - i) == Math.abs(colIndex - j)) && board[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    private void appendResult(int[][] board) {
        List<String> list_1 = new ArrayList<>(board.length);
        List<String> list_2 = new ArrayList<>(board.length);
        StringBuilder stringBuilder_1 = null,
            stringBuilder_2 = null;
        for (int i = 0; i < board.length; i++) {
            stringBuilder_1 = new StringBuilder();
            stringBuilder_2 = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                stringBuilder_1.append((board[i][j] == 0) ? "." : "Q");
                stringBuilder_2.append((board[i][board.length - 1 - j] == 0) ? "." : "Q");
            }
            list_1.add(stringBuilder_1.toString());
            list_2.add(stringBuilder_2.toString());
        }
        this.lol.add(list_1);
        this.lol.add(list_2);
    }

}
