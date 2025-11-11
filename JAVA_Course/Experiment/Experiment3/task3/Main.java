package Experiment.Experiment3.task3;

public class Main {
    public static void main(String[] args) {
        Light light = new Light("客厅灯");
        Fan fan = new Fan("客厅风扇");
        System.out.println(light.getStatus());
        System.out.println(fan.getStatus());
        light.powerOn();
        fan.powerOn();
        fan.adjustSpeed(Fan.Speed.HIGH);
        System.out.println(light.getStatus());
        System.out.println(fan.getStatus());
        ElectricalDevice[] devices = { light, fan };
        for (ElectricalDevice device : devices) {
            device.powerOff();
        }
    }
}
