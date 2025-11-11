package Experiment.Experiment3.task3;

public class Fan extends ElectricalDevice{
    enum Speed{
        LOW(1),
        MEDIUM(2),
        HIGH(3);

        private final int speedValue;

        Speed(int speedValue) {
            this.speedValue = speedValue;
        }

        public int getSpeedValue() {
            return speedValue;
        }
    }

    private Speed currentSpeed;

    public Fan(String name) {
        super(name);
        this.currentSpeed=Speed.LOW;
    }

    public void powerOn() {
        super.isOn = true;
        System.out.println("风扇["+super.getName()+"]已开启, 当前速度："+currentSpeed.getSpeedValue()+"档");
    }

    public void powerOff() {
        super.isOn = false;
        System.out.println("风扇["+super.getName()+"]已关闭");
    }

    public void adjustSpeed(Speed speed) {
        if (super.isOn) {
            this.currentSpeed = speed;
            System.out.println("风扇["+super.getName()+"]速度已调整为："+currentSpeed.getSpeedValue()+"档");
        } else {
            System.out.println("风扇["+super.getName()+"]未开启，无法调整速度");
        }
    }
}
