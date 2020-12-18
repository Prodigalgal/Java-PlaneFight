package util;

import config.Constant;
import config.Images;
import flyingObjects.PlayerPlane;
import flyingObjects.SpecialEffects;
import flyingObjects.SpecialItem;

import java.util.concurrent.ConcurrentLinkedQueue;

public class SpecialItemUtil {
    //道具工具类
    public static ConcurrentLinkedQueue<SpecialItem> Prop = new ConcurrentLinkedQueue<>();

    public void FireModel() {
        if (Constant.FireModel == Constant.FireModelA)
            Constant.FireModel = Constant.FireModelB;
        else if (Constant.FireModel == Constant.FireModelB)
            Constant.FireModel = Constant.FireModelC;
        else if(Constant.FireModel == Constant.FireModelC)
            Constant.FireModel = Constant.FireModelD;
        else if(Constant.FireModel == Constant.FireModelD)
            Constant.BulletDamage++;
    }

    public void addBuff(int id) {
        PlayerPlane p = PlayerPlane.pp;
        switch (id) {
            case 1 -> Constant.BulletDamage++;
            case 2 -> p.addSpeed();
            case 3 -> {
                p.addHP(1);
                new SpecialEffectsUtil().addSpecialEffects(new SpecialEffects(p.getX(), p.getY(), Images.HPse, Constant.SELockLocation));
            }//治疗特效
            case 4 -> new SpecialItemUtil().FireModel();
        }
    }

    public void addProp(SpecialItem specialItem) {
        Prop.offer(specialItem);
    }

    public void reInitial() {
        Prop = new ConcurrentLinkedQueue<>();
    }
}
