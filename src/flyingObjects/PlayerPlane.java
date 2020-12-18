package flyingObjects;

import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerPlane extends FlyObject implements moveModel {

    public String name;//飞船名字
    public int campId;//飞船阵营id
    public int speed = 10;//飞船默认移动速度
    public AtomicInteger Score = new AtomicInteger(5);
    public int bulletSpeed;//子弹速度
    public int direct = 0;
    public BufferedImage bulletImage;//子弹图片
    public int AutoHp = 1;//虫族的自动回血
    public int AutoProtect = 1;//人族的减免伤害
    public int AutoDefence = 1;//神族的自动回复护盾
    public int DefenceHp = 0;

    public static PlayerPlane pp = new PlayerPlane();

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveR45D() {
        moveDown();
        x += speed;
    }

    public void moveL45D() {
        moveDown();
        x -= speed;
    }

    public void moveR30D() {
        moveDown();
        x += 5;
    }

    public void moveL30D() {
        moveDown();
        x -= 5;
    }

    public void moveR45U() {
        moveUp();
        x += speed;
    }

    public void moveL45U() {
        moveUp();
        x -= speed;
    }

    public void moveR30U() {
        moveUp();
        x += 5;
    }

    public void moveL30U() {
        moveUp();
        x -= 5;
    }

    public void addScore(int score) {
        Score.addAndGet(score);
    }

    public void addSpeed() {
        speed++;
    }

    public void reduceHP(int damage) {
        hp.getAndSet(hp.intValue() - damage);
    }

    public void addHP(int h) {
        hp.getAndSet(hp.intValue() + h);
    }

    public void addDefence(int DFC) {
        this.DefenceHp += DFC;
    }

    public void reduceDefence(int damage) {
        if (this.DefenceHp - damage < 0) {
            reduceHP((damage - this.DefenceHp));
            this.DefenceHp = 0;
        } else
            this.DefenceHp -= damage;
    }

    public void reInitial() {
        Score = new AtomicInteger(5);
        pp.setX(800);
        pp.setY(800);
        DefenceHp = 0;
        pp = new PlayerPlane();
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletSpeed(int bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    public int getScore() {
        return Score.get();
    }

    public void setScore(int score) {
        Score.set(score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getBulletImage() {
        return bulletImage;
    }

    public void setBulletImage(BufferedImage bulletImage) {
        this.bulletImage = bufferedImage;
    }

    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }

    public int getDefenceHp() {
        return DefenceHp;
    }

    public void setDefenceHp(int defenceHp) {
        DefenceHp = defenceHp;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
