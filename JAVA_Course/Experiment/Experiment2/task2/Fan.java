package Experiment.Experiment2.task2;

import java.util.Scanner;

public class Fan {
    public final static int SLOW = 1;
    public final static int MEDIUM = 2;
    public final static int FAST = 3;
    private int speed;
    private boolean on;
    private String brand;

    public Fan(String brand) {
        this.on = false;
        this.speed = SLOW;
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        String onStatus = this.on ? "开" : "关";
        String speedDescription = "慢";
        if (!this.on) {
            speedDescription = "已关闭";
        } else {
            switch (this.speed) {
                case 1:
                    speedDescription = "慢";
                    break;
                case 2:
                    speedDescription = "中";
                    break;
                case 3:
                    speedDescription = "快";
                    break;
            }
        }
        return String.format("品牌：%s\n运行：%s\n速度：%s\n", this.brand, onStatus, speedDescription);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入品牌：");
        String brand = sc.next();

        Fan fan = new Fan(brand);
        System.out.println(fan);

        fan.setOn(true);
        System.out.println(fan);

        fan.setSpeed(3);
        System.out.println(fan);
    }
}
