package flyingObjects;

import java.awt.image.BufferedImage;

public class Bullets extends FlyObject implements moveModel{

    private int direct = 3;
    private int damage = 1;
    private int id = 0;

    public Bullets(int x, int y, BufferedImage bullet,int speed,int direct,int damage,int id){
        this.bufferedImage = bullet;
        this.speed = speed;
        this.width = bufferedImage.getWidth();
        this.height = bufferedImage.getHeight();
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.direct = direct;
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }


    public void moveDown(){
        y+=speed;
    }
    public void moveLeft(){
        x-=speed;
    }
    public void moveRight(){
        x+=speed;
    }
    public void moveUp(){
        y-=speed;
    }
    public void moveR45D(){ moveDown();x+= 10; }
    public void moveL45D(){ moveDown();x-= 10; }
    public void moveR30D(){ moveDown();x+= 5; }
    public void moveL30D(){ moveDown();x-= 5; }
    public void moveR45U() {

    }
    public void moveL45U() {

    }
    public void moveR30U() { moveUp();x+= 5; }
    public void moveL30U() { moveUp();x-= 5; }

    public int getDirect() {
        return direct;
    }
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public BufferedImage getBulletImage() {
        return bufferedImage;
    }
    public int getBulletSpeed() {
        return speed;
    }
}
