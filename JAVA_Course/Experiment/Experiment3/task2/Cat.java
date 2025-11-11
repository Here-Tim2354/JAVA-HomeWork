package Experiment.Experiment3.task2;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String name,LocalDate birthday){
        super(name,birthday);
    }

    public String climbTree(){
        return "我会爬树！";
    }

    @Override
    public String shout(){
        return "猫，名字："+super.getName()+"，生日："+super.getBirthday().toString();
    }
}
