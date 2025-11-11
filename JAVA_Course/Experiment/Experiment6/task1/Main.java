package Experiment.Experiment6.task1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        ClosestFarthestPoints cfp = new ClosestFarthestPoints();
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("请输入你要输入的坐标个数：");
            int n;
            try {
                n = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("坐标个数必须是整数");
            }
            
            // 检查坐标个数是否为正整数
            if (n <= 0) {
                throw new IllegalArgumentException("坐标个数必须是正整数");
            }

            for(int i=0;i<n;i++){
                System.out.printf("请输入第%d个点的坐标（格式：x y）：", i + 1);
                
                try {
                    double x = scanner.nextDouble();
                    double y = scanner.nextDouble();
                    cfp.addPoint(x, y);
                } catch (InputMismatchException e) {
                    throw new IllegalArgumentException("坐标输入格式错误，请输入有效的数字");
                }
            }

            System.out.println("实际上的点的个数为："+cfp.getNumberOfPoints());
            cfp.printPoints();

            System.out.println("距离最近的点为："+cfp.getClosestPoints());
            System.out.println("距离最远的点为："+cfp.getFarthestPoints());
            
        } catch (InputMismatchException e) {
            System.err.println("输入格式错误：请输入有效的整数作为坐标个数");
        } catch (IllegalArgumentException e) {
            System.err.println("输入错误：" + e.getMessage());
        } catch (Exception e) {
            System.err.println("发生未知错误：" + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
