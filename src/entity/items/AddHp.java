package entity.items;

import config.Images;
import flyingObjects.SpecialItem;

public class AddHp extends SpecialItem {
//»Ø¸´ÉúÃü

    public AddHp(int x,int y) {
        this.bufferedImage = Images.AddHp;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.speed = 20;
        this.hp.set(1);
        this.x = x;
        this.y = y;
        this.id = 3;
    }
}
