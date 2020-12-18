package util;

import config.Constant;
import config.Images;
import entity.Planes.ProtossPlanes.Mothership;
import entity.user.User;
import flyingObjects.Bullets;
import flyingObjects.PlayerPlane;
import flyingObjects.SpecialEffects;
import flyingObjects.SpecialItem;

import javax.swing.*;
import java.awt.*;

public class PaintPanelUtil extends JPanel {

    private Image image;
    private int picture_h1 = 0;//起始背景
    private int picture_h2 = -1080;//起始背景
    private static PaintPanelUtil instance;

    //双重缓冲处理卡顿
    @Override
    public void paint(Graphics graphics) {
        drawBufferedImage();
        graphics.drawImage(image, 0, 0, null);
    }

    private void drawBufferedImage() {

        image = createImage(this.getWidth(), 1080);
        Graphics g = image.getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, image.getWidth(null), image.getHeight(null));

        paintBackground(g);

        paintPlane(g);
        paintPlayerBullets(g);
        paintStates(g);
        paintProp(g);

        if(Constant.BossCome) {
            paintBossBullet(g);
            paintBoss(g);
            paintBossState(g);
        }

        paintEnemies(g);
        paintEnemiesBullets(g);
        paintSpecialEffects(g);

    }

    public void paintPlane(Graphics graphics) {
        PlayerPlane.pp.draw(graphics);
    }

    public void paintEnemies(Graphics graphics) {
        if (FlyPlaneUtil.EnemiesPlane.isEmpty()) return;
        for (PlayerPlane p : FlyPlaneUtil.EnemiesPlane) {
            p.draw(graphics);
        }

    }


    public void paintBossBullet(Graphics graphics) {
        if (BulletsUtil.BossBullets.isEmpty()) return;
        for (Bullets bullet : BulletsUtil.BossBullets) {
            bullet.draw(graphics);
        }
    }

    public void paintBoss(Graphics graphics) {
            Mothership.BossMotherShip.draw(graphics);
    }

    public void paintBossState(Graphics graphics) {
            PlayerPlane p =Mothership.BossMotherShip;
            graphics.drawString("Boss生命值：" + p.getHp(), 250, 85);
            graphics.setColor(Color.red);
            graphics.fillRect(250, 90, 500, 20);

            if (0 <= p.getHp() && p.getHp() < 500) {
                graphics.setColor(Color.green);
                graphics.fillRect(250, 90, p.getHp(), 20);
            }
            if (500 <= p.getHp() && p.getHp() < 1000) {
                graphics.setColor(Color.green);
                graphics.fillRect(250, 90, 500, 20);
                graphics.setColor(Color.MAGENTA);
                graphics.fillRect(250, 90, p.getHp() - 500, 20);
            }
            if (1000 <= p.getHp() && p.getHp() < 1500) {
                graphics.setColor(Color.MAGENTA);
                graphics.fillRect(250, 90, 500, 20);
                graphics.setColor(Color.GRAY);
                graphics.fillRect(250, 90, p.getHp() - 1000, 20);
            }
            if (1500 <= p.getHp() && p.getHp() < 2000) {
                graphics.setColor(Color.GRAY);
                graphics.fillRect(250, 90, 500, 20);
                graphics.setColor(Color.BLUE);
                graphics.fillRect(250, 90, p.getHp() - 1500, 20);
            }
            if (2000 <= p.getHp() && p.getHp() < 2500) {
                graphics.setColor(Color.BLUE);
                graphics.fillRect(250, 90, 500, 20);
                graphics.setColor(Color.CYAN);
                graphics.fillRect(250, 90, p.getHp() - 2000, 20);
            }
            if (2500 <= p.getHp() && p.getHp() <= 3000) {
                graphics.setColor(Color.CYAN);
                graphics.fillRect(250, 90, 500, 20);
                graphics.setColor(Color.ORANGE);
                graphics.fillRect(250, 90, p.getHp() - 2500, 20);
            }

    }

    public void paintPlayerBullets(Graphics graphics) {
        for (Bullets bullet : BulletsUtil.PlayerBullets) {
            bullet.draw(graphics);
        }
    }

    public void paintEnemiesBullets(Graphics graphics) {
        if (BulletsUtil.EnemiesBullets.isEmpty()) return;
        for (Bullets bullet : BulletsUtil.EnemiesBullets) {
            bullet.draw(graphics);
        }
    }

    public void paintProp(Graphics graphics) {
        if (0 == SpecialItemUtil.Prop.size()) return;
        for (SpecialItem s : SpecialItemUtil.Prop) {
            s.draw(graphics);
        }
    }

    public void paintSpecialEffects(Graphics graphics) {
        for (SpecialEffects s : SpecialEffectsUtil.SEList) {
            if(1 == s.getId()){
                s.setX(PlayerPlane.pp.getX()-30);
                s.setY(PlayerPlane.pp.getY()-30);
            }
            s.draw(graphics);

        }
    }

    public void paintStates(Graphics graphics) {

        graphics.drawString("生命：" + PlayerPlane.pp.getHp(), 120, 840);
        graphics.drawString("子弹伤害：" + Constant.BulletDamage, 120, 910);
        graphics.drawString("飞机速度：" + PlayerPlane.pp.getSpeed(), 120, 940);
        int x = 100;
        int y = 800;
        int width = 80;
        int height = 80;

        Graphics2D graphics2d = (Graphics2D) graphics;
        Graphics2D G2D = (Graphics2D) graphics;

        if(3 == PlayerPlane.pp.getCampId()) {
            graphics.drawString("分数：" + PlayerPlane.pp.getScore(), 120, 700);
            graphics.drawString("护盾量" + PlayerPlane.pp.getDefenceHp(),120,750);
            G2D.setStroke(new BasicStroke(10.0f));
            G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//抗锯齿
            G2D.setColor(Color.cyan);
            if (0 <= PlayerPlane.pp.getDefenceHp())
                G2D.drawArc(x-10, y-10, width+20, height+20, 90, (int) ((PlayerPlane.pp.getDefenceHp() / (User.user.getPlaneHP() * 1.0 * 0.5)) * 360));
        } else graphics.drawString("分数：" + PlayerPlane.pp.getScore(), 120, 700);



        graphics2d.setStroke(new BasicStroke(10.0f));//圆环宽度
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//抗锯齿
        graphics2d.setColor(Color.red);
        graphics2d.drawArc(x, y, width, height, 0, 360);
        graphics2d.setColor(Color.green);
        if (0 <= PlayerPlane.pp.getHp())
            graphics2d.drawArc(x, y, width, height, 90, (int) ((PlayerPlane.pp.getHp() / (User.user.getPlaneHP() * 1.0)) * 360));

    }

    public void paintBackground(Graphics graphics) {
        graphics.drawImage(Images.BackGround1, 0, picture_h1, null);
        graphics.drawImage(Images.BackGround2, 0, picture_h2, null);
        picture_h1 += 5;
        picture_h2 += 5;
        if (picture_h1 == 1080)
            picture_h1 = -1080;
        if (picture_h2 == 1080)
            picture_h2 = -1080;
    }

    public static PaintPanelUtil getInstance() {
        if (null == instance) {
            instance = new PaintPanelUtil();
        }
        return instance;
    }


}
