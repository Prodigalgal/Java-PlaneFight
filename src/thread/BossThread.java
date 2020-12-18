package thread;

import config.Constant;
import entity.Planes.ProtossPlanes.Mothership;
import flyingObjects.Bullets;
import flyingObjects.PlayerPlane;
import util.BulletsUtil;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BossThread extends Thread {

    private int times = 0;
    private int directNum = 0;
    private final Random random = new Random();
    private final PlayerPlane Boss = Mothership.BossMotherShip;
    private final BulletsUtil bu = new BulletsUtil();

    //Boss初始化
    public BossThread() {
        Boss.setX(800);
        Boss.setY(0);
        Boss.setHp(Constant.BossHP);
        Boss.setBulletSpeed(20);
    }

    public void creatBossBullets() {
        int up = PlayerPlane.pp.getHp();//根据玩家血量调整boss伤害
        if (Constant.BossLevelUp > Boss.getHp()) {
            for (int i = 1; i < 6; i++) {
                bu.addBossBullet(new Bullets(Boss.getX() + Boss.getWidth() / 2, Boss.getY() + Boss.getHeight() / 2, Boss.getBulletImage(), Boss.getBulletSpeed(), i, Constant.EnemiesDamage + (int) (up * 0.1), Constant.NormalBullet));
            }
        } else {
            for (int i = 2; i < 5; i++) {
                bu.addBossBullet(new Bullets(Boss.getX() + Boss.getWidth() / 2, Boss.getY() + Boss.getHeight() / 2, Boss.getBulletImage(), Boss.getBulletSpeed(), i, Constant.EnemiesDamage + (int) (up * 0.1), Constant.NormalBullet));
            }
        }


    }

    //发射模式AB
    public void moveBossBulletsModA(ConcurrentLinkedQueue<Bullets> BossBullets) {
        if (BossBullets.isEmpty()) return;
        for (Bullets b : BossBullets) {
            switch (b.getDirect()) {
                case Constant.LEFT45B -> b.moveL45D();
                case Constant.LEFT30B -> b.moveL30D();
                case Constant.CENTERB -> b.moveDown();
                case Constant.RIGHT30B -> b.moveR30D();
                case Constant.RIGHT45B -> b.moveR45D();
            }
        }

    }

    public void moveBoss() {

        if (1 == directNum && 0 < Boss.getX()) {
            Boss.moveLeft();
        }
        if (2 == directNum && 1750 > Boss.getX()) {
            Boss.moveRight();
        }
        if (3 == directNum && 0 < Boss.getY()) {
            Boss.moveUp();
        }
        if (4 == directNum && 300 > Boss.getY()) {
            Boss.moveDown();
        }

    }


    @Override
    public void run() {
        while (Constant.STATES == Constant.STAR) {
            times++;
            moveBoss();
            moveBossBulletsModA(BulletsUtil.BossBullets);

            if (0 == times % 15) {
                directNum = random.nextInt(4) + 1;
            }
            if (0 == times % 15) {
                creatBossBullets();
            }

            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
