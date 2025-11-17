//Transpose Matrix: Given a matrix, find its transpose (swap rows and columns).

public class Transpose {

    public static int[][] transpose(int[][] arr){
        int[][] newArr = new int[arr[0].length][arr.length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                newArr[j][i] = arr[i][j];
            }
        }
        return newArr;
    }

    public static void main() {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        arr = transpose(arr);
        TwoDArray.printArray(arr);
    }
}
