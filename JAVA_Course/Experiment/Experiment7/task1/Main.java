package Experiment.Experiment7.task1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("请输入路径或者文件名：");
        Scanner scanner = new Scanner(System.in);
        String inputPath = scanner.nextLine();
        Path path = Path.of(inputPath);

        try {
            if (Files.isDirectory(path)) {
                FileSystem.printDirectoryInfo(path);
            } else if (Files.isRegularFile(path)) {
                FileSystem.printFileInfo(path);
            } else {
                System.out.println("错误："+inputPath+" 提供的路径既不是文件也不是目录。");
            }
        } catch (Exception e) {
            System.out.println("发生错误: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
