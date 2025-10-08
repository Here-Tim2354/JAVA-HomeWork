import java.util.ArrayList;
import java.util.List;

public class ExamScoreAnalysis {
    private final int classnumber;
    private final ArrayList<ArrayList<Integer>> scoreMatrix;
    public  final ArrayList<ArrayList<Double>> outputMatrix;


    public ExamScoreAnalysis(int classnumber){
        this.classnumber=classnumber;
        scoreMatrix=new ArrayList<>();
        outputMatrix=new ArrayList<>();
    }

    public void addScore(String inputLine){
        ArrayList<Integer> numbers=new ArrayList<>();
        String[] strNumbers=inputLine.split(" ");
        for(String string:strNumbers){
            numbers.add(Integer.parseInt(string));
        }
        scoreMatrix.add(numbers);
    }

    public void scoreCalculator(){
        for(ArrayList<Integer> aline:scoreMatrix){
            if(aline.getFirst()<1) continue;

            List<Integer> scores=aline.subList(1,aline.size());
            double sum=0;

            for(int score:scores){
                sum+=score;
            }

            ArrayList<Integer> output=new ArrayList<>();

        }
    }
}
