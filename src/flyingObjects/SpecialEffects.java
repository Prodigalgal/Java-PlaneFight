package flyingObjects;

import java.awt.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SpecialEffects {
    private int x;
    private int y;
    private Image image;
    private long birthTime;
    private int id;

    public SpecialEffects() {
    }

    public SpecialEffects(int x, int y, Image image,int id) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.id = id;
        this.birthTime = System.currentTimeMillis();
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getBirthTime() {
        return birthTime;
    }
}
