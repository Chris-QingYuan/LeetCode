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

        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        solveRow(0, board);
        return lol;
    }

    private void solveRow(int curRow, char[][] board) {
        if (curRow == board.length) {
            appendResult(board);
            return;
        }
        int limit = board.length;
        if (curRow == 0) limit = (limit + 1) / 2;

        for (int i = 0; i < limit; i++) {
            if (validMove(board, curRow, i)) {
                board[curRow][i] = 'Q';
                solveRow(curRow + 1, board);
                board[curRow][i] = '.';
            } else continue;
        }
    }

    private boolean validMove(char[][] board, int rowIndex, int colIndex) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((colIndex == j || Math.abs(rowIndex - i) == Math.abs(colIndex - j)) && board[i][j] == 'Q')
                    return false;
            }
        }
        return true;
    }

    private void appendResult(char[][] board) {
        List<String> list_1 = new ArrayList<>(board.length);
        List<String> list_2 = new ArrayList<>(board.length);
        StringBuilder stringBuilder_1,
                stringBuilder_2 = null;
        boolean notDup = !(board.length % 2 == 1 && board[0][board.length / 2] == 'Q');
        for (int i = 0; i < board.length; i++) {
            stringBuilder_1 = new StringBuilder();
            if(notDup) stringBuilder_2 = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                stringBuilder_1.append(board[i][j]);
                if(notDup) stringBuilder_2.append(board[i][board.length - 1 - j]);
            }
            list_1.add(stringBuilder_1.toString());
            if(notDup) list_2.add(stringBuilder_2.toString());
        }
        this.lol.add(list_1);
        if(notDup) this.lol.add(list_2);
    }

}
