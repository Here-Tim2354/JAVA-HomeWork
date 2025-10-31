package Experiment.Experiment1.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OpenCabinet {
    int number;
    ArrayList<Boolean> cabinet;

    public OpenCabinet(int number){
        this.number=number;
    }
    public void initializeCabinet(){
        cabinet=new ArrayList<>(Collections.nCopies(number,false));
    }
    public void processor(){
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                cabinet.set(j - 1, !cabinet.get(j - 1));
            }
        }
    }
    public void showResult() {
        System.out.println("最终打开的储物柜编号：");
        for (int i = 0; i < number; i++) {
            if (cabinet.get(i)) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入储物柜数量：");
        int m = sc.nextInt();

        OpenCabinet oc = new OpenCabinet(m);
        oc.initializeCabinet();
        oc.processor();
        oc.showResult();

        sc.close();
    }
}
