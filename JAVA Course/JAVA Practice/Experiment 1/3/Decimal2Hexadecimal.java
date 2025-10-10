import  java.util.Scanner;

public class Decimal2Hexadecimal {
    final int decimal;
    String hexadecimal;

    public Decimal2Hexadecimal(int number){
        decimal = number;
    }

    public void processor(){
        try{
            if(decimal<0){
                System.out.println("输入不能为负数!");
                return;
            }
            hexadecimal = String.format("%X", decimal);
            System.out.println("输出结果为："+hexadecimal);
        }catch (Exception e){
            System.out.println("转换错误");
            hexadecimal = "0";
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入十进制数，且不能为负数：");
        Decimal2Hexadecimal d2hClass=new Decimal2Hexadecimal(sc.nextInt());
        d2hClass.processor();
    }
}
