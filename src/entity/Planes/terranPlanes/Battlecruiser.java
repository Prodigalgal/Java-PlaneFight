package entity.Planes.terranPlanes;

import flyingObjects.PlayerPlane;
import config.Images;

import java.awt.image.BufferedImage;

public class Battlecruiser extends PlayerPlane {
    public static Battlecruiser battlecruiser = new Battlecruiser(Images.Battlecruiser, Images.BattlecruiserBullet,0);
    //战列巡航舰
    public Battlecruiser(BufferedImage image, BufferedImage imageBullet,int direct){
        this.bulletImage = imageBullet;
        this.bufferedImage = image;
        this.speed = 20;
        this.name = "战列巡航舰";
        this.campId = 1;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.x = 800;
        this.y = 800;
        this.bulletSpeed = 50;
        this.direct = direct;
    }

}
