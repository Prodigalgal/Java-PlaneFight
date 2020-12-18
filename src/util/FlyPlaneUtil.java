package util;

import flyingObjects.PlayerPlane;

import java.util.concurrent.ConcurrentLinkedQueue;

public class FlyPlaneUtil {

    public static ConcurrentLinkedQueue<PlayerPlane> EnemiesPlane = new ConcurrentLinkedQueue<>();

    public void addEnemy(PlayerPlane plane){
        EnemiesPlane.offer(plane);
    }
    public void reInitial(){
        EnemiesPlane = new ConcurrentLinkedQueue<>();
    }
}
