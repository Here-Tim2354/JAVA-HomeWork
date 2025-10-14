import java.util.Scanner;
import java.lang.Math;
public class eCalculator {
    private final int number;
    private double result;

    public eCalculator(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("项数必须为非负数");
        }
        this.number = number;
    }

    public void calculator() {
        result = 1.0;
        double factorial = 1.0;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
            result += 1.0 / factorial;
        }
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.format("e ≈ %.15f (使用%d项计算)", result, number);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        eCalculator calc = new eCalculator(sc.nextInt());
        calc.calculator();
        System.out.println(calc);
        System.out.println("精确值: " + Math.E);
    }
}
