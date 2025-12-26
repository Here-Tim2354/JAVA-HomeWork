package Experiment.Experiment8.task1;

import java.util.Scanner;

/**
 * 源程序文件分析工具的主程序入口。
 * <p>
 * 提供交互式菜单界面，支持以下功能：
 * <ul>
 *   <li>分析指定目录下的Java源程序文件</li>
 *   <li>查看并打开分析结果文件</li>
 * </ul>
 *
 * @author Tim2354
 */
public class Main {
    /**
     * 程序主入口方法。
     * <p>
     * 提供交互式菜单循环，用户可以选择：
     * <ul>
     *   <li>1 - 分析目录中的源程序文件</li>
     *   <li>2 - 查看分析结果文件</li>
     *   <li>0 - 退出程序</li>
     * </ul>
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        // 初始化类，且将ResultManager的初始化放在分析之后
        SourceAnalyser analyser = new SourceAnalyser();
        ResultManager manager = null;
        String sourcePath = null;
        Scanner sc = new Scanner(System.in);
        // 开始循环菜单
        while (true) {
            System.out.println("---MENU---");
            System.out.println("1.分析目录中源程序文件");
            System.out.println("2.查看分析结果文件");
            System.out.println("0.退出程序");
            System.out.print("请选择：");
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> {
                        // 实现功能1：分析目录中源程序文件
                        System.out.print("请输入要分析的源程序文件目录的绝对路径：");
                        sourcePath = sc.nextLine().trim();
                        String result = analyser.analyse(sourcePath);
                        System.out.println("分析完成，结果如下：");
                        System.out.println(result);

                        manager = new ResultManager(sourcePath);
                        manager.saveResultToFile(sourcePath, result);
                    }
                    case 2 -> {
                        // 实现功能2：查看分析结果文件，并使用系统默认程序打开指定文件
                        if (manager == null) {
                            System.out.println("请先进行源程序文件分析！");
                            break;
                        }
                        manager.printResultFileList();
                        System.out.println("请输入要打开的文件序号：");
                        try {
                            int fileIndex = Integer.parseInt(sc.nextLine().trim());
                            manager.openResultFile(fileIndex);
                        } catch (Exception e) {
                            SourceAnalyser.errPrinter(e);
                            System.err.println("输入序号有误，操作取消。");
                        }
                    }
                    case 0 -> {
                        System.out.println("已退出程序。");
                        return;
                    }
                    default -> System.err.println("输入选项不合法，请重新输入：");

                }
            } catch (NumberFormatException e) {
                System.err.println("输入不合法，请重新输入：");
            }
        }
    }
}