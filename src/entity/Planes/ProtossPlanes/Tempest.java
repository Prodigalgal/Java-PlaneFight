package entity.Planes.ProtossPlanes;

import flyingObjects.PlayerPlane;
import config.Images;

import java.awt.image.BufferedImage;

public class Tempest extends PlayerPlane {
    //风暴战舰
    public static Tempest tempest = new Tempest(Images.Tempest, Images.TempestBullet,0);

    public Tempest(BufferedImage image, BufferedImage imageBullet, int direct){
        this.bulletImage = imageBullet;
        this.bufferedImage = image;
        this.speed = 5;
        this.name = "风暴战舰";
        this.campId = 3;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.x = 800;
        this.y = 800;
        this.bulletSpeed = 30;
        this.direct = direct;
    }
}
