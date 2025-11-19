package com.revature.lambda;

public class LambdaDemo {
    public static void main(String[] args) {
        Calculator c = (int x, int y) -> {return (x + y);};
        System.out.println(c.operation(4, 5));

        printResult(10, 5, (x, y) -> x + y);
        printResult(23, 13, (a, b) -> a - b);
    }
    public static void printResult(int x, int y, Calculator c){
        int result = c.operation(x, y);
        System.out.println(result);
    }
}
