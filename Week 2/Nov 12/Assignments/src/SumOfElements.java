// Sum of Elements: Calculate the sum of all elements in a 2D array.

public class SumOfElements {
    private static int getSum(int[][] arr){
        int sum = 0;
        for (int[] subArr : arr)
            for (int num : subArr)
                sum += num;
        return sum;
    }

    static void main() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Sum is: " + getSum(arr));
    }
}
