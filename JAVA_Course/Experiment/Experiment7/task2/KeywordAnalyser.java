package Experiment.Experiment7.task2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;


@SuppressWarnings("ALL")
public class KeywordAnalyser {
    private String testFileName;
    private Path testFilePath;
    private Path keywordFilePath;
    private Set<String> keywords;
    private Map<String, Integer> keywordCountMap;

    public KeywordAnalyser(String keywordsFileName, String testFileName) throws IOException, InvalidPathException {
        this.testFileName = testFileName;
        this.testFilePath = Paths.get(testFileName);
        this.keywordFilePath = Paths.get(keywordsFileName);
        if (Files.notExists(this.keywordFilePath)) {
            throw new FileNotFoundException("你输入的关键字文件:" + keywordsFileName + "不存在");
        }

        this.keywords = new HashSet<>(Files.readAllLines(this.keywordFilePath));
        this.keywordCountMap = new TreeMap<>();
    }

    private boolean isJavaFile() {
        /*
        判断文件是否为Java源文件,通过检查文件扩展名是否为".java"
         */
        return testFileName.toLowerCase().endsWith(".java");
    }

    public void CodeAnalyser() throws IOException {
        /*
        分析测试文件中的Java关键词出现次数
         */
        if (Files.notExists(this.testFilePath)) {
            throw new FileNotFoundException("你输入的文件" + testFileName + "不存在");
        }
        if (Files.isDirectory(this.testFilePath)) {
            throw new IllegalArgumentException("你输入的文件名是一个路径，请重新输入文件路径");
        }
        if (!isJavaFile()) {
            throw new IllegalArgumentException("你输入的文件：" + testFileName + " 不是一个Java源文件，请重新输入Java源文件路径");
        }
        if (!Files.isRegularFile(testFilePath)) {
            throw new IOException("你输入的文件不是一个普通文件，请重新输入普通文件路径");
        }

        String content = Files.readString(testFilePath);
        // 使用正则表达式分割内容为单词，过滤掉空字符串和单字符单词,并收集到wordList中
        ArrayList<String> wordList = Arrays.stream(content.split("\\W+"))
                .filter(s -> !s.isBlank())
                .filter(s -> s.length() > 1)
                .collect(Collectors.toCollection(ArrayList::new));
        // 统计关键词出现的次数,使用TreeMap排序
        for (String word : wordList) {
            if (keywords.contains(word)) {
                keywordCountMap.merge(word, 1, Integer::sum);
            }
        }
        // 输出结果到文件
        resultOutput();
    }

    public void resultOutput() {
        /*
        将关键词统计结果写入输出文件
         */
        // 构造输出文件名称且去掉原来的.java后缀
        String fileName = testFilePath.getFileName().toString();
        String baseName = fileName.substring(0, fileName.lastIndexOf("."));
        String outputFileName = "Keywords-" + baseName + ".txt";
        Path parentDir = testFilePath.getParent();
        Path outputFilePath = parentDir != null ? parentDir.resolve(outputFileName) : Paths.get(outputFileName);

        // 使用try-with-resources确保文件正确关闭，并且使用BufferedWriter提高写入效率
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath.toFile()))) {
            for (Map.Entry<String, Integer> entry : keywordCountMap.entrySet()) {
                String line = entry.getKey() + " " + entry.getValue();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("关键词统计结果已保存至: " + outputFilePath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("写入文件时发生错误: " + e.getMessage());
        }
    }

    public void printTopRankingKeywords(int checkTopN) {
        /*
        打印出现次数排名前N的关键词
         */
        System.out.println("关键词出现次数排名前 " + checkTopN + " 的关键词:");
        // 使用流对Map进行排序并限制输出数量
        keywordCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(checkTopN)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}