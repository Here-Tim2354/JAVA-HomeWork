package Practice.Practice6.task1;

import java.util.Random;

public class IntegerAdditionRules {
    private int exerciseNumber;
    private int minScope;
    private int maxScope;


    public IntegerAdditionRules(){
        this.exerciseNumber=10;
        this.maxScope=100;
        this.minScope=0;
    }

    public IntegerAdditionRules(int exerciseNumber, int minScope, int maxScope){
        this.exerciseNumber=exerciseNumber;
        this.maxScope=maxScope;
        this.minScope=minScope;
    }

    public int getExerciseNumber() {
        return exerciseNumber;
    }

    public int getMinScope() {
        return minScope;
    }

    public int getMaxScope() {
        return maxScope;
    }

}
