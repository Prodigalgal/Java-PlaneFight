package thread;

import GameWindos.StarFrame;
import config.Constant;
import config.Images;
import entity.Planes.ProtossPlanes.Mothership;
import entity.user.User;
import flyingObjects.Bullets;
import flyingObjects.PlayerPlane;
import flyingObjects.SpecialEffects;
import flyingObjects.SpecialItem;
import util.*;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CheckUtilThread extends Thread {

    private long times = 0;
    private final Random random = new Random();

    //���Խ��
    public void checkPlaneOutOfBounds(ConcurrentLinkedQueue<PlayerPlane> LinkedQueue) {
        LinkedQueue.removeIf(p -> 1180 <= p.getY() || 1850 <= p.getX() || -100 >= p.getX() || -100 >= p.getY());
    }

    //���Խ��
    public void checkBulletsOutOfBounds(ConcurrentLinkedQueue<Bullets> LinkedQueue) {
        LinkedQueue.removeIf(b -> 1080 <= b.getY() || 0 >= b.getY());
    }

    //���Խ��
    public void checkSpecialItemOutOfBounds(ConcurrentLinkedQueue<SpecialItem> LinkedQueue) {
        LinkedQueue.removeIf(b -> 1080 <= b.getY());
    }

    //����ҷ��ӵ����е���
    public void checkBulletsHitEnemies(ConcurrentLinkedQueue<Bullets> BulletsQueue, ConcurrentLinkedQueue<PlayerPlane> EnemiesQueue) {
        PlayerPlane p1 = PlayerPlane.pp;
        for (Bullets b : BulletsQueue) {
            for (PlayerPlane p : EnemiesQueue) {
                if (0 > p.getX() - b.getX() && b.getX() - p.getX() < p.getWidth() && 0 < b.getY() - p.getY() && b.getY() - p.getY() < p.getHeight()) {
                    new MusicAndSpecialUtil().musicPlayAndSpecialAdd(p.getX() + random.nextInt(p.getWidth()),p.getY() + random.nextInt(p.getHeight()),Images.Boom,Constant.SEUNLockLocation);//��������Ч���
                    BulletsQueue.remove(b);
                    EnemiesQueue.remove(p);
                    p1.addScore(p.getScore());
                    break;
                }
            }
        }
    }

    //����ҷ��ӵ�����Boss
    public void checkBulletsHitBoss(ConcurrentLinkedQueue<Bullets> BulletsQueue) {
        PlayerPlane plane = Mothership.BossMotherShip;
        for (Bullets b : BulletsQueue) {
            if (0 > plane.getX() - b.getX() && b.getX() - plane.getX() < plane.getWidth() && 0 < b.getY() - plane.getY() && b.getY() - plane.getY() < plane.getHeight()) {
                new MusicAndSpecialUtil().musicPlayAndSpecialAdd(plane.getX() + random.nextInt(plane.getWidth()),plane.getY() + random.nextInt(plane.getHeight()),Images.Boom,Constant.SEUNLockLocation);//��������Ч���
                plane.reduceHP(b.getDamage());
                BulletsQueue.remove(b);
                PlayerPlane.pp.addScore(5);
            }
        }
    }

    //���л����һ���ײ
    public void checkEnemiesHitPlayer(ConcurrentLinkedQueue<PlayerPlane> PlaneQueue) {
        PlayerPlane p = PlayerPlane.pp;
        for (PlayerPlane ep : PlaneQueue) {
            if (0 > p.getX() - ep.getX() && ep.getX() - p.getX() < p.getWidth() && 0 < ep.getY() - p.getY() && ep.getY() - p.getY() < p.getHeight()) {
                new MusicAndSpecialUtil().musicPlayAndSpecialAdd(p.getX(), p.getY(),Images.PlayerHit,Constant.SELockLocation);//��������Ч���
                PlayerPlane.pp.addScore(ep.getScore());
                PlaneQueue.remove(ep);
                specialReduceHp(1);
                //p.reduceHP(1);
                break;
            }
        }
    }

    //���з��ӵ������ҷ�
    public void checkBulletsHitPlayer(ConcurrentLinkedQueue<Bullets> BulletsQueue) {
        PlayerPlane p = PlayerPlane.pp;
        for (Bullets b : BulletsQueue) {
            if (0 > p.getX() - b.getX() && b.getX() - p.getX() < p.getWidth() && 0 < b.getY() - p.getY() && b.getY() - p.getY() < p.getHeight()) {
                new MusicAndSpecialUtil().musicPlayAndSpecialAdd(p.getX(), p.getY(),Images.PlayerHit,Constant.SELockLocation);//��������Ч���
                specialReduceHp(b.getDamage());
                //p.reduceHP(b.getDamage());
                BulletsQueue.remove(b);
            }
        }
    }

    //����ҷ��ӵ����е���
    public void checkPlayerBulletsHitProp(ConcurrentLinkedQueue<Bullets> PlayerBullets, ConcurrentLinkedQueue<SpecialItem> Prop) {
        SpecialEffectsUtil seu = new SpecialEffectsUtil();
        for (Bullets b : PlayerBullets) {
            for (SpecialItem s : Prop) {
                if (0 > s.getX() - b.getX() && b.getX() - s.getX() < s.getWidth() && 0 < b.getY() - s.getY() && b.getY() - s.getY() < s.getHeight()) {
                    PlayerBullets.remove(b);
                    Prop.remove(s);
                    seu.addSpecialEffects(new SpecialEffects(s.getX() + random.nextInt(s.getWidth()), s.getY() + random.nextInt(s.getHeight()), Images.Boom,Constant.SEUNLockLocation));//��ը��Ч
                    new SpecialItemUtil().addBuff(s.getId());
                    break;
                }
            }
        }
    }

    //�ж�boss���������Ƿ���
    public void checkBossCreat() {
        if (PlayerPlane.pp.getScore() > Constant.BossComeScore) {
            Constant.BossCome = true;
            StarFrame.getInstance().StarBoss();
        }
    }

    //���boss����
    public void checkBossDead() {
        PlayerPlane p = Mothership.BossMotherShip;
        if (0 > p.getHp()) {
            System.out.println("BOSS����" + Mothership.BossMotherShip.getHp());
            Constant.STATES = Constant.DEAD;
            User.user.setUserScore(PlayerPlane.pp.getScore());
            new SelectUtil().fallBackReady(true);
        }
    }


    //���ɻ�����
    public void checkPlayerDead() {
        PlayerPlane p = Mothership.BossMotherShip;
        if (0 > PlayerPlane.pp.getHp()) {
            if(Constant.BossCome)
                while( p .getY() > Constant.WindowHeight)
                    p.moveDown();
            System.out.println("�ɻ�����");
            Constant.STATES = Constant.DEAD;
            User.user.setUserScore(PlayerPlane.pp.getScore());
            new SelectUtil().fallBackReady(false);
        }
    }

    //�������Ŀ�Ѫ��ʽ
    private void specialReduceHp(int damage){
        PlayerPlane p = PlayerPlane.pp;
        switch (p.getCampId()) {
            case 1 -> p.reduceHP(Math.max((damage - p.AutoProtect), 1));//����ϴ�ֵ����С�˺�Ϊ1
            case 2 -> p.reduceHP(damage);
            case 3 -> p.reduceDefence(damage);
        }
    }

    //����Ƴ���Ч
    public void checkRemoveSE() {
        SpecialEffectsUtil seu = new SpecialEffectsUtil();
        if (0 == SpecialEffectsUtil.SEList.size()) return;
        for (SpecialEffects se : SpecialEffectsUtil.SEList) {
            seu.remove(System.currentTimeMillis(), se);
        }
    }

    @Override
    public void run() {
        while (Constant.STATES == Constant.STAR) {

            times++;

            checkSpecialItemOutOfBounds(SpecialItemUtil.Prop);
            checkPlaneOutOfBounds(FlyPlaneUtil.EnemiesPlane);
            checkBulletsOutOfBounds(BulletsUtil.PlayerBullets);
            checkBulletsOutOfBounds(BulletsUtil.EnemiesBullets);

            checkBulletsHitEnemies(BulletsUtil.PlayerBullets, FlyPlaneUtil.EnemiesPlane);
            checkBulletsHitPlayer(BulletsUtil.EnemiesBullets);
            checkEnemiesHitPlayer(FlyPlaneUtil.EnemiesPlane);
            checkPlayerBulletsHitProp(BulletsUtil.PlayerBullets, SpecialItemUtil.Prop);

            checkRemoveSE();
            checkPlayerDead();

            if (Constant.BossCome) {
                checkBulletsHitBoss(BulletsUtil.PlayerBullets);
                checkBulletsHitPlayer(BulletsUtil.BossBullets);
                checkBossDead();
            }

            if (!Constant.BossCome)
                checkBossCreat();


        }
    }

}

