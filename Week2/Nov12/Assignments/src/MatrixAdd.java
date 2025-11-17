//Matrix Addition: Add two matrices of the same dimensions.
public class MatrixAdd {
    public static int[][] addMatrices(int[][] m1, int[][] m2){
        int[][] newArr = new int[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                newArr[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return newArr;
    }
    static void main() {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] newArr = addMatrices(arr, arr);
        TwoDArray.printArray(newArr);
    }
}
