package thread;

import entity.items.AddHp;
import entity.items.BulletSP;
import entity.items.DamagePromote;
import entity.items.SpeedUp;
import flyingObjects.SpecialItem;
import config.Constant;
import util.SpecialItemUtil;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PropThread extends Thread {

    private SpecialItemUtil pu = new SpecialItemUtil();
    private int times = 0;
    private int direct = 1;
    private Random random = new Random();

    public void moveProp(ConcurrentLinkedQueue<SpecialItem> Prop){
        if(0==Prop.size()) return;
        for (SpecialItem s : Prop) {
            switch (direct) {
                case 1: if(0<s.getX()){s.moveL30D();break;}
                case 2: if(0<s.getX()){s.moveL45D();break;}
                case 3: if(Constant.WindowWidth>s.getX()){s.moveR30D();break;}
                case 4: if(Constant.WindowWidth>s.getX()){s.moveR45D();break;}
            }
        }
    }

    public void creatProp(){
        switch (random.nextInt(4) + 1) {
            case 1 -> pu.addProp(new DamagePromote(random.nextInt(1700) + 100, 0));
            case 2 -> pu.addProp(new SpeedUp(random.nextInt(1700) + 100, 0));
            case 3 -> pu.addProp(new AddHp(random.nextInt(1700) + 100, 0));
            case 4 -> pu.addProp(new BulletSP(random.nextInt(1700) + 100, 0));
        }
    }

    @Override
    public void run() {
        while (Constant.STATES == Constant.STAR) {
            times++;
            moveProp(SpecialItemUtil.Prop);

            if(0 == times % 15) direct = random.nextInt(3)+1;
            if(0 == times % 30) creatProp();

            try {
                sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
