public class MathOperations {
    private static int add(int x, int y) {
        return x + y;
    }

    private static int subtract(int x, int y){
        return x - y;
    }
    private static int multiply(int x, int y){
        return x * y;
    }
    private static int divide(int x, int y){
        return x / y;
    }

    static void main() {
        int x = 10, y = 5;
        System.out.println("Add: " + add(x, y));
        System.out.println("Subtract: " + subtract(x, y));
        System.out.println("Multiply: " + multiply(x, y));
        System.out.println("Divide: " + divide(x, y));
    }

}
