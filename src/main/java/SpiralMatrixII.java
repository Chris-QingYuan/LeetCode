/**
 * Created by Qing (Chris) Yuan on Feb/04/2018 11:06 PM
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int n = 4;
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        spiralMatrixII.generateMatrix(n);
    }

    public int[][] generateMatrix(int n) {

        if (n == 0) return new int[0][0];
        int[][] res = new int[n][n];

        int elNum = n * n,
                i = 0,
                j = 0,
                edge = 0;

        for (int cur = 1; cur <= elNum; cur++) {
            res[i][j] = cur;
            if (edge % 4 == 0) {
                if (j == n - 1 || res[i][j + 1] != 0) {
                    edge++;
                    i++;
                } else j++;
            }else if (edge % 4 == 1) {
                if (i == n - 1 || res[i + 1][j] != 0) {
                    edge++;
                    j--;
                } else i++;
            }else if (edge % 4 == 2) {
                if (j == 0 || res[i][j - 1] != 0) {
                    edge++;
                    i--;
                } else j--;
            }else if (edge % 4 == 3) {
                if (i == 0 || res[i - 1][j] != 0) {
                    edge++;
                    j++;
                } else i--;
            }
        }

        return res;
    }
}
