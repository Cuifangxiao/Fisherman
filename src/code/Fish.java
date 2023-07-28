package code;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Fish extends Thread{
    private int x;
    private int y;
    int num = 0,num1=0;
    private int blood,initBlood;
    private boolean isCatch;
    public int step;
    private int width;
    private int height;
    private int step_num=0;
    private int gold,score;

    BufferedImage image;
    private Game gamePanel;

    ArrayList<BufferedImage> roving = new ArrayList<>();
    ArrayList<BufferedImage> catching = new ArrayList<>();
    long oldTime;
    long currentTime;
    int index;


    Random r = new Random();
    public Fish(Game gamePanel){
        String fishName;
        index = (r.nextInt(11)+1);

        if(index == 10 && r.nextInt(2) == 1)  index = (r.nextInt(11)+1);

        Integer[] steps = new Integer[]{10,8,7,10,7,8,6,4,6,5,10};
        Integer[] bloods = new Integer[]{10,16,18,24,26,28,30,32,34,36,32};
        Integer[] golds = new Integer[]{2,4,7,10,10,20,25,40,50,100,30};


        gold = golds[index-1];
        score = golds[index-1] * 10;
        step = steps[index-1];
        step = step/2;
        blood = bloods[index-1];
        initBlood = blood;

        String fishName1 = "src/resource/fish/fish0"+ index + "_";
        for (int i = 0; i < 10; i++) {
            int fi = i+1;
            String fishName2 = fi +".png";
            fishName=fishName1+fishName2;
            BufferedImage img = (BufferedImage) gamePanel.loadImage(fishName);
            roving.add(img);
            this.gamePanel = gamePanel;
        }




        //确定显示图片
        image = roving.get(0);
        width = image.getWidth();
        height = image.getHeight();
        if(index == 1) height+=20;
        x=1200 + r.nextInt(1000);
        y=r.nextInt(400);

        isCatch=false;
        for (int i = 1; i <= 2; i++) {
            catching.add((BufferedImage) gamePanel.loadImage("src/resource/fish/fish0" + index + "_catch_" + i +".png"));
        }


    }

    //鱼游动起来
    public void move(){
        num++;
        if(num%5==0) step_num++;
        image = roving.get(step_num%10);
        width = image.getWidth();

        height = image.getHeight();

        x-=step;
        //如果出去   从头开始刷新
        if(x<=-width){
            getOut();
        }

    }

    public void turnOver() {
        num1++;
        image = catching.get(num1%2);
        currentTime=gamePanel.getTime();
        if(currentTime - oldTime >= 500) {
            //重置鱼的属性,坐标，速度，是否被抓
            x = 1200 + r.nextInt(1000);
            this.y = r.nextInt(400);
            blood = initBlood;
            this.isCatch = false;
            currentTime=0;
            oldTime=0;
        }

    }

    public void getOut(){
        blood = initBlood;
        x=1200 + r.nextInt(1000);
        y=r.nextInt(400);
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getCatch() {
        return isCatch;
    }

    public void setCatch(boolean aCatch) {
        isCatch = aCatch;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public long getOldTime() {
        return oldTime;
    }

    public void setOldTime(long oldTime) {
        this.oldTime = oldTime;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
