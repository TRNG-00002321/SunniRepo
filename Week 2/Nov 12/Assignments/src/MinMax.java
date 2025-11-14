//Find Maximum/Minimum: Find the maximum or minimum element within a 2D array.

public class MinMax {
    public static int[] getMinMax(int[][] arr) {
        int[] minMax = new int[2];
        minMax[0] = arr[0][0];
        minMax[1] = arr[0][0];
        for (int[] subArr : arr) {
            for (int num : subArr) {
                if(num < minMax[0])
                        minMax[0] = num;
                if(num > minMax[1])
                        minMax[1] = num;
            }
        }
        return minMax;
    }

    public static void main() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] minMax = getMinMax(arr);
        System.out.println("Min: " + minMax[0]);
        System.out.println("Max: " + minMax[1]);
    }
}
