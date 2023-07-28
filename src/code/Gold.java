package code;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Gold{
    BufferedImage image;
    int num=0;
    int price;
    int x;
    int y;
    int width;
    int height;
    ArrayList<BufferedImage> images = new ArrayList<>();
    Game panel;

    public Gold(int x,int y,Game panel,int gold){
        this.panel = panel;
        for (int i = 1; i <= 9; i++) {
            String goldName = "src/resource/gold/gold0"+i+".png";
            images.add((BufferedImage) panel.loadImage(goldName));
        }
        this.x = x;
        this.y = y;
        image = images.get(0);
        width = image.getWidth();
        height = image.getHeight();
        price = gold;
    }


    public void move(){
        num++;
        image = images.get(num);
        width=image.getWidth();
        height=image.getHeight();
        num++;
        if(num==8) panel.golds.remove(this);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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

}
