package Experiment.Experiment8.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * 源程序文件分析器。
 * <p>
 * 用于分析指定目录下的Java源文件，统计文件数量、总行数、空行数和字节数。
 * 支持递归遍历子目录，并以树形结构展示分析结果。
 *
 * @author Tim2354
 */
public class SourceAnalyser {
    
    /**
     * 打印异常信息到标准错误输出。
     *
     * @param e 要打印的异常对象
     */
    public static void errPrinter(Exception e) {
        System.err.println("发生异常：" + e.getClass().getName());
        System.err.println("异常信息：" + e.getMessage());
    }

    /**
     * 分析指定目录下的Java源程序文件。
     * <p>
     * 递归遍历目录及其子目录，统计所有.java文件的详细信息，
     * 包括文件数量、总行数、空行数和字节数。
     *
     * @param sourcePath 要分析的源程序目录的绝对路径
     * @return 分析结果的格式化字符串，包含文件详情和统计汇总
     */
    public String analyse(String sourcePath) {
        File rootDir = new File(sourcePath);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            return "错误：指定路径" + sourcePath + "不存在或不是目录";
        }

        StringBuilder sb = new StringBuilder();
        String absolutePath = rootDir.getAbsolutePath();

        sb.append(absolutePath).append(" Result:\n\n");
        sb.append(" Files detail:\n");

        AnalysisStats totalStats = processDirectory(rootDir, 1, sb);

        sb.append("Total:\n");
        sb.append("    ").append(totalStats.totalFiles).append(" Java Files\n");
        sb.append("    ").append(totalStats.totalLines).append(" Lines in Files\n");
        sb.append("    ").append(totalStats.totalBlankLines).append(" Blank Lines\n");
        sb.append("    ").append(totalStats.totalBytes).append(" Bytes\n");

        return sb.toString();
    }

    /**
     * 递归处理目录，收集Java文件的统计信息。
     * <p>
     * 按照目录优先、文件在后的顺序排序，并以缩进格式输出文件树结构。
     *
     * @param currentDir 当前处理的目录
     * @param depth 当前目录的深度（用于缩进）
     * @param sb 用于构建结果字符串的StringBuilder
     * @return 当前目录及其子目录的统计信息汇总
     */
    private AnalysisStats processDirectory(File currentDir, int depth, StringBuilder sb) {
        File[] children = currentDir.listFiles();
        if (children == null) return new AnalysisStats();

        Arrays.sort(children, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) return -1;
            if (!f1.isDirectory() && f2.isDirectory()) return 1;
            return f1.getName().compareToIgnoreCase(f2.getName());
        });

        AnalysisStats currentTotal = new AnalysisStats();
        String indent = "  ".repeat(depth);

        for (File child : children) {
            if (child.isDirectory()) {
                sb.append(indent).append("+").append(child.getName()).append("\n");

                AnalysisStats subStats = processDirectory(child, depth + 1, sb);
                currentTotal = currentTotal.add(subStats);
            } else if (child.getName().endsWith(".java")) {
                AnalysisStats fileStats = analyzeSingleFile(child);

                sb.append(indent).append("-")
                        .append(String.format("%-40s", child.getName()))
                        .append(" Total: ").append(String.format("%5d", fileStats.totalLines()))
                        .append(",Blank: ").append(String.format("%5d", fileStats.totalBlankLines()))
                        .append(",  ").append(String.format("%10d", fileStats.totalBytes()))
                        .append(" Bytes\n");

                currentTotal = currentTotal.add(fileStats);
            }
        }
        return currentTotal;
    }

    /**
     * 分析单个Java文件的统计信息。
     * <p>
     * 统计文件的总行数、空行数和字节数。
     *
     * @param child 要分析的Java文件
     * @return 包含该文件统计信息的AnalysisStats对象
     */
    private AnalysisStats analyzeSingleFile(File child) {
        long totalLines = 0;
        long blankLines = 0;
        long totalBytes = child.length();

        try (BufferedReader br = new BufferedReader(new FileReader(child))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
                if (line.isBlank()) {
                    blankLines++;
                }
            }
        } catch (Exception e) {
            errPrinter(e);
        }

        return new AnalysisStats(1, totalLines, blankLines, totalBytes);
    }

    /**
     * 分析统计记录类。
     * <p>
     * 用于存储和累加Java源文件的统计信息，包括文件数量、总行数、空行数和字节数。
     */
    private record AnalysisStats(
            long totalFiles,
            long totalLines,
            long totalBlankLines,
            long totalBytes
    ) {
        /**
         * 创建一个空的统计记录（所有值为0）。
         */
        public AnalysisStats() {
            this(0, 0, 0, 0);
        }

        /**
         * 将当前统计记录与另一个统计记录相加。
         *
         * @param other 要相加的另一个统计记录
         * @return 相加后的新统计记录
         */
        public AnalysisStats add(AnalysisStats other) {
            return new AnalysisStats(
                    this.totalFiles + other.totalFiles,
                    this.totalLines + other.totalLines,
                    this.totalBlankLines + other.totalBlankLines,
                    this.totalBytes + other.totalBytes
            );
        }
    }


}
