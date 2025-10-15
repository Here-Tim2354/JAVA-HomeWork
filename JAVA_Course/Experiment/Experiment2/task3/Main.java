package Experiment.Experiment2.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入正确的表达式:");
        String expressionString = scanner.nextLine();

        ArithmeticExpression expression = new ArithmeticExpression(expressionString);
        int result = expression.getResult();

        System.out.println("结果为: " + result);
        scanner.close();
    }
}

