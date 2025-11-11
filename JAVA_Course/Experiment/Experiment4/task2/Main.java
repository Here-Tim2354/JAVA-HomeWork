package Experiment.Experiment4.task2;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static void printStudents(String title, Student[] students) {
        System.out.println(title);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    private static void sortAndPrint(List<Student> students, String title, Comparator<Student> comparator) {
        students.sort(comparator);
        System.out.println(title);
        students.forEach(System.out::println);
        System.out.println();
    }

    public static void main(String[] args){
        Student[] students = {
                new Student("20190201", "David", "Software Engineering"),
                new Student("20190202", "Edward", "Software Engineering"),
                new Student("20190101", "Zed", "Computer Science"),
                new Student("20190102", "Bob", "Computer Science"),
                new Student("20190103", "Charlie", "Computer Science"),
                new Student("20190301", "Fred", "Data Science"),
        };

        printStudents("原始学生列表：", students);
        
        List<Student> sortedStudent = new ArrayList<>(java.util.Arrays.asList(students));
        
        sortAndPrint(sortedStudent, "按照ID排序：", Comparator.comparing(Student::getId));
        sortAndPrint(sortedStudent, "按照姓名排序：", Comparator.comparing(Student::getName));
        sortAndPrint(sortedStudent, "按照专业排序：", Comparator.comparing(Student::getMajor));
    }

}
