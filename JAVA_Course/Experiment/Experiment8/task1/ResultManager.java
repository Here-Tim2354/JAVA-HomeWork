package Experiment.Experiment8.task1;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 分析结果管理器。
 * <p>
 * 负责管理源程序分析结果的存储、列表显示和打开操作。
 * 结果文件保存在源目录同级的results子目录中。
 *
 * @author Tim2354
 */
public class ResultManager {
    /** 结果文件存储目录的路径 */
    private final Path resultFilePath;
    /** 结果文件名列表 */
    private final List<String> resultFileList;

    /**
     * 构造结果管理器。
     * <p>
     * 在源目录同级创建results子目录（如果不存在）。
     *
     * @param sourceFilePath 源程序目录的路径
     */
    public ResultManager(String sourceFilePath) {
        this.resultFileList = new ArrayList<>();
        this.resultFilePath = Paths.get(sourceFilePath).toAbsolutePath().resolveSibling("results");
        try {
            if (Files.notExists(resultFilePath)) {
                Files.createDirectories(resultFilePath);
                System.out.println("已创建结果目录：" + resultFilePath);
            } else {
                System.out.println("结果目录已存在：" + resultFilePath);
            }
        } catch (Exception e) {
            SourceAnalyser.errPrinter(e);
            System.err.println("创建文件时发生了异常");
        }
    }

    /**
     * 将分析结果保存到文件。
     * <p>
     * 文件名格式为：源目录名_result.txt
     *
     * @param sourcePath 源程序目录路径
     * @param resultContent 分析结果内容
     * @throws RuntimeException 当写入文件失败时抛出
     */
    public void saveResultToFile(String sourcePath, String resultContent) {
        String fileName = Paths.get(sourcePath).getFileName().toString();
        String baseName = fileName.contains(".") ? fileName.substring(0, fileName.lastIndexOf(".")) : fileName;
        Path outputFilePath = resultFilePath.resolve(baseName + "_result.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {
            writer.write(resultContent);
            printResultPath();
        } catch (Exception e) {
            throw new RuntimeException("写入结果文件失败：" + resultFilePath, e);
        }
        updateResultFileList();
    }

    /**
     * 更新结果文件列表。
     * <p>
     * 扫描results目录，获取所有结果文件的文件名。
     */
    public void updateResultFileList() {
        try (var stream = Files.list(resultFilePath)) {
            this.resultFileList.clear();
            stream.filter(Files::isRegularFile)
                    .forEach(path -> resultFileList.add(path.getFileName().toString()));
        } catch (Exception e) {
            SourceAnalyser.errPrinter(e);
            System.err.println("获取结果文件列表时发生异常");
        }
    }

    /**
     * 打印结果文件的存储路径。
     */
    public void printResultPath() {
        System.out.println("分析结果文件存放路径：" + resultFilePath.toAbsolutePath());
    }

    /**
     * 打印结果文件列表。
     * <p>
     * 显示所有结果文件的序号和文件名。
     */
    public void printResultFileList() {
        System.out.println("---文件结果列表---");
        if (this.resultFileList.isEmpty()) {
            System.out.println("结果目录中没有文件。");
            return;
        }
        int index = 0;
        for (String s : this.resultFileList) {
            System.out.println((index++) + " " + s);
        }
    }

    /**
     * 使用系统默认程序打开指定的结果文件。
     *
     * @param index 结果文件在列表中的索引
     */
    public void openResultFile(int index) {
        if (index < 0 || index >= this.resultFileList.size()) {
            System.err.println("索引超出范围，请输入有效的序列号。");
            return;
        }
        try {
            String fileName = this.resultFileList.get(index);
            Path targetFilePath = resultFilePath.resolve(fileName);
            File file = targetFilePath.toFile();

            if (!Desktop.isDesktopSupported()) {
                System.err.println("当前系统不支持打开文件操作。");
                return;
            }
            Desktop.getDesktop().open(file);
            System.out.println("正在打开文件..." + fileName);
        } catch (IOException e) {
            SourceAnalyser.errPrinter(e);
            System.err.println("打开文件时发生异常。");
        } catch (Exception e) {
            SourceAnalyser.errPrinter(e);
            System.err.println("发生未知异常，无法打开文件。");
        }
    }
}
