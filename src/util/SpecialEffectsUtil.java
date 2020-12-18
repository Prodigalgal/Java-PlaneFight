package util;

import flyingObjects.SpecialEffects;

import java.util.concurrent.ConcurrentLinkedQueue;

public class SpecialEffectsUtil {

    public static ConcurrentLinkedQueue<SpecialEffects> SEList = new ConcurrentLinkedQueue<>();

    public void addSpecialEffects(SpecialEffects se){
        SEList.offer(se);
    }

    public  void remove(long nowTime,SpecialEffects se) {
        if (1000 <= nowTime - se.getBirthTime())
            SEList.remove(se);
    }

    public void reInitial() {
        SEList = new ConcurrentLinkedQueue<>();
    }

}
