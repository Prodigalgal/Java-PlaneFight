package entity.items;

import flyingObjects.SpecialItem;
import config.Images;

public class DamagePromote extends SpecialItem {
    //…À∫¶Ã·…˝

    public DamagePromote(int x,int y) {
        this.bufferedImage = Images.DamagePromote;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.speed = 20;
        this.hp.set(1);
        this.x = x;
        this.y = y;
        this.id = 1;
    }

}
