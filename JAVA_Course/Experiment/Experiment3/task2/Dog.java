package Experiment.Experiment3.task2;

import java.time.LocalDate;

public class Dog extends Pet{
    public Dog(String name,LocalDate birthday){
        super(name,birthday);
    }

    public String guard(){
        return "我能警戒！";
    }

    @Override
    public String shout(){
        return "狗，名字："+super.getName()+"，生日："+super.getBirthday().toString();
    }
}
