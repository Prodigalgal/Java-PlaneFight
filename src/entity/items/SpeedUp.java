package entity.items;

import flyingObjects.SpecialItem;
import config.Images;

public class SpeedUp extends SpecialItem {
    //ÒÆËÙÌáÉý
    public SpeedUp(int x,int y) {
        this.bufferedImage = Images.SpeedUp;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.speed = 20;
        this.hp .set(1);
        this.x = x;
        this.y = y;
        this.id = 2;
    }
}
