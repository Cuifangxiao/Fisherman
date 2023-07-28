package code;

import java.awt.image.BufferedImage;

public class Net {
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;
    private Game game;
    long oldTime;
    long currentTime;
    public Net(int x,int y,int power,Game game){
        String bulletName = "src/resource/net/net0";
        int index;
        if(power == 1 || power == 2) index = 1;
        else if(power ==3 || power == 4) index = 2;
        else if(power == 5 || power == 6) index = 3;
        else index = 4;
        String lastName = index + ".png";
        this.game = game;
        image = (BufferedImage)game.loadImage(bulletName+lastName);
        width = image.getWidth();
        height = image.getHeight();
        this.x = x - width/2;
        this.y = y  - height/2;
    }

    public void move(){
        currentTime=game.getTime();
        if(currentTime - oldTime >=100){
            game.nets.remove(this);
        }
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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public long getOldTime() {
        return oldTime;
    }

    public void setOldTime(long oldTime) {
        this.oldTime = oldTime;
    }
}
