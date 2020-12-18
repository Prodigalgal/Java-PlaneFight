package thread;

import entity.Planes.ProtossPlanes.Phoenix;
import entity.Planes.ProtossPlanes.Tempest;
import entity.Planes.terranPlanes.Battlecruiser;
import entity.Planes.terranPlanes.Viking;
import entity.Planes.zergPlanes.Corruptor;
import entity.Planes.zergPlanes.Mutalisk;
import flyingObjects.Bullets;
import flyingObjects.PlayerPlane;
import util.BulletsUtil;
import config.Constant;
import util.FlyPlaneUtil;
import config.Images;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EnemiesThread extends Thread {

    private int times = 0;
    private final BulletsUtil bu = new BulletsUtil();
    private final FlyPlaneUtil fu = new FlyPlaneUtil();
    private Random random = new Random();

    public void creatEnemy(int score, int campID) {
        //生成敌方飞机
        ConcurrentLinkedQueue<PlayerPlane> Enemies = null;

        int i = random.nextInt();

        switch (campID) {
            case 1 -> Enemies = creatZ(score, i);//选择人族后产生敌人
            case 2 -> Enemies = creatP(score, i);//选择虫族后产生敌人
            case 3 -> Enemies = creatT(score, i);//选择神族后产生敌人
        }

        for (PlayerPlane p3 : Enemies) {

            switch (p3.getDirect()) {
                case Constant.directC -> {
                    p3.setY(0);
                    p3.setX(random.nextInt(1750));
                    fu.addEnemy(p3);
                }
                case Constant.directUR -> {
                    p3.setY(random.nextInt(200) + p3.getHeight());
                    p3.setX(0);
                    fu.addEnemy(p3);
                }
                case Constant.directUL -> {
                    p3.setY(random.nextInt(200) + p3.getHeight());
                    p3.setX(Constant.WindowWidth - 50);
                    fu.addEnemy(p3);
                }
                case Constant.directDL -> {
                    p3.setY(Constant.WindowHeight);
                    p3.setX(Constant.WindowWidth - random.nextInt(100));
                    fu.addEnemy(p3);
                }
                case Constant.directDR -> {
                    p3.setY(Constant.WindowHeight);
                    p3.setX(random.nextInt(100));
                    fu.addEnemy(p3);
                }
            }

        }

    }

    public ConcurrentLinkedQueue<PlayerPlane> creatT(int score, int i) {
        ConcurrentLinkedQueue<PlayerPlane> p = new ConcurrentLinkedQueue<>();
        if (Constant.LEVEL2 >= score) {
            p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directC));
        }
        if (Constant.LEVEL2 < score && Constant.LEVEL3 > score) {
            if (0 == i % 2) {
                p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directUR));
                p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directUL));
            } else {
                p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directDL));
                p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directDR));
            }
            p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directC));
            p.offer(new Battlecruiser(Images.BattlecruiserFace, Images.BattlecruiserBulletFace, Constant.directC));
        }
        if (Constant.LEVEL3 <= score) {
            p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directUR));
            p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directUL));
            p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directDL));
            p.offer(new Viking(Images.VikingFace, Images.VikingBullet, Constant.directDR));
            for (int j = 0; j < 4; j++) {
                p.offer(new Battlecruiser(Images.BattlecruiserFace, Images.BattlecruiserBulletFace, Constant.directC));
            }
        }
        return p;
    }

    public ConcurrentLinkedQueue<PlayerPlane> creatP(int score, int i) {
        ConcurrentLinkedQueue<PlayerPlane> p = new ConcurrentLinkedQueue<>();
        if (Constant.LEVEL2 >= score) {
            p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directC));
        }
        if (Constant.LEVEL2 < score && Constant.LEVEL3 > score) {
            if (0 == i % 2) {
                p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directUR));
                p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directUL));
            } else {
                p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directDR));
                p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directDL));
            }
            p.offer(new Tempest(Images.TempestFace, Images.TempestBulletFace, Constant.directC));
        }
        if (Constant.LEVEL3 <= score) {
            p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directUR));
            p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directUL));
            p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directDR));
            p.offer(new Phoenix(Images.PhoenixFace, Images.PhoenixBullet, Constant.directDL));
            for (int j = 0; j < 4; j++) {
                p.offer(new Tempest(Images.TempestFace, Images.TempestBulletFace, Constant.directC));
            }
        }
        return p;
    }


    public ConcurrentLinkedQueue<PlayerPlane> creatZ(int score, int i) {

        ConcurrentLinkedQueue<PlayerPlane> p = new ConcurrentLinkedQueue<>();


        if (Constant.LEVEL2 >= score) {
            p.offer(new Mutalisk(Images.MutaliskFace, Images.MutaliskBulletFace, Constant.directC));
        }
        if (Constant.LEVEL2 < score && Constant.LEVEL3 > score) {
            if (0 == i % 2) {
                p.offer(new Mutalisk(Images.Mutalisk, Images.MutaliskBulletFace, Constant.directUR));
                p.offer(new Mutalisk(Images.Mutalisk, Images.MutaliskBulletFace, Constant.directUL));
            } else {
                p.offer(new Mutalisk(Images.Mutalisk, Images.MutaliskBulletFace, Constant.directDR));
                p.offer(new Mutalisk(Images.Mutalisk, Images.MutaliskBulletFace, Constant.directDL));
            }
            p.offer(new Corruptor(Images.CorruptorFace, Images.CorruptorBulletFace, Constant.directC));
        }
        if (Constant.LEVEL3 <= score) {
            p.offer(new Mutalisk(Images.Mutalisk, Images.MutaliskBulletFace, Constant.directUR));
            p.offer(new Mutalisk(Images.Mutalisk, Images.MutaliskBulletFace, Constant.directUL));
            p.offer(new Mutalisk(Images.Mutalisk, Images.MutaliskBulletFace, Constant.directDR));
            p.offer(new Mutalisk(Images.Mutalisk, Images.MutaliskBulletFace, Constant.directDL));
            for (int j = 0; j < 4; j++) {
                p.offer(new Corruptor(Images.CorruptorFace, Images.CorruptorBulletFace, Constant.directC));
            }
        }
        return p;
    }

    public void creatEnemiesBullets() {
        //生成敌方子弹
        for (PlayerPlane p : FlyPlaneUtil.EnemiesPlane) {
            if (0 == random.nextInt() % 2) {
                String sName = p.getName();
                int tp = Constant.NormalBullet;
                if ("腐化者".equals(sName) | "战列巡航舰".equals(sName) | "风暴战舰".equals(sName))
                    tp = Constant.SpecialBullet;
                Bullets bullet = new Bullets(p.getX() + p.getWidth() / 2, p.getY(), p.getBulletImage(), p.getBulletSpeed(), Constant.CENTERB, Constant.EnemiesDamage, tp);
                bu.addEnemiesBullet(bullet);
            }
        }
    }

    public void moveEnemiesBullets(int times) {
        //移动敌方子弹
        if (BulletsUtil.EnemiesBullets.isEmpty()) return;
        for (Bullets bullet : BulletsUtil.EnemiesBullets) {
            if (Constant.SpecialBullet == bullet.getId() && 0 == random.nextInt() % 2 && 0 == times%5) {
                bullet.setId(Constant.NormalBullet);
                bu.addEnemiesBullet(new Bullets(bullet.getX() + bullet.getWidth() / 2, bullet.getY(), bullet.getBulletImage(), bullet.getBulletSpeed(), Constant.LEFT45B, Constant.EnemiesDamage, Constant.NormalBullet));
                bu.addEnemiesBullet(new Bullets(bullet.getX() + bullet.getWidth() / 2, bullet.getY(), bullet.getBulletImage(), bullet.getBulletSpeed(), Constant.RIGHT45B, Constant.EnemiesDamage, Constant.NormalBullet));
            }
            switch (bullet.getDirect()) {
                case Constant.CENTERB -> bullet.moveDown();
                case Constant.LEFT45B -> bullet.moveL30D();
                case Constant.RIGHT45B -> bullet.moveR30D();
            }
        }
    }

    public void moveEnemies() {
        //移动敌方飞机
        if (FlyPlaneUtil.EnemiesPlane.isEmpty()) return;
        for (PlayerPlane p : FlyPlaneUtil.EnemiesPlane) {
            if (Constant.directC == p.getDirect())
                p.moveDown();
            if (Constant.directUR == p.getDirect())
                p.moveR45D();
            if (Constant.directUL == p.getDirect())
                p.moveL45D();
            if (Constant.directDL == p.getDirect())
                p.moveL45U();
            if (Constant.directDR == p.getDirect())
                p.moveR45U();
        }
    }

    @Override
    public void run() {
        while (Constant.STATES == Constant.STAR) {

            times++;
            moveEnemies();
            moveEnemiesBullets(times);

            if (0 == times % 15 && !Constant.BossCome)
                creatEnemy(PlayerPlane.pp.getScore(), PlayerPlane.pp.getCampId());

            if (0 == times % 100 && 0 != FlyPlaneUtil.EnemiesPlane.size())
                creatEnemiesBullets();

            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
