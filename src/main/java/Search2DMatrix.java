/**
 * Created by Qing (Chris) Yuan on Feb/10/2018 11:18 PM
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int target = 1;
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(matrix, target));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int left = 0, right = m * n - 1, mid;

        while(left < right){
            mid = (left + right)/2;
            if(matrix[mid/n][mid%n] == target){
                return true;
            }else if(matrix[mid/n][mid%n] > target){
                right = mid;
            }else if(matrix[mid/n][mid%n] < target){
                left = mid + 1;
            }
        }
        if(matrix[left/n][left%n] == target) return true;
        return false;
    }
/*
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int top = 0, bot = m - 1, left = 0, right = n - 1, mid;

        while (top < bot) {
            mid = (top + bot) / 2;
            if(matrix[mid][n - 1] == target){
                return true;
            }else if(matrix[mid][n - 1] > target){
                bot = mid;
            }else if(matrix[mid][n - 1] < target){
                top = mid + 1;
            }
        }

        while(left < right){
            mid = (left + right)/2;
            if(matrix[top][mid] == target){
                return true;
            }else if(matrix[top][mid] > target){
                right = mid;
            }else if(matrix[top][mid] < target){
                left = mid + 1;
            }
        }
        if(matrix[top][left] == target) return true;
        return false;
    }*/
}
