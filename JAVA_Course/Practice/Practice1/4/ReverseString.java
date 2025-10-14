import java.util.Scanner;

public class ReverseString {
    private final String originalString;

    public ReverseString(String inputString) {
        this.originalString = inputString;
    }

    public boolean isPalindrome() {
        if (originalString == null || originalString.isEmpty()) {
            return false;
        }

        StringBuilder stringBuffer = new StringBuilder(originalString);
        stringBuffer.reverse();
        String reversedString = stringBuffer.toString();
        return reversedString.equals(originalString);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("请输入一个整数：");
                String input = scanner.nextLine();

                try {
                    int number = Integer.parseInt(input);

                    if (number < 0) {
                        System.out.println("输入不能为负数，请重新输入。");
                        continue;
                    }

                    ReverseString palindromeChecker = new ReverseString(Integer.toString(number));

                    if (palindromeChecker.isPalindrome()) {
                        System.out.println(number + " 是回文整数");
                    } else {
                        System.out.println(number + " 不是回文整数");
                    }

                    break;

                } catch (NumberFormatException e) {
                    System.out.println("输入格式错误，请输入一个有效的整数。");
                }

            } catch (Exception e) {
                System.out.println("发生错误，请重新输入。");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}

