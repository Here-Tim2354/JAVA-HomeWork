package Experiment.Experiment7.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("输入关键字文件的完整路径：");
            String keywordsFile = sc.nextLine();
            System.out.println("输入测试文件的完整路径：");
            String testFile = sc.nextLine();

            KeywordAnalyser analyser = new KeywordAnalyser(keywordsFile, testFile);
            analyser.CodeAnalyser();

            int TopN = 0;
            while (true) {
                System.out.println("需要查看排名前几位（范围1-51）的关键字？");
                if (sc.hasNextInt()) {
                    TopN = sc.nextInt();
                    if (TopN >= 1 && TopN <= 51) {
                        analyser.printTopRankingKeywords(TopN);
                        break;
                    } else {
                        System.out.println("输入数字不在范围内,请重新输入:");
                    }
                } else {
                    System.out.println("输入不是一个数字,请重新输入:");
                    sc.next(); // 清除错误输入
                }

            }
        } catch (Exception e) {
            System.err.println("[程序运行出错]");
            System.err.println("错误类型:"+e.getClass().getSimpleName());
            System.err.println("错误信息:"+e.getMessage());
        }
    }
}
