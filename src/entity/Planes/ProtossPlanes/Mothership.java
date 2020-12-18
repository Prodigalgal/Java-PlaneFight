package entity.Planes.ProtossPlanes;

import flyingObjects.PlayerPlane;
import config.Images;

import java.awt.image.BufferedImage;

public class Mothership extends PlayerPlane {
    //Ä¸½¢
    public static Mothership BossMotherShip = new Mothership(Images.Mothership, Images.PhoenixBullet,0);

    public Mothership(BufferedImage image,BufferedImage imageBullet,int direct){
        this.bulletImage = imageBullet;
        this.bufferedImage = image;
        this.speed = 5;
        this.hp.set(30);
        this.name = "Ä¸½¢";
        this.campId = 3;
        this.Score.set(5);
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.x = 800;
        this.y = 800;
        this.bulletSpeed = 30;
        this.direct = direct;
    }

}
