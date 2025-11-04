package Experiment.Experiment3.task1;

public class Dog extends Pet {
    public Dog(String name, java.time.LocalDate birthDate) {
        super(name, birthDate);
    }

    public String guard(){
        return "我能警戒！";
    }
}
