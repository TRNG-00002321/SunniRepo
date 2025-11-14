// Row/Column Sums: Calculate the sum of elements
// for each individual row and each individual column in a 2D array.
public class RowColumn {
    public static int[] sumRows(int[][] arr){
        int[] rowSums = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                rowSums[i] += arr[i][j];
        }
        return rowSums;
    }

    public static int[] sumCols(int[][] arr){
        int[] colSums = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                colSums[i] += arr[j][i];
        }
        return colSums;
    }
    static void main() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.print("Row sums: ");
        for(int num : sumRows(arr)){
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.print("Column sums: ");
        for(int num : sumCols(arr)){
            System.out.print(num + " ");
        }
    }

}
