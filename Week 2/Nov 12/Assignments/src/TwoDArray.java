// Print a 2D Array: Write a program to initialize and print
// the elements of a given 2D integer array (matrix).

public class TwoDArray {
    public static void printArray(int[][] arr) {
        for (int[] subArr : arr) {
            for (int num : subArr)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    static void main() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printArray(arr);
    }
}
