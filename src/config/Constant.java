package config;

import entity.Planes.ProtossPlanes.Phoenix;
import entity.Planes.ProtossPlanes.Tempest;
import entity.Planes.terranPlanes.Battlecruiser;
import entity.Planes.terranPlanes.Viking;
import entity.Planes.zergPlanes.Corruptor;
import entity.Planes.zergPlanes.Mutalisk;
import entity.user.User;

public class Constant {

    public static boolean UP = false;//移动判定
    public static boolean DOWN = false;//移动判定
    public static boolean LEFT = false;//移动判定
    public static boolean RIGHT = false;//移动判定

    public final static int NormalBullet = 0;//普通子弹
    public final static int SpecialBullet = 1;//爆炸子弹

    public final static int LEFT45B = 1;//子弹方向
    public final static int LEFT30B = 2;//子弹方向
    public final static int CENTERB = 3;//子弹方向
    public final static int RIGHT30B = 4;//子弹方向
    public final static int RIGHT45B = 5;//子弹方向

    public final static int directUR = 1;//飞机出现位置
    public final static int directUL = 2;//飞机出现位置
    public final static int directDL = 3;
    public final static int directDR = 4;
    public final static int directC = 0;//飞机出现位置

    public static final int STAR = 2;//开始
    public static final int DEAD = 3;//死亡
    public static int STATES = DEAD;//默认状态

    public static boolean BossCome = false;//boss出现标记
    public static final int BossComeScore = 2000;//boss出现时分数
    public static final int BossLevelUp = 1500;//boss开启第二射击模式
    public static final int LEVEL2 = 100;//第二级分数
    public static final int LEVEL3 = 200;//第二级分数
    public static final int BossHP = 3000;//Boss血量

    public static final int WindowWidth = 1850;//窗口大小
    public static final int WindowHeight = 1080;//窗口大小

    public static final int EnemiesDamage = 2;
    public static int BulletDamage;
    public static int FireModel = 1;//玩家默认发射模式
    public static int FireModelA = 1;//玩家发射模式A
    public static int FireModelB = 2;//玩家发射模式B
    public static int FireModelC = 3;//玩家发射模式C
    public static int FireModelD = 4;//玩家发色模式D


    public final static int VikingSpeed = 10;
    public final static int BattlecruiserSpeed = 20;
    public final static int PhoenixSpeed = 10;
    public final static int TempestSpeed = 20;
    public final static int CorruptorSpeed = 20;
    public final static int MutaliskSpeed = 10;

    public final static int SEUNLockLocation = 0;
    public final static int SELockLocation = 1;

    public static int once = 0;//启动一次游戏，只看一次过场动画

    //重新初始化
    public void reInitial(){
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        BossCome = false;
        STATES = DEAD;
        BulletDamage = 2 + User.user.getPlaneDamage();
        FireModel = FireModelA;
        Viking.viking.setSpeed(VikingSpeed);
        Battlecruiser.battlecruiser.setSpeed(BattlecruiserSpeed);
        Phoenix.phoenix.setSpeed(PhoenixSpeed);
        Corruptor.corruptor.setSpeed(CorruptorSpeed);
        Mutalisk.mutalisk.setSpeed(MutaliskSpeed);
        Tempest.tempest.setSpeed(TempestSpeed);
    }

}
