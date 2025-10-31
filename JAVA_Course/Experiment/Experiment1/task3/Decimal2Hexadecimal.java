package Experiment.Experiment1.task3;

import java.util.Scanner;

public class Decimal2Hexadecimal {
    private final int decimal;
    private String hexadecimal;

    public Decimal2Hexadecimal(int number){
        if (number < 0) {
            throw new IllegalArgumentException("输入不能为负数!");
        }
        decimal = number;
    }

    public void processor(){
        try {
            hexadecimal = String.format("%X", decimal);
            System.out.println("输出结果为：" + hexadecimal);
        } catch (Exception e){
            System.out.println("转换错误: " + e.getMessage());
            hexadecimal = "0";
        }
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("请输入十进制数，且不能为负数：");
            Decimal2Hexadecimal d2hClass = new Decimal2Hexadecimal(sc.nextInt());
            d2hClass.processor();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
