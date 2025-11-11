package Experiment.Experiment3.task2;

import java.time.LocalDate;

public class Pet {
    private String name;
    private LocalDate birthday;

    public Pet(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String shout(){
        return "名字"+this.name+"，生日"+this.birthday.toString();
    }
}
