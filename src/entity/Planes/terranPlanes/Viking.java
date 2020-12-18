package entity.Planes.terranPlanes;

import flyingObjects.PlayerPlane;
import config.Images;

import java.awt.image.BufferedImage;

public class Viking extends PlayerPlane {

    public static Viking viking = new Viking(Images.Viking, Images.VikingBullet,0);
    //维京战机
    public Viking(BufferedImage image, BufferedImage imageBullet,int direct){
        this.bulletImage = imageBullet;
        this.bufferedImage = image;
        this.speed = 10;
        this.name = "维京战机";
        this.campId = 1;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.x = 800;
        this.y = 800;
        this.bulletSpeed = 20;
        this.direct = direct;
    }

}
