public class Factorial {
    public static int recursiveFactorial(int n) {
        if (n == 1)
            return 1;
        return n * recursiveFactorial(n - 1);
    }

    public static int iterativeFactorial(int n) {
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        System.out.println("Recursive Result = " + recursiveFactorial(n));
        System.out.println("Iterative Result = " + iterativeFactorial(n));
    }
}
