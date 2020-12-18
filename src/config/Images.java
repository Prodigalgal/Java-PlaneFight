package config;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    public static BufferedImage BackGround1;
    public static BufferedImage BackGround2;
    public static BufferedImage FirstPanel;
    public static BufferedImage loginButton;
    public static BufferedImage reButton;
    public static BufferedImage readyBackGround;
    public static BufferedImage T;
    public static BufferedImage Z;
    public static BufferedImage P;
    public static BufferedImage FlyStar;
    public static BufferedImage Back;
    public static BufferedImage damageB;
    public static BufferedImage HpB;
    public static BufferedImage speedB;
    public static BufferedImage storeBack;
    public static BufferedImage storeBackground;
    public static BufferedImage storeB;
    public static BufferedImage AddHp;
    public static BufferedImage BulletSP;

    public static BufferedImage Viking;
    public static BufferedImage VikingFace;
    public static BufferedImage VikingBullet;

    public static BufferedImage Battlecruiser;
    public static BufferedImage BattlecruiserFace;
    public static BufferedImage BattlecruiserBullet;
    public static BufferedImage BattlecruiserBulletFace;

    public static BufferedImage Mothership;

    public static BufferedImage Phoenix;
    public static BufferedImage PhoenixFace;
    public static BufferedImage PhoenixBullet;

    public static BufferedImage Mutalisk;
    public static BufferedImage MutaliskFace;
    public static BufferedImage MutaliskBullet;
    public static BufferedImage MutaliskBulletFace;

    public static BufferedImage Corruptor;
    public static BufferedImage CorruptorFace;
    public static BufferedImage CorruptorBullet;
    public static BufferedImage CorruptorBulletFace;

    public static BufferedImage Tempest;
    public static BufferedImage TempestFace;
    public static BufferedImage TempestBullet;
    public static BufferedImage TempestBulletFace;

    public static BufferedImage DamagePromote;
    public static BufferedImage SpeedUp;

    public static BufferedImage labelT;
    public static BufferedImage labelP;
    public static BufferedImage labelZ;

    public static Image Boom;
    public static Image PlayerHit;
    public static Image HPse;





    //¥Ê∑≈À˘”–Õº∆¨
    static {
        try {
            BackGround1 = ImageIO.read(new File("src/source/images/12343.jpg"));
            BackGround2 = ImageIO.read(new File("src/source/images/12343.jpg"));
            FirstPanel = ImageIO.read(new File("src/source/images/FPBG.jpg"));
            loginButton = ImageIO.read(new File("src/source/images/Button.png"));
            reButton = ImageIO.read(new File("src/source/images/Button2.png"));
            readyBackGround = ImageIO.read(new File("src/source/images/readyBackGround.png"));
            T = ImageIO.read(new File("src/source/images/T.png"));
            Z = ImageIO.read(new File("src/source/images/Z.png"));
            P = ImageIO.read(new File("src/source/images/P.png"));
            Back = ImageIO.read(new File("src/source/images/back.png"));
            FlyStar = ImageIO.read(new File("src/source/images/FlyStar.png"));
            damageB = ImageIO.read(new File("src/source/images/damageButton.png"));
            AddHp = ImageIO.read(new File("src/source/images/AddHP.png"));
            HpB = ImageIO.read(new File("src/source/images/hpButton.png"));
            speedB = ImageIO.read(new File("src/source/images/speedButton.png"));
            storeBack = ImageIO.read(new File("src/source/images/storeBack.png"));
            storeBackground = ImageIO.read(new File("src/source/images/lable3.jpg"));
            storeB = ImageIO.read(new File("src/source/images/storeButton.png"));
            BulletSP = ImageIO.read(new File("src/source/images/BulletSP.png"));

            Boom = Toolkit.getDefaultToolkit().getImage("src/source/images/boom.gif");
            PlayerHit = Toolkit.getDefaultToolkit().getImage("src/source/images/Player.gif");
            HPse = Toolkit.getDefaultToolkit().getImage("src/source/images/HPse.gif");

            labelT = ImageIO.read(new File("src/source/images/labelT.jpg"));
            labelZ = ImageIO.read(new File("src/source/images/labelZ.jpg"));
            labelP = ImageIO.read(new File("src/source/images/labelP.jpg"));

            Viking = ImageIO.read(new File("src/source/images/Viking.png"));
            VikingFace = ImageIO.read(new File("src/source/images/VikingFace.png"));
            VikingBullet = ImageIO.read(new File("src/source/images/VikingBullet.png"));

            Battlecruiser = ImageIO.read(new File("src/source/images/Battlecruiser.png"));
            BattlecruiserFace = ImageIO.read(new File("src/source/images/BattlecruiserFace.png"));
            BattlecruiserBullet = ImageIO.read(new File("src/source/images/BattlecruiserBullet.png"));
            BattlecruiserBulletFace = ImageIO.read(new File("src/source/images/BattlecruiserBulletFace.png"));

            Mutalisk = ImageIO.read(new File("src/source/images/Mutalisk.png"));
            MutaliskFace = ImageIO.read(new File("src/source/images/MutaliskFace.png"));
            MutaliskBullet = ImageIO.read(new File("src/source/images/MutaliskBullet.png"));
            MutaliskBulletFace = ImageIO.read(new File("src/source/images/MutaliskBulletFace.png"));

            Mothership = ImageIO.read(new File("src/source/images/Mothership.png"));

            Phoenix = ImageIO.read(new File("src/source/images/Phoenix.png"));
            PhoenixFace = ImageIO.read(new File("src/source/images/PhoenixFace.png"));
            PhoenixBullet = ImageIO.read(new File("src/source/images/PhoenixBullet.png"));

            Tempest = ImageIO.read(new File("src/source/images/Tempest.png"));
            TempestFace = ImageIO.read(new File("src/source/images/TempestFace.png"));
            TempestBullet = ImageIO.read(new File("src/source/images/TempestBullet.png"));
            TempestBulletFace = ImageIO.read(new File("src/source/images/TempestBulletFace.png"));

            Corruptor = ImageIO.read(new File("src/source/images/Corruptor.png"));
            CorruptorFace = ImageIO.read(new File("src/source/images/CorruptorFace.png"));
            CorruptorBullet = ImageIO.read(new File("src/source/images/CorruptorBullet.png"));
            CorruptorBulletFace = ImageIO.read(new File("src/source/images/CorruptorBulletFace.png"));

            DamagePromote = ImageIO.read(new File("src/source/images/DamagePromote.jpg"));
            SpeedUp = ImageIO.read(new File("src/source/images/SpeedUp.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
