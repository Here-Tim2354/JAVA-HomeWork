package Experiment.Experiment2.task4;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = 0;
        this.endTime = 0;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 模拟一些任务
        for (int i = 0; i < 1000000000; i++) {
            Math.sqrt(i);
        }

        stopWatch.stop();
        System.out.println("循环100000000次执行时间: " + stopWatch.getElapsedTime()+"毫秒");
    }
}
