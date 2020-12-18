package entity.Planes.ProtossPlanes;

import flyingObjects.PlayerPlane;
import config.Images;

import java.awt.image.BufferedImage;

public class Phoenix extends PlayerPlane {
    //·ï»Ë
    public static Phoenix phoenix = new Phoenix(Images.Phoenix, Images.PhoenixBullet,0);

    public Phoenix(BufferedImage image, BufferedImage imageBullet,int direct){
        this.bulletImage = imageBullet;
        this.bufferedImage = image;
        this.speed = 10;
        this.name = "·ï»Ë";
        this.campId = 3;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.x = 800;
        this.y = 800;
        this.bulletSpeed = 40;
        this.direct = direct;
    }
}
