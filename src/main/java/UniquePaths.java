/**
 * Created by Qing (Chris) Yuan on Feb/05/2018 3:02 PM
 */
public class UniquePaths {

    public static void main(String[] args) {
        int m = 4, n = 4;
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(m, n));

    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] recursTracker = new int[m][n];
        for (int i = 0; i < m; i++) {
            recursTracker[i][n - 1] = 1;
        }
        recursTracker[0][n - 1] = 1;
        int res = 0;
        for (int i = 1; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                recursTracker[i][j] = recursTracker[i][j + 1] + recursTracker[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            res += recursTracker[m-1][i];
        }
        return res;
    }
}
