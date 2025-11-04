package Practice.Practice6.task1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Practice> practiceList=new ArrayList<>();

        IntegerAdditionRules integerAdditionRules=new IntegerAdditionRules(5,10,50);

        for(int i=0;i<integerAdditionRules.getExerciseNumber();i++){
            practiceList.add(new Practice(integerAdditionRules));
        }

        System.out.println("本次加法练习一共"+integerAdditionRules.getExerciseNumber()+"道题目：");
        Scanner scanner=new Scanner(System.in);
        for(Practice checkPractice:practiceList){
            checkPractice.printQuestion();
            int answer=scanner.nextInt();
            if(answer==checkPractice.getResult()) {
                System.out.println("回答正确！");
            }else{
                System.out.println("回答错误！"+checkPractice.printAnswer());
            }
        }
        System.out.println("本次练习已结束！");
    }
}
