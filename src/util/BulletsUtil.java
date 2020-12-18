package util;

import flyingObjects.Bullets;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BulletsUtil {
    public static ConcurrentLinkedQueue<Bullets> PlayerBullets = new ConcurrentLinkedQueue<>();
    public static ConcurrentLinkedQueue<Bullets> EnemiesBullets = new ConcurrentLinkedQueue<>();
    public static ConcurrentLinkedQueue<Bullets> BossBullets = new ConcurrentLinkedQueue<>();

    public void addPlayerBullet(Bullets bullet) {
        PlayerBullets.offer(bullet);
    }

    public void addEnemiesBullet(Bullets bullets) {
        EnemiesBullets.offer(bullets);
    }

    public void addBossBullet(Bullets bullets) {
        BossBullets.offer(bullets);
    }

    public void reInitial() {
        PlayerBullets = new ConcurrentLinkedQueue<>();
        EnemiesBullets = new ConcurrentLinkedQueue<>();
        BossBullets = new ConcurrentLinkedQueue<>();
    }

}
