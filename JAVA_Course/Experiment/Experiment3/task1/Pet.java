package Experiment.Experiment3.task1;

import java.time.LocalDate;

public class Pet {
    private String name;
    private LocalDate birthDate;

    public Pet(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String shout(){
        return "名字"+this.name+"，生日"+this.birthDate.toString();
    }
}
