package thread;

import config.Constant;
import entity.user.User;
import flyingObjects.Bullets;
import flyingObjects.PlayerPlane;
import util.BulletsUtil;

public class PlayerThread extends Thread {

    private int times = 0;

    public void moveThread() {
        PlayerPlane p = PlayerPlane.pp;
        if (Constant.DOWN && 1040>=p.getY()+p.getHeight()) {
            p.moveDown();
        }
        if (Constant.UP && 0<=p.getY()) {
            p.moveUp();
        }
        if (Constant.LEFT && 0<=p.getX()) {
            p.moveLeft();
        }
        if (Constant.RIGHT && 1850>=p.getX()+p.getWidth()) {
            p.moveRight();
        }
    }

    public void creatPlayerBullets() {
        //生成我方子弹
        PlayerPlane p = PlayerPlane.pp;
        BulletsUtil bu = new BulletsUtil();
        new MusicThread().Fire.start();
        if(Constant.FireModel == Constant.FireModelA) {
           bu.addPlayerBullet(new Bullets(p.getX()+p.getWidth()/2, p.getY(), p.getBulletImage(), p.getBulletSpeed(),Constant.CENTERB,Constant.BulletDamage,Constant.NormalBullet));
        }
        if(Constant.FireModel == Constant.FireModelB) {
            addBullet(p, bu);
        }
        if(Constant.FireModel == Constant.FireModelC) {
            bu.addPlayerBullet(new Bullets(p.getX()+p.getWidth()/2, p.getY(), p.getBulletImage(), p.getBulletSpeed(),Constant.CENTERB,Constant.BulletDamage,Constant.NormalBullet));
            addBullet(p, bu);
        }
        if(Constant.FireModel == Constant.FireModelD) {
            bu.addPlayerBullet(new Bullets(p.getX()+p.getWidth()/2, p.getY(), p.getBulletImage(), p.getBulletSpeed(),Constant.CENTERB,Constant.BulletDamage,Constant.NormalBullet));
            addBullet(p,bu);
            bu.addPlayerBullet(new Bullets(p.getX()+p.getWidth()/2, p.getY(), p.getBulletImage(), p.getBulletSpeed(),Constant.LEFT45B,Constant.BulletDamage,Constant.NormalBullet));
            bu.addPlayerBullet(new Bullets(p.getX()+p.getWidth()/2, p.getY(), p.getBulletImage(), p.getBulletSpeed(),Constant.RIGHT45B,Constant.BulletDamage,Constant.NormalBullet));
        }

    }

    private void addBullet(PlayerPlane p, BulletsUtil bu) {
        bu.addPlayerBullet(new Bullets(p.getX()+p.getWidth()/2+20, p.getY(), p.getBulletImage(), p.getBulletSpeed(), Constant.CENTERB,Constant.BulletDamage,Constant.NormalBullet));
        bu.addPlayerBullet(new Bullets(p.getX()+p.getWidth()/2-20, p.getY(), p.getBulletImage(), p.getBulletSpeed(),Constant.CENTERB,Constant.BulletDamage,Constant.NormalBullet));
    }

    public void movePlayerBullets() {
        //移动我方子弹
        if(BulletsUtil.PlayerBullets.isEmpty()) return;
        for (Bullets bullet : BulletsUtil.PlayerBullets) {
            switch (bullet.getDirect()) {
                case Constant.CENTERB -> bullet.moveUp();
                case Constant.LEFT45B -> bullet.moveL30U();
                case Constant.RIGHT45B -> bullet.moveR30U();
            }
        }
    }

    public void advantageSkills(){
        PlayerPlane p = PlayerPlane.pp;
        User u = User.user;
        switch (p.getCampId()) {
            case 3 -> {
                System.out.println("回复一点护盾");
                if(p.getDefenceHp() < (int) (User.user.getPlaneHP()*0.5))
                    p.addDefence(p.AutoDefence);
            }
            case 2 -> {
                System.out.println("回复一点生命值");
                if(p.getHp() < u.getPlaneHP())
                    p.addHP(p.AutoHp);
            }
        }
    }

    @Override
    public void run() {
        while (Constant.STATES == Constant.STAR) {

            times++;
            moveThread();
            movePlayerBullets();

            if (0 == times % 5)
                creatPlayerBullets();

            if(0 == times % 500)
                advantageSkills();

            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
