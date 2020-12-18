package entity.items;

import config.Images;
import flyingObjects.SpecialItem;

public class BulletSP extends SpecialItem {
    //∂‡÷ÿ∑¢…‰

    public BulletSP(int x,int y) {
        this.bufferedImage = Images.BulletSP;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.speed = 20;
        this.hp.set(1);
        this.x = x;
        this.y = y;
        this.id = 4;
    }
}
