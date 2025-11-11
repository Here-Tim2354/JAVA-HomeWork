package Experiment.Experiment3.task3;

public abstract class ElectricalDevice {
    private String name;
    protected boolean isOn;

    public ElectricalDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    public abstract void powerOn();

    public abstract void powerOff();

    public String getStatus(){
        return "[" + name + "] 当前状态：" + (isOn ? "开启" : "关闭");
    }
}
