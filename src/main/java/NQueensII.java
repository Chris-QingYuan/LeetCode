import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Qing (Chris) Yuan on Feb/03/2018 3:30 PM
 */
public class NQueensII {

    public static void main(String[] args) {
        NQueensII nQueens = new NQueensII();
        int n = 4;
        nQueens.solveNQueens(n);

    }

    private List<List<String>> lol = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return lol;

        boolean[][] board = new boolean[n][n];

        solveRow(0, board);
        return lol;
    }

    private void solveRow(int curRow, boolean[][] board) {
        if (curRow == board.length) {
            appendResult(board);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (validMove(board, curRow, i)) {
                board[curRow][i] = true;
                solveRow(curRow + 1, board);
                board[curRow][i] = false;
            } else continue;
        }
    }

    private boolean validMove(boolean[][] board, int rowIndex, int colIndex) {
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((colIndex == j || Math.abs(rowIndex - i) == Math.abs(colIndex - j)) && board[i][j] == true)
                    return false;
            }
        }
        return true;
    }

    private void appendResult(boolean[][] board) {
        List<String> list = new ArrayList<>(board.length);
        StringBuilder stringBuilder = null;
        for (int i = 0; i < board.length; i++) {
            stringBuilder = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                stringBuilder.append((board[i][j] == false) ? "." : "Q");
            }
            list.add(stringBuilder.toString());
        }
        this.lol.add(list);
    }

}
