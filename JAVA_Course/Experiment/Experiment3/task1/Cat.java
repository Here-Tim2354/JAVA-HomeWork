package Experiment.Experiment3.task1;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public String climbTree(){
        return "我会爬树！";
    }
}
