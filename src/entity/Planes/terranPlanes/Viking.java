package entity.Planes.terranPlanes;

import flyingObjects.PlayerPlane;
import config.Images;

import java.awt.image.BufferedImage;

public class Viking extends PlayerPlane {

    public static Viking viking = new Viking(Images.Viking, Images.VikingBullet,0);
    //ά��ս��
    public Viking(BufferedImage image, BufferedImage imageBullet,int direct){
        this.bulletImage = imageBullet;
        this.bufferedImage = image;
        this.speed = 10;
        this.name = "ά��ս��";
        this.campId = 1;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.x = 800;
        this.y = 800;
        this.bulletSpeed = 20;
        this.direct = direct;
    }

}
