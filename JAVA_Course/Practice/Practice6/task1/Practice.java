package Practice.Practice6.task1;

import java.util.Random;

public class Practice {
    private int x;
    private int y;
    private int result;

    public Practice(IntegerAdditionRules integerAdditionRules){
        Random random = new Random();
        this.x = random.nextInt(integerAdditionRules.getMaxScope() - integerAdditionRules.getMinScope() + 1)
                + integerAdditionRules.getMinScope();
        this.y = random.nextInt(integerAdditionRules.getMaxScope() - integerAdditionRules.getMinScope() + 1)
                + integerAdditionRules.getMinScope();
        this.result = x + y;
    }

    public void printQuestion(){
        System.out.println(this.x+" + "+this.y+" = ? 输入你的答案：");
    }

    public String printAnswer(){
        return "正确答案是："+this.result;
    }

    public int getResult() {
        return result;
    }
}
