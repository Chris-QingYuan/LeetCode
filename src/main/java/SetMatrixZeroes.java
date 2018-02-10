/**
 * Created by Qing (Chris) Yuan on Feb/10/2018 5:58 PM
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0) return;

        int m = matrix.length,
                n = matrix[0].length;

        int[] rowFlag = new int[m],
                colFlag = new int[n];

        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(matrix[i][j] == 0){
                    rowFlag[i] = 1;
                    colFlag[j] = 1;
                }
            }
        }

        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(rowFlag[i] == 1 || colFlag[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
