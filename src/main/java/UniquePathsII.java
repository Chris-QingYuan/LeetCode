/**
 * Created by Qing (Chris) Yuan on Feb/05/2018 3:02 PM
 */
public class UniquePathsII {

    public static void main(String[] args) {
        int[][] obstacleGrid = {};
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid));

    }

    private int res = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length,
                n = obstacleGrid[0].length,
                x = 0,
                y = 0;
        moveHelper(x, y, obstacleGrid);
        return this.res;
    }

    private void moveHelper(int x, int y, int[][] obstacleGrid) {
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            this.res++;
            return;
        }
        if (x < obstacleGrid.length - 1 && obstacleGrid[x + 1][y] != 1) {
            moveHelper(x + 1, y, obstacleGrid);
        }
        if (y < obstacleGrid[0].length - 1 && obstacleGrid[x][y + 1] != 1) {
            moveHelper(x, y + 1, obstacleGrid);
        }
    }

}
