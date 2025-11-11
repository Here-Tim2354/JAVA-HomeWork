package Experiment.Experiment3.task3;

public class Light extends ElectricalDevice{
    public Light(String name) {
        super(name);
    }

    public void powerOn() {
        super.isOn = true;
        System.out.println("电灯["+super.getName()+"]已点亮");
    }

    public void powerOff() {
        super.isOn = false;
        System.out.println("电灯["+super.getName()+"]已关闭");
    }
}
