package entity.Planes.zergPlanes;

import flyingObjects.PlayerPlane;
import config.Images;

import java.awt.image.BufferedImage;

public class Mutalisk extends PlayerPlane {
    //령질
    public static Mutalisk mutalisk= new Mutalisk(Images.Mutalisk, Images.MutaliskBullet,0);

    public Mutalisk(BufferedImage image,BufferedImage imageBullet,int direct){
        this.bulletImage = imageBullet;
        this.bufferedImage = image;
        this.speed = 10;
        this.name = "령질";
        this.campId = 2;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.x = 800;
        this.y = 800;
        this.bulletSpeed = 20;
        this.direct = direct;
    }


}
