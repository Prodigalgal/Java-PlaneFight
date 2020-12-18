package entity.Planes.zergPlanes;

import flyingObjects.PlayerPlane;
import config.Images;

import java.awt.image.BufferedImage;

public class Corruptor extends PlayerPlane {
    //������
    public static Corruptor corruptor = new Corruptor(Images.Corruptor, Images.CorruptorBullet,0);

    public Corruptor(BufferedImage image, BufferedImage imageBullet,int direct){
        this.bulletImage = imageBullet;
        this.bufferedImage = image;
        this.speed = 20;
        this.name = "������";
        this.campId = 2;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.x = 800;
        this.y = 800;
        this.bulletSpeed = 30;
        this.direct = direct;
    }
}
