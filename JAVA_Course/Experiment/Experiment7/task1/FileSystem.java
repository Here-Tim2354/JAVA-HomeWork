package Experiment.Experiment7.task1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong; // 用于多线程安全的计数器

public class FileSystem {
    public static void printFileInfo(Path path) throws IOException {
        String fileName = path.getFileName().toString();
        String extension = "无"; // 默认无扩展名
        int dotIndex = fileName.lastIndexOf('.');

        // 确保'.'存在且不是文件名的第一个字符 (例如 .bashrc)
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            extension = "." + fileName.substring(dotIndex + 1);
        }
        String fileType = String.format("文件(%s)", extension.equals("无") ? "无" : extension);

        // --- 2. 获取文件所在位置 (父目录的绝对路径) ---
        Path parent = path.toAbsolutePath().getParent();
        String location = (parent != null) ? parent.toString() : "根目录";

        // --- 3. 获取文件大小 ---
        long size = Files.size(path);

        // --- 4. 格式化修改时间 ---
        Date lastModifiedDate = new Date(Files.getLastModifiedTime(path).toMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = formatter.format(lastModifiedDate);

        // --- 5. 打印所有信息 ---
        System.out.println("\n目标名称: " + fileName);
        System.out.println("------------------------------------");
        System.out.println("目标类型: " + fileType);
        System.out.println("所在位置: " + location);
        System.out.println("文件大小: " + size + " 字节");
        System.out.println("修改时间: " + formattedTime);
        System.out.println("目标属性:");
        System.out.println("  可读: " + Files.isReadable(path));
        System.out.println("  可写: " + Files.isWritable(path));
        System.out.println("  可运行: " + Files.isExecutable(path));
        System.out.println("  隐藏: " + Files.isHidden(path));
        System.out.println("------------------------------------");
    }

    public static void printDirectoryInfo(Path path) throws IOException {
        // 用于存储统计结果的变量
        final AtomicLong totalSize = new AtomicLong(0);
        final AtomicLong fileCount = new AtomicLong(0);
        final AtomicLong dirCount = new AtomicLong(0);

        // 使用 Files.walkFileTree 进行递归遍历
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // 每访问一个文件，就累加其大小和数量
                totalSize.addAndGet(attrs.size());
                fileCount.incrementAndGet();
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                // 每访问完一个目录（包括起始目录），就累加目录数量
                // 我们要排除起始目录本身，所以只在不是起始目录时计数
                if (!path.equals(dir)) {
                    dirCount.incrementAndGet();
                }
                return FileVisitResult.CONTINUE;
            }
        });

        // 格式化修改时间
        Date lastModifiedDate = new Date(Files.getLastModifiedTime(path).toMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = formatter.format(lastModifiedDate);

        // --- 输出结果 ---
        System.out.println("目标名称: " + path.getFileName());
        System.out.println("------------------------------------");
        System.out.println("目标类型: 目录");
        // 使用 getParent() 来获取所在位置
        System.out.println("所在位置: " + (path.getParent() != null ? path.getParent() : path.getRoot()));
        System.out.println("目录大小: " + totalSize.get() + " 字节");
        System.out.println("修改时间: " + formattedTime);
        System.out.println("包含文件: " + fileCount.get() + " 个");
        System.out.println("包含目录: " + dirCount.get() + " 个");
        System.out.println("目标属性:");
        System.out.println("  可写: " + Files.isWritable(path));
        System.out.println("  可读: " + Files.isReadable(path));
        System.out.println("  可运行: " + Files.isExecutable(path));
        System.out.println("  隐藏: " + Files.isHidden(path));
        System.out.println("------------------------------------");
    }
}