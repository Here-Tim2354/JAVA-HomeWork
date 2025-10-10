import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamScoreAnalysis {
    private final ArrayList<ArrayList<Integer>> scoreMatrix;
    public  final ArrayList<ArrayList<Double>> outputMatrix;

    public ExamScoreAnalysis(){
        scoreMatrix=new ArrayList<>();
        outputMatrix=new ArrayList<>();
    }

    public void addScore(String inputLine){
        try{
            ArrayList<Integer> numbers=new ArrayList<>();
            String[] strNumbers=inputLine.split(" ");
            for(String string:strNumbers){
                numbers.add(Integer.parseInt(string));
            }
            scoreMatrix.add(numbers);
        }catch(NumberFormatException e){
            System.out.println("输入错误，请检查数字格式");
            return;
        }

    }

    public void scoreCalculator(){
        for(ArrayList<Integer> studentScores:scoreMatrix){
            if(studentScores.getFirst()<1) continue;

            List<Integer> scores=studentScores.subList(1,studentScores.size());
            double sum=0;

            for(int score:scores){
                sum+=score;
            }

            ArrayList<Double> output=new ArrayList<>();
            output.add(sum/scores.size());

            int maxScore = scores.stream().mapToInt(Integer::intValue).max().orElse(0);
            int minScore = scores.stream().mapToInt(Integer::intValue).min().orElse(0);

            output.add((double) maxScore);
            output.add((double) minScore);

            outputMatrix.add(output);
        }
    }

    public static void main(String[] args){
        ExamScoreAnalysis esaClass=new ExamScoreAnalysis();
        Scanner sc=new Scanner(System.in);
        int iterations=Integer.parseInt(sc.nextLine());

        for(int i=0;i<iterations;i++){
            esaClass.addScore(sc.nextLine());
        }
        esaClass.scoreCalculator();

        for(ArrayList<Double>output:esaClass.outputMatrix){
            System.out.println(output);
        }
    }
}
